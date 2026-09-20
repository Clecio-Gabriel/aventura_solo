package com.item.types;

import com.item.*;

public final class Armamento extends Item{

    private int strength;

    public Armamento(String name, Raridade rarity, int quantity, int strength){
        super(name, rarity, quantity);
        this.strength = Math.max(0, Math.min(strength, 50));
    }

    @Override
    public String toString(){
        return String.format("%s | Armamento | Raridade: %s | Quantidade: %d%nForça: %d",
                             this.get_name(), this.get_raridade(), this.get_quantity(), this.strength);
    }
}
