package com.personagem.inimigo;

public class Goblin extends Inimigo{

    private final int strength;

    public Goblin(String name){
        super(name, 100);
        this.strength = 10;
    }
    public Goblin(String name, int life, int strength){
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
