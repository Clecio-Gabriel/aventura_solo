package com.item;

import java.util.Objects;

public abstract class Item{

    //DATA
    private final String name;
    private final Raridade rarity;
    private int quantity;

    // [ I ] CONSTRUCTORS
    public Item(String name, Raridade rarity, int quantity){
        this.name = Objects.requireNonNull(name).trim();
        if (this.name.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        this.rarity = Objects.requireNonNull(rarity);

        if (quantity < 1)
            throw new IllegalArgumentException("A quantia deve ser maior ou igual a 1.");
        this.quantity = quantity;

    }

    // [ II ] METHODS
    @Override
    public abstract String toString();

};
