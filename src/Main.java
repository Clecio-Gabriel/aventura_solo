// import com.personagem.*;
// import com.inventario.*;
// import com.missao.*;
import com.recompensa.*;

public class Main{

    public static void main(String[] args){
        Recompensa premio = new Recompensa("Poção", 1, TipoItem.CONSUMIVEL, Raridade.COMUM);
        System.out.println(premio);

    }

}