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
    public int get_life(){ return this.life; }

    public void takeDamage(int hit){
        this.life -= hit;
        System.out.printf("%s took %d damage! Life: %d", this.name, hit, this.life);
        if(this.life <= 0){
            die();
        }
    }

    public abstract void attack(Personagem p);
    public abstract void die();

    // [ III ] OVERRIDE METHODS
    @Override
    public abstract String toString();

}
