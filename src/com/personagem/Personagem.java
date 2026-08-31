package com.personagem;

import com.personagem.inventario.Inventario;
import com.missao.Recompensa;

public class Personagem{

    protected final String name;
    protected int life;
    protected Inventario inv;

    // [ I ] CONSTRUCTORS
    public Personagem(String name){
        this(name, 100);
    }
    public Personagem(String name, int life){
        this.name = name;
        this.life = life;
        this.inv = new Inventario();
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