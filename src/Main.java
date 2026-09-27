import game.gamemaster.*;

public class Main{

    public static void main(String[] args){

        GameMaster gm = new GameMaster();
        gm.starting_game();
        while(!gm.has_ended()){
            gm.game_loop();
        }

    }

}
