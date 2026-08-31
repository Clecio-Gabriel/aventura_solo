package com.missao;

import java.util.Objects;
import com.item.*;

public final class Recompensa {
    private final Item item;

    // [ I ] CONSTRUCTORS
    public Recompensa (Item item){
        this.item = Objects.requireNonNull(item);
    }
    public Recompensa(String item, int quantidade, TipoItem tipo, Raridade raridade){
        this.item = new Item(item, tipo, raridade, quantidade);
    }

    // [ II ] METHODS
    public Item receive(){
        return item;
    }

    // [ III ] OVERRIDE METHODS
    @Override
    public String toString(){
        return item.toString();
    }
}
