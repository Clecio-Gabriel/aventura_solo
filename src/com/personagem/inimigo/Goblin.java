package com.personagem.inimigo;

import com.personagem.Personagem;

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
    public void attack(Personagem target){
        System.out.printf("%s attack furiously!", this.get_name());
        target.takeDamage(this.strength);
    }

    @Override
    public void die(){
        System.out.printf("%s died and dropped some gold coins.");
        //possibilidade de implementar ganho de moedas
    }

    @Override
    public String toString(){
        return String.format("%s | life: %d | is alive: %b", get_name(), life, isAlive());
    }
}
