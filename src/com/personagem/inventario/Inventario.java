package com.personagem.inventario;

import java.util.ArrayList;
import java.util.Objects;
import com.item.Item;

public class Inventario {
    
    //===DATA
    private ArrayList<Item> items;
    private int item_qnt;

    //  [ I ] CONSTRUCTOR
    public Inventario(){
        this.items = new ArrayList<>();
        this.item_qnt = 0;
    }

    //  [ II ] METHODS
    public void add_item(Item item){
        Item inp = Objects.requireNonNull(item);
        items.add(inp);
        this.item_qnt++;
    }
    public void print_inv(){
        System.out.println("    ====Inventory contents====\n");
        for (int i = 0; i < item_qnt; i++){
            System.out.printf("#%d   %s%n", i+1, items.get(i));
        }
    }

}
