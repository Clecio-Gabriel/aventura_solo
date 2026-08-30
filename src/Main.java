// import com.inventario.*;


import com.missao.*;
import com.personagem.*;
import com.recompensa.*;

public class Main{

    public static void main(String[] args){
        Recompensa premio = new Recompensa("Poção", 1, TipoItem.CONSUMIVEL, Raridade.COMUM);
        System.out.println(premio);

        Aventureiro a1 = new Aventureiro("Jonas");
        System.out.println(a1 + "\n\n");

        Aventureiro a2 = new Aventureiro("Roberto", 20);
        Missao miss = new Missao("Mate o caba", premio);
        a2.set_mission(miss);
        System.out.println(a2);
        a2.rest();
        System.out.println("\nAFTER RESTING:\n" + a2);

    }

}