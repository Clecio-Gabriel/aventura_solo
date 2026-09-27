package com.personagem.player;

import com.personagem.Personagem;

public class Mago extends Player{

    private int mana;

    public Mago(String name){
        super(name, 100);
    }
    public Mago(String name, int life){
        super(name, life);
    }

    @Override
    public void attack(Personagem target){}

}
