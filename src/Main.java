import com.item.*;
import com.personagem.inimigo.*;
import com.personagem.player.*;
// import com.missao.*;
// import com.personagem.player.*;

public class Main{

    public static void main(String[] args){

        Item i2 = new ItemBuilder("Espada de Ferro", TipoItem.ARMAMENTO, Raridade.LENDARIO)
                  .with_strength(50)
                  .totalQuantity(1)
                  .build();
        System.out.println(i2);


        // TEST #3
        System.out.println("\n\n\n    TEST #3 -> Testing enimies and attacks");
        Player a4 = new Guerreiro("Elias", 100, 90);
        Inimigo goblin = new Goblin("Gob");

        a4.attack(goblin);
        goblin.attack(a4);

        System.out.println(goblin);

        a4.attack(goblin);

        System.out.println(goblin);

        Inimigo clecio = new Esqueleto("Clecio the calcio", 101, 7);

        a4.attack(clecio);

        System.out.println(clecio);

        a4.attack(clecio);
        System.out.println(clecio);

        a4.attack(clecio);
        System.out.println(clecio);
    }

}
