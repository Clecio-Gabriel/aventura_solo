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
            correct_inp = false;
            int option;
            while(!correct_inp){
                try{
                    System.out.printf("  > ");
                    option = scan.nextInt();
                    if (option < 1 || option > 3){
                        System.out.println("    Esse número não é válido... tente novamente.");
                    }
                    else
                        correct_inp = true;
                }catch(InputMismatchException e){
                    System.out.println("    Isso não é um número... tente novamente.");
                    scan.nextLine();
                }
            }

        }

    }
    public void game_loop(){
        System.out.println("ENTERED GAME LOOP");
        has_ended = true;
    }

}
