package com.personagem;

import com.item.Item;
import com.personagem.inventario.Inventario;

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
    public void add_item(Item item){
        inv.add_item(item);
        System.out.printf("%s got an item!%nItem: %s%n%n", this.name, item);
    }

    // [ III ] OVERRIDE METHODS
    @Override
    public String toString(){
        return String.format("%s (%d Energy left).", this.name, this.life);
    }

}