import game.item.*;
import game.personagem.*;
import game.personagem.inimigo.*;
import game.personagem.player.*;

public class Main{

    public static void main(String[] args){

        Item i2 = new ItemBuilder("Espada de Ferro", TipoItem.ARMAMENTO, Raridade.LENDARIO)
                  .with_strength(50)
                  .totalQuantity(1)
                  .build();
        System.out.println(i2);

        Player p1 = new Guerreiro("Paulo");
        System.out.println(p1 + "\n");
        p1.add_item(i2);
        p1.show_inventory();

    }

}
