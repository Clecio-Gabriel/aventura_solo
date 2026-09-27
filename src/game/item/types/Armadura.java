package game.item.types;

import game.item.*;
import game.personagem.Personagem;

public final class Armadura extends Item{

    private int defense;

    public Armadura(String name, Raridade rarity, int quantity, int defense){
        super(name, rarity, quantity);
        if(defense < 1 || defense > 100){
            throw new ItemCreationException("Invalid number given to defense.", new IllegalArgumentException());
        }

        this.defense = defense;

    }

    @Override
    public void interact(Personagem p){ };
    @Override
    public String toString(){
        return String.format("%s | Armadura | Raridade: %s | Quantidade: %d%nDefesa: %d",
                             this.get_name(), this.get_raridade(), this.get_quantity(), this.defense);
    }
}
