package game.personagem.inimigo;

import game.personagem.Personagem;

public abstract class Inimigo extends Personagem {

    public Inimigo(String name){
        super(name, 100);
    }
    public Inimigo(String name, int life){
        super(name, life);
    }

}
