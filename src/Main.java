import com.item.*;
import com.missao.*;
import com.personagem.player.*;

public class Main{

    public static void main(String[] args){
    
        //  TEST #1
        System.out.println("    TEST #1 -> Testing Items and inventory");
        Item i1 = new Item("Poção", TipoItem.CONSUMIVEL, Raridade.COMUM, 1);
        Item i2 = new Item("Espada de Madeira", TipoItem.ARMAMENTO, Raridade.COMUM, 1);
        System.out.println(i1 + "\n\n" + i2 + "\n\n");

        Player a1 = new Guerreiro("Jorge");
        System.out.println(a1 + "\n\n");

        a1.add_item(i1);
        a1.add_item(i2);

        System.out.println(a1 + "\n\n\n");

        // TEST #2
        System.out.println("    TEST #2 -> Testing Missao and Recompensa");
        Item i3 = new Item("Banana de Combate", TipoItem.ARMAMENTO, Raridade.LENDARIO, 1);
        Recompensa prize = new Recompensa(i3);
        Missao m1 = new Missao("His Name is Pedro", prize);
        System.out.println("Missão criada:\n" + m1 + "\n\n");

        a1.set_mission(m1);

        System.out.println(a1 + "\n\n");

        a1.end_mission();

        System.out.println(a1 + "\n\n");

        Player a3 = new Mago("Ronaldo", 20);
        System.out.println(a3);

    }

}