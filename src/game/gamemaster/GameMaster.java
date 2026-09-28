package game.gamemaster;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import game.item.*;
import game.missao.*;
import game.personagem.player.*;
import game.personagem.inimigo.*;

public class GameMaster{

    private Player main_player;
    private ArrayList < Missao > missoes;
    private ArrayList < Inimigo > enemies;
    private boolean has_ended;
    private Scanner scan;

    public GameMaster(Scanner scan){ //will probably do a parser for this, after some time
        this.scan = scan;
        this.enemies = new ArrayList<>();
        this.missoes = new ArrayList<>();
        this.has_ended = false;

        // FIRST MISSION
        Item p1 = new ItemBuilder("Poção de cura", TipoItem.CONSUMIVEL, Raridade.RARO)
                  .with_heal(50)
                  .build();
        Recompensa r1 = new Recompensa(p1, 100);
        Missao m1 = new Missao("Mate o goblin da floresta.", r1);
        missoes.add(m1);
        Inimigo i1 = new Goblin("Jorge");
        enemies.add(i1);

        // SECOND MISSION
        Item p2 = new ItemBuilder("Espada de Diamante", TipoItem.ARMAMENTO, Raridade.LENDARIO)
                  .with_strength(20)
                  .build();
        Recompensa r2 = new Recompensa(p2, 12000000);
        Missao m2 = new Missao("Mate o cadáver que teve sua carne roída por vermes.", r2);
        missoes.add(m2);
        Inimigo i2 = new Esqueleto("Brás Cubas");
        enemies.add(i2);

    }

    public boolean has_ended(){ return this.has_ended; }

    public void starting_game(){

        System.out.printf("    === AVENTURA SOLO ===\n\n\n"
                         + "    Escolha o nome do seu personagem:\n");

        boolean correct_inp = false;

        String name;
        //  [ 1 ] getting the character's name
        do{
            System.out.printf("  > ");
            name = scan.nextLine();
            if (name.isBlank()){
                System.out.println("    Você não digitou um nome... tente novamente.");
            }
            else{
                correct_inp = true;
            }
        }while(!correct_inp);
        System.out.printf("\n    Então, %s foi o nome que você escolheu...\n"
                        + "    Com que classe você quer jogar?\n"
                        + "    1 - Guerreiro\n"
                        + "    2 - Mago\n"
                        + "    3 - Arqueiro\n\n", name);

        //   [ 2 ] Getting the character's class
        //   [ 2.1 ] Making the player choose
        correct_inp = false;
        int option = 0;
        do{
            try{
                System.out.printf("  > ");
                option = scan.nextInt();
                if (option < 1 || option > 3){
                    System.out.println("    Esse número não é válido... tente novamente.");
                }
                else correct_inp = true;
            }catch(InputMismatchException e){
                System.out.println("    Isso não é um número... tente novamente.");
                scan.nextLine();
            }
        }while(!correct_inp);

        //   [ 2.2 ] Based on his choice, create the Player object and display.
        String chosen_class = "";
        switch(option){
            case 1:
                chosen_class = "Guerreiro";
                this.main_player = new Guerreiro(name);
                break;
            case 2:
                chosen_class = "Mago";
                this.main_player = new Mago(name);
                break;
            case 3:
                chosen_class = "Arqueiro";
                this.main_player = new Arqueiro(name);
                break;
        }
        System.out.printf("    Então, você escolheu ser um %s.\n"
                        + "    Ok, agora podemos iniciar o jogo.\n\n", chosen_class);

    }

    public void game_loop(){
        System.out.println("INICIANDO O JOGO...\n\n");
        for (int i = 0; i < missoes.size(); i++){
            Missao curr_mis = missoes.get(i);
            this.main_player.set_mission(curr_mis);
            System.out.printf("\n[ %d ] Missão:\n%s%n%n", (i + 1), curr_mis);
            scan.nextLine();

            Inimigo curr = enemies.get(i);
            boolean in_fight = true;
            while(in_fight){
                System.out.printf("\nINIMIGO: %s\n\nO que você deseja fazer?\n"
                                + "    1 - Atacar\n"
                                + "    2 - Usar Item\n"
                                + "    3 - Ver Inventário\n"
                                + "    4 - Ver Status\n", curr);

                boolean correct_inp = false;
                int action = 0;
                do{
                    try{
                        System.out.printf("  > ");
                        action = scan.nextInt();
                        if (action < 1 || action > 4){
                            System.out.println("    Essa ação não existe. Tente novamente.");
                        }
                        else correct_inp = true;
                    }catch(InputMismatchException e){
                        System.out.println("    Isso não é um número... tente novamente.");
                        scan.nextLine();
                    }
                }while(!correct_inp);

                System.out.println();
                switch(action){
                    case 1:
                        this.main_player.attack(curr);
                        if (curr.isAlive())
                            curr.attack(this.main_player);
                        break;
                    case 2:
                        if (this.main_player.howmanyItems() == 0){
                            System.out.println("Você não tem nenhum item.\n");
                            break;
                        }
                        System.out.println("Que item você deseja usar?(Digite -1 se quiser sair desse menu)");
                        correct_inp = false;
                        int idx = 0;
                        do{
                            try{
                                System.out.printf("  > ");
                                idx = scan.nextInt();
                                if (idx == -1) break;
                                else if (idx < 1 || idx > this.main_player.howmanyItems()){
                                    System.out.println("    Você nem tem esse tanto de itens. Tente novamente.");
                                }
                                else correct_inp = true;
                            }catch(InputMismatchException e){
                                System.out.println("    Isso não é um número... tente novamente.");
                                scan.nextLine();
                            }
                        }while(!correct_inp);

                        if (idx != -1)
                            this.main_player.use_item(idx - 1);

                        break;
                    case 3:
                        this.main_player.show_inventory();
                        break;
                    case 4:
                        System.out.println(this.main_player + "\n");
                        break;
                }

                if (!curr.isAlive()){
                    this.main_player.end_mission();
                    in_fight = false;
                }

                if (!this.main_player.isAlive()){
                    this.has_ended = true;
                    System.out.println("\n\n    Infelizmente, não foi dessa vez.\n"
                                    +  "Tente mais uma vez o nosso jogo, aventureiro.\n");
                    return;
                }

            }

        }

        has_ended = true;

    }

    public void ending_screen(){
        System.out.println("    Parabéns Aventureiro!\n"
                         + "    Você foi capaz de concluir o nosso jogo.\n"
                         + "    Espero que você tenha gostado");
    }

}
