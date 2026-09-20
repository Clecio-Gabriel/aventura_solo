package com.personagem;

public abstract class Personagem{

    private final String name;
    protected int life;

    // [ I ] CONSTRUCTORS
    public Personagem(String name, int life){
        this.name = name;
        this.life = life;
    }

    // [ II ] METHODS
    protected final String get_name(){ return this.name; }

    // [ III ] OVERRIDE METHODS
    @Override
    public abstract String toString();

}
