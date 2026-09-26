package com.personagem.player;

import com.personagem.Personagem;

public class Guerreiro extends Player{

    private int strength;

    public Guerreiro(String name){
        super(name, 100);
    }
    public Guerreiro(String name, int life){
        super(name, life);
    }

    @Override
    public void attack(Personagem target){}

    @Override
    public void die(){}
}
