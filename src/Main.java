import java.util.Scanner;
import game.gamemaster.GameMaster;

public class Main{

    public static void main(String[] args){

        try(Scanner scan = new Scanner(System.in)){
            GameMaster gm = new GameMaster(scan);
            gm.starting_game();
            while(!gm.has_ended()){
                gm.game_loop();
            }
        }

    }

}
