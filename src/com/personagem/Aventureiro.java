package com.personagem;

import java.util.Objects;
import com.missao.Missao;

public class Aventureiro extends Personagem{
    
    private Missao mission;

    // [ I ] CONSTRUCTORS
    public Aventureiro(String name){
        super(name, 100);
    }
    public Aventureiro(String name, int life){
        super(name, life);
    }

    // [ II ] METHODS
    public void set_mission(Missao mission){
        this.mission = Objects.requireNonNull(mission);
        this.mission.startMission();
        System.out.printf("%s accepted a mission!%nMission:%n%s%n%n", this.name, this.mission);
    }
    public void end_mission(){
        // WILL IMPLEMENT THIS IN THE NEAR FUTURE
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