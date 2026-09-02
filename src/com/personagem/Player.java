package com.personagem;

import com.missao.*;
import java.util.Objects;

public class Player extends Personagem{
    
    private Missao mission;

    // [ I ] CONSTRUCTORS
    public Player(String name){
        super(name, 100);
    }
    public Player(String name, int life){
        super(name, life);
    }

    // [ II ] METHODS
    public void set_mission(Missao mission){
        this.mission = Objects.requireNonNull(mission);
        this.mission.startMission();
        System.out.printf("%s accepted a mission!%nMission:%n%s%n%n", this.name, this.mission);
    }
    public void end_mission(){
        Recompensa prize = this.mission.endMission();
        inv.add_item(prize.receive());
        mission = null;
        System.out.printf("MISSION SUCCESS!\nWell done, %s.%n%n", this.name);
    }

    // [ III ] OVERRIDE METHODS
    @Override
    public String toString(){
        return String.format("%s (%d Energy left.).%nActive Mission:%n%s%n   ===%s's inventory===%n%s", this.name, 
                             this.life, (this.mission == null) ? ("Sem missão ativa.") : this.mission, 
                             this.name, (this.inv.empty()) ? ("   Empty.") : this.inv
                            );
    }

}