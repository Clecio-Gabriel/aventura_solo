package com.personagem;

import com.item.Item;
import com.personagem.inventario.Inventario;
import java.util.ArrayList;

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
    public final void add_item(Item item){
        inv.add_item(item);
        System.out.printf("%s got an item!%nItem: %s%n%n", this.name, item);
    }
    public final void starting_inventory(ArrayList <Item> items){
        this.inv = new Inventario();
        for (Item item : items)
            inv.add_item(item);
    }
    // public abstract String atacar();

    // [ III ] OVERRIDE METHODS
    @Override
    public abstract String toString();

}