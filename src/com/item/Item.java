package com.item;

public abstract class Item{

    //DATA
    private final String name;
    private final Raridade rarity;
    private int quantity;

    // [ I ] CONSTRUCTORS
    public Item(String name, Raridade rarity, int quantity){
        this.name = name;
        this.rarity = rarity;
        this.quantity = quantity;
    }

    // [ II ] METHODS
    protected final String get_name(){ return this.name; }
    protected final Raridade get_raridade(){ return this.rarity; }
    protected final int get_quantity() { return quantity; }
    @Override
    public abstract String toString();

};
