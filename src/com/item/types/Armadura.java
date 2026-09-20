package com.item.types;

import com.item.*;

public final class Armadura extends Item{

    private int defense;

    public Armadura(String name, Raridade rarity, int quantity, int defense){
        super(name, rarity, quantity);
        this.defense = Math.max(0, Math.min(defense, 100));
    }

    @Override
    public String toString(){
        return String.format("%s | Armadura | Raridade: %s | Quantidade: %i%nDefesa: %i",
                             this.get_name(), this.get_raridade(), this.get_quantity(), this.defense);
    }
}
