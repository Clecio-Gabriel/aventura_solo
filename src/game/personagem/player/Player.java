package game.personagem.player;

import java.util.Objects;

import game.item.Item;
import game.missao.*;
import game.personagem.Personagem;
import game.personagem.inventario.Inventario;

import java.util.ArrayList;

public abstract class Player extends Personagem{

    private Inventario inv;
    private Missao mission;
    private int gold;

    // [ I ] CONSTRUCTORS
    public Player(String name, int life){
        super(name, life);
        this.inv = new Inventario();
        this.gold = 0;
    }
    public Player(String name){
        this(name, 100);
    }

    // [ II ] METHODS
    protected Missao get_missao(){ return this.mission; }
    protected final int gold_qnty(){ return this.gold; }
    public void show_inventory(){
        System.out.printf("   ===%s's inventory===%n%s%n", this.get_name(), (this.inv.empty()) ? ("   Empty.") : this.inv);
    }

    public final void add_item(Item item){
        inv.add_item(item);
        System.out.printf("%s got an item!%nItem: %s%n%n", this.get_name(), item);
    }
    public final void starting_inventory(ArrayList <Item> items){
        this.inv = new Inventario();
        for (Item item : items)
            inv.add_item(item);
    }
    public void add_money(int money){
        if (money < 0){
            throw new IllegalArgumentException("Illegal argument for the add_money method.");
        }

        this.gold += money;
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
    public void die(){
        System.out.printf("%s died.", this.get_name());
    }

}
