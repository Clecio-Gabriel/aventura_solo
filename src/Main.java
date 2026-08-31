import com.item.*;
import com.personagem.inventario.*;
import com.missao.*;
import com.personagem.*;

public class Main{

    public static void main(String[] args){
        Item i1 = new Item("Poção", TipoItem.CONSUMIVEL, Raridade.COMUM, 1);
        System.out.println(i1 + "\n\n");

        Recompensa prize = new Recompensa(i1);
        System.out.println(prize + "\n\n");

        Missao m1 = new Missao("Mate o caba", prize);
        System.out.println(m1 + "\n\n");

        Aventureiro a1 = new Aventureiro("Jorge");
        System.out.println(a1 + "\n\n");

        a1.set_mission(m1);
        System.out.println(a1 + "\n\n");

        Item i2 = new Item("Espada de Madeira", TipoItem.ARMAMENTO, Raridade.COMUM, 1);

        Inventario inv = new Inventario();
        inv.add_item(i1);
        inv.add_item(i2);
        
        inv.print_inv();

    }

}