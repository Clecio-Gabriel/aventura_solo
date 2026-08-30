package com.personagem;

import com.recompensa.Recompensa;

public class Personagem{

    protected final String name;
    protected int life;

    // [ I ] CONSTRUCTORS
    public Personagem(String name){
        this(name, 100);
    }
    public Personagem(String name, int life){
        this.name = name;
        this.life = life;
    }
    
    // [ II ] METHODS
    public void receive(Recompensa prize){
        // this.energy += prize.getEnergy();
    }
    public void rest(){
        this.life += 10;
    }


    // [ III ] OVERRIDE METHODS

    @Override
    public String toString(){
        return String.format("%s (%d Energy left).", this.name, this.life);
    }

}