import com.item.*;
import com.item.types.*;
// import com.missao.*;
// import com.personagem.player.*;

public class Main{

    public static void main(String[] args){

        Item i1 = new Armadura("Armadura de Diamante", Raridade.LENDARIO, 1, 20);
        System.out.println(i1);

        Item i2 = new ItemBuilder("Espada de Ferro", TipoItem.ARMAMENTO, Raridade.LENDARIO)
                  .with_strength(50)
                  .totalQuantity(1)
                  .build();
        System.out.println(i2);

    }

}
