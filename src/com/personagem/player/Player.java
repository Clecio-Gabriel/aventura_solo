package com.personagem.player;

import java.util.Objects;
import java.util.ArrayList;
import com.missao.*;
import com.personagem.Personagem;
import com.item.Item;
import com.personagem.inventario.Inventario;

public abstract class Player extends Personagem{

    private Inventario inv;
    private Missao mission;

    // [ I ] CONSTRUCTORS
    public Player(String name, int life){
        super(name, life);
        this.inv = new Inventario();
    }
    public Player(String name){
        this(name, 100);
    }

    // [ II ] METHODS
    public final void add_item(Item item){
        inv.add_item(item);
        System.out.printf("%s got an item!%nItem: %s%n%n", this.get_name(), item);
    }
    public final void starting_inventory(ArrayList <Item> items){
        this.inv = new Inventario();
        for (Item item : items)
            inv.add_item(item);
    }
    public void set_mission(Missao mission){
        this.mission = Objects.requireNonNull(mission);
        this.mission.startMission();
        System.out.printf("%s accepted a mission!%nMission:%n%s%n%n", this.get_name(), this.mission);
    }
    public void end_mission(){
        Recompensa prize = this.mission.endMission();
        inv.add_item(prize.receive());
        mission = null;
        System.out.printf("MISSION SUCCESS!\nWell done, %s.%n%n", this.get_name());
    }

    // [ III ] OVERRIDE METHODS
    @Override
    public String toString(){
        return String.format("%s (%d Energy left.).%nActive Mission:%n%s%n   ===%s's inventory===%n%s", this.get_name(),
                             this.life, (this.mission == null) ? ("Sem missão ativa.") : this.mission,
                             this.get_name(), (this.inv.empty()) ? ("   Empty.") : this.inv
                            );
    }

}
