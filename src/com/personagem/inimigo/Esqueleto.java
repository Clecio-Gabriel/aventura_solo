package com.personagem.inimigo;

import com.personagem.Personagem;

public class Esqueleto extends Inimigo{

    private boolean revived;
    private final int strength;

    public Esqueleto(String name){
        super(name, 100);
        this.strength = 7;
        this.revived = false;
    }
    public Esqueleto(String name, int life, int strength){
        super(name, life);
        this.revived = false;
        this.strength = strength;
    }

    @Override
    public void attack(Personagem target){
        System.out.printf("%s throws a bone at you!\n", this.get_name());
        target.takeDamage(this.strength);
    }

    @Override
    public void die(){
        if(!revived){
            System.out.printf("The %s shuddered and collapsed into a pile of bones. But it quickly reassembled itself!\n");
            this.life = 50;
            this.revived = true;
        } else {
            System.out.printf("The %s turned to dust. Among the dust, there were a few gold coins.\n");
            //possibilidade de implementar ganho de moedas
        }
    }
    @Override
    public String toString(){
        return String.format("%s | life: %d | alive: %b | revided: %b\n", this.get_name(), this.get_life(), isAlive(), revived);
    }
}
