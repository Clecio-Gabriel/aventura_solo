package game.item;

import game.personagem.Personagem;

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
    public final String get_name(){ return this.name; }
    public final Raridade get_raridade(){ return this.rarity; }
    public final int get_quantity() { return quantity; }

    public abstract void interact(Personagem p);
    public void change_qnty(int diff){
        if (this.quantity - diff < 0){
            throw new IllegalArgumentException("You can't have a negative ammount of items.");
        }

        this.quantity += diff;
    }

    @Override
    public abstract String toString();

};
