package game.missao;

import java.util.Objects;

import game.item.*;

public final class Recompensa {
    private final Item item;
    private final int gold;

    // [ I ] CONSTRUCTORS
    public Recompensa (Item item, int gold){
        this.item = Objects.requireNonNull(item);
        if (gold < 0)
            throw new IllegalArgumentException("You can't have a prize with negative gold. (that's just debt)");

        this.gold = gold;
    }

    // [ II ] METHODS
    public final int get_gold(){ return this.gold; }
    public Item receive(){ return this.item; }

    // [ III ] OVERRIDE METHODS
    @Override
    public String toString(){
        return item.toString();
    }
}
