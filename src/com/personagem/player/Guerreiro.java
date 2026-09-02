package com.personagem.player;

public class Guerreiro extends Player{

    private int strength;

    public Guerreiro(String name){
        super(name, 100);
    }
    public Guerreiro(String name, int life){
        super(name, life);
    }

}