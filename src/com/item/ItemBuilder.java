package com.item;

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

        if (name == null){
            throw new ItemCreationException("Null was passed as an argument for the name of the item.", new NullPointerException());
        }
        String aux = name.trim();
        if (aux.isEmpty()){
            throw new ItemCreationException("This item was given an empty name.", new IllegalArgumentException());
        }
        this.name = name;

        this.type = type;
        if (type == null){
            throw new ItemCreationException("Null was passed as an argument for type in the \"" + name + "\" item.", new NullPointerException());
        }

        this.rarity = rarity;
        if (rarity == null){
            throw new ItemCreationException("Null was passed as an argument for rarity in the \"" + name + "\" item.", new NullPointerException());
        }

        this.quantity = 1;

    }

    public ItemBuilder totalQuantity(int quantity){
        if(quantity < 1 || quantity > 100){
            throw new ItemCreationException("Invalid argument given to quantity.", new IllegalArgumentException());
        }
        this.quantity = quantity;

        return this;
    }
    public ItemBuilder with_heal(int heal){
        if (type != TipoItem.CONSUMIVEL){
            throw new ItemCreationException("Heal can't be declared in an item that is not a Consumível.", new IllegalArgumentException());
        }
        this.heal = heal;

        return this;
    }
    public ItemBuilder with_defense(int defense){
        if (type != TipoItem.ARMADURA){
            throw new ItemCreationException("Defense can't be declared in an item that is not a Armadura.", new IllegalArgumentException());
        }
        this.defense = defense;

        return this;
    }
    public ItemBuilder with_strength(int strength){
        if (type != TipoItem.ARMAMENTO){
            throw new ItemCreationException("Strength cannot be given to an item that isn't an Armamento", new IllegalArgumentException());
        }

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
                throw new ItemCreationException("The item was not given a valid type.", new IllegalArgumentException());
        }
    }

}
