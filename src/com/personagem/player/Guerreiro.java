package com.personagem.player;

import com.personagem.Personagem;

public class Guerreiro extends Player{

    private int strength;

    public Guerreiro(String name){
        super(name, 100);
        this.strength = 15;
    }
    public Guerreiro(String name, int life, int strength){
        super(name, life);
        this.strength = strength;
    }

    @Override
    public void attack(Personagem target){
        System.out.printf("%s attacks %s.\n", this.get_name(), target.get_name());
        target.takeDamage(this.strength);
    }

    @Override
    public void die(){
        System.out.printf("%s died.", this.get_name());
    }
}
