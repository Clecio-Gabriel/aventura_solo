package com.personagem.inimigo;

import com.personagem.Personagem;

public abstract class Inimigo extends Personagem {

    public Inimigo(String name){
        super(name, 100);
    }
    public Inimigo(String name, int life){
        super(name, life);
    }

    public boolean isAlive(){
        return this.life > 0;
    }

    @Override
    public abstract String toString();
}
