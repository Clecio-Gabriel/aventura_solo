package game.item.types;

import game.item.*;
import game.personagem.Personagem;

public final class Consumivel extends Item{

    private final int heal;

    public Consumivel(String name, Raridade rarity, int quantity, int heal){
        super(name, rarity, quantity);
        if(heal < 1 || heal > 100){
            throw new ItemCreationException("Invalid value given to heal.", new IllegalArgumentException());
        }

        this.heal = heal;

    }

    @Override
    public void interact(Personagem p){
        p.heal(heal);
        this.change_qnty(-1);
        System.out.printf("\n%s recuperou %d de vida.\n", p.get_name(), this.heal);
    }
    @Override
    public String toString(){
        return String.format("%s | Consumível | Raridade: %s | Quantidade: %d%nCura: %d",
                             this.get_name(), this.get_raridade(), this.get_quantity(), this.heal);
    }
}
