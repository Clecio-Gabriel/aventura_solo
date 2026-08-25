package com.personagem;

import com.recompensa.Recompensa;

public class Personagem{

    private final String nome;
    private int energy;

    // [ I ] CONSTRUCTORS
    public Personagem(String nm){
        this(nm, 100);
    }
    public Personagem(String nm, int e){
        this.nome = nm;
        this.energy = e;
    }
    
    // [ II ] METHODS
    public void receive(Recompensa prize){
        this.energy += prize.getEnergy();
    }
    public void rest(){
        this.energy += 10;
    }


    // [ III ] OVERRIDE METHODS

    @Override
    public String toString(){
        return String.format("%s (%d Energy left).", this.nome, this.energy);
    }

}