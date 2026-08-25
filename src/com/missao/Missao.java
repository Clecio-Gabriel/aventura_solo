package com.missao;

import java.util.Objects;

import com.recompensa.Recompensa;

public class Missao{

    private final String title;
    private final Recompensa prize;
    private boolean finished;

    public Missao(String t, Recompensa p){
        this.title = Objects.requireNonNull(t).trim();
        if (this.title.isEmpty()){
            throw new IllegalArgumentException("Title can't be empty.");
        }
        this.prize = p;
        this.finished = false;
    }

    public Recompensa endMission(){
        if (finished)
            throw new IllegalStateException("Mission has already been finished.");
        finished = true;
        System.out.println("Mission finished.");
        return prize;
    }

    @Override
    public String toString(){
        return String.format("Mission:\n%s\nPrize: \n%s\nFinished:%b", title, prize, finished);
    }

}