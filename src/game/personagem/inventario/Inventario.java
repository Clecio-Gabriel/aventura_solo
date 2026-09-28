package game.personagem.inventario;

import java.util.LinkedList;
import java.util.Objects;

import game.item.Item;

public class Inventario {

    //===DATA
    private final LinkedList<Item> items;

    //  [ I ] CONSTRUCTOR
    public Inventario(){
        this.items = new LinkedList<>();
    }

    //  [ II ] METHODS
    public void add_item(Item item){
        Item inp = Objects.requireNonNull(item); // will need to do smth to avoid duplicate items
        items.add(inp);
    }
    public Item get(int idx){
        Item used = items.get(idx);
        items.remove(idx);
        return used;
    }
    public boolean empty(){ return items.isEmpty(); }
    public int size(){ return items.size(); }

    //  [ III ] OVERRIDE METHODS
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        int inv_size = items.size();

        for (int i = 0; i < inv_size; i++){
            ret.append(String.format("#%d   %s%n", i+1, items.get(i)));
        }

        return ret.toString();
    }

}
