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

    public GameMaster(){
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

        // SECOND MISSION
        Item p2 = new ItemBuilder("Espada de Diamante", TipoItem.ARMAMENTO, Raridade.LENDARIO)
                  .with_strength(20)
                  .build();
        Recompensa r2 = new Recompensa(p2, 12000000);


    }

    public boolean has_ended(){ return this.has_ended; }

    public void starting_game(){

        System.out.printf("    === AVENTURA SOLO ===\n\n\n"
                         + "    Escolha o nome do seu personagem:\n");

        boolean correct_inp = false;

        try(Scanner scan = new Scanner(System.in)){
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

    }

    public void game_loop(){
        System.out.println("INICIANDO O JOGO...\n\n");
        System.out.println(this.main_player);
        has_ended = true;

    }

}
