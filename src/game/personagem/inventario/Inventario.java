package game.personagem.inventario;

import java.util.LinkedList;
import java.util.Objects;

import game.item.Item;

public class Inventario {

    //===DATA
    private final LinkedList<Item> items;
    private int item_qnt;

    //  [ I ] CONSTRUCTOR
    public Inventario(){
        this.items = new LinkedList<>();
        this.item_qnt = 0;
    }

    //  [ II ] METHODS
    public void add_item(Item item){
        Item inp = Objects.requireNonNull(item); // will need to do smth to avoid duplicate items
        items.add(inp);
        this.item_qnt++;
    }
    public Item get(int idx){
        Item used = items.get(idx);
        items.remove(idx);
        return used;
    }
    public boolean empty(){ return items.isEmpty(); }

    //  [ III ] OVERRIDE METHODS
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < item_qnt; i++){
            ret.append(String.format("#%d   %s%n", i+1, items.get(i)));
        }

        return ret.toString();
    }

}
