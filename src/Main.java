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
        System.out.println(m1);

        

    }

}