package com.item;

import java.util.Objects;

public class Item{

    //DATA    
    private final String name;
    private final TipoItem type;
    private final Raridade rarity;
    private int quantity;

    public Item(String name, TipoItem type, Raridade rarity, int quantity){
        this.name = Objects.requireNonNull(name).trim();
        if (this.name.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        this.type = Objects.requireNonNull(type);
        this.rarity = Objects.requireNonNull(rarity);
        
        if (!(quantity>=1))
            throw new IllegalArgumentException("A quantia deve ser maior ou igual a 1.");
        this.quantity = quantity;

    }

};