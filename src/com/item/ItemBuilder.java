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
            throw new ItemCreationException("Null was passed as an argument for type in the " + name + "item.", new NullPointerException());
        }

        this.rarity = rarity;
        if (rarity == null){
            throw new ItemCreationException("Null was passed as an argument for rarity in the " + name + "item.", new NullPointerException());
        }

        this.quantity = 1;

    }

    public ItemBuilder totalQuantity(int quantity){
        try{
            this.quantity = Math.max(1, Math.min(quantity, 100));
        }catch (IllegalArgumentException e){
            throw new ItemCreationException("Invalid argument given to quantity.", e);
        }

        return this;
    }
    public ItemBuilder with_heal(int heal){
        this.heal = heal;
        if (type != TipoItem.CONSUMIVEL){
            throw new ItemCreationException("Heal can't be declared in an item that is not a consumable.", new IllegalArgumentException());
        }
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
