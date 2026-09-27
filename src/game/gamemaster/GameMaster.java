package game.gamemaster;

import java.util.Scanner;
import java.util.ArrayList;

import game.item.*;
import game.missao.*;
import game.personagem.player.*;
import game.personagem.inimigo.*;

public class GameMaster{

    Player main_player;
    ArrayList < Inimigo > enemies;
    private boolean has_ended;

    public GameMaster(){
        System.out.println("    === AVENTURA SOLO ===\n\n\n"
                         + "    Escolha o nome do seu personagem:");

        try(Scanner scan = new Scanner(System.in)){

        }

    }

    public boolean has_ended(){ return this.has_ended; }

}
