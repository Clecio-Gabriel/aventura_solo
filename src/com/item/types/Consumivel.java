package com.item.types;

import com.item.*;

public final class Consumivel extends Item{

    private final int heal;

    public Consumivel(String name, Raridade rarity, int quantity, int heal){
        super(name, rarity, quantity);
        this.heal = Math.max(0, Math.min(heal, 100));
    }

    @Override
    public String toString(){
        return String.format("%s | Consumível | Raridade: %s | Quantidade: %d%nCura: %d",
                             this.get_name(), this.get_raridade(), this.get_quantity(), this.heal);
    }
}
