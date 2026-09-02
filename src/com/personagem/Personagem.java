package com.personagem;

import com.item.Item;
import com.personagem.inventario.Inventario;

public abstract class Personagem{

    protected final String name;
    protected int life;
    protected Inventario inv;

    // [ I ] CONSTRUCTORS
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
    public abstract String toString();

}