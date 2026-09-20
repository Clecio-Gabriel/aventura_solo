import com.personagem.inimigo.Inimigo;

public class Esqueleto extends Inimigo{

    private final int strength;

    public Esqueleto(String name){
        super(name, 100);
        this.strength = 10;
    }
    public Esqueleto(String name, int life, int strength){
        super(name, life);

        this.strength = strength;
    }

    @Override
    public void attack(){

    }

    @Override
    public String toString(){
        return String.format("");
    }
}