package com.item;

import java.util.Objects;
import com.item.types.*;

public final class ItemBuilder{

    private final String name;
    private final TipoItem type;
    private final Raridade rarity;
    private int quantity;

    private int defense;
    private int heal;
    private int strength;

    public ItemBuilder(String name, TipoItem type, Raridade rarity){
        this.name = name;
        this.type = Objects.requireNonNull(type);
        this.rarity = Objects.requireNonNull(rarity);
    }

    public ItemBuilder totalQuantity(int quantity){
        this.quantity = Math.max(0, Math.min(quantity, 64));
        return this;
    }
    public ItemBuilder with_heal(int heal){
        this.heal = heal;
        return this;
    }
    public ItemBuilder with_defense(int defense){
        this.defense = defense;
        return this;
    }
    public ItemBuilder with_strength(int strength){
        this.strength = strength;
        return this;
    }
    public Item build(){
        switch (this.type){
            case TipoItem.ARMADURA:
                return new Armadura(name, rarity, quantity, defense);
            case TipoItem.CONSUMIVEL:
                return new Consumivel(name, rarity, quantity, heal);
            case TipoItem.ARMAMENTO:
                return new Armamento(name, rarity, quantity, strength);
            default:
                throw new IllegalArgumentException("Invalid type of Item.");
        }
    }

}
