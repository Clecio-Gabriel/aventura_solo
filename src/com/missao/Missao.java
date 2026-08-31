package com.missao;

import java.util.Objects;

public class Missao{

    private final String title;
    private final Recompensa prize;
    private EstadoMissao state;

    public Missao(String title, Recompensa prize){
        this.title = Objects.requireNonNull(title).trim();
        if (this.title.isEmpty()){
            throw new IllegalArgumentException("Missão deve ter um titulo.");
        }

        this.prize = Objects.requireNonNull(prize, "Deve ter um premio.");
        this.state = EstadoMissao.INATIVO;
    }

    // METHODS
    public void startMission(){
        if (state != EstadoMissao.INATIVO)
            throw new IllegalStateException("Missão já está ativa ou foi completada.");
        this.state = EstadoMissao.ATIVO;
    }
    public Recompensa endMission(){
        if (state == EstadoMissao.COMPLETO)
            throw new IllegalStateException("Missão já foi completa.");
        this.state = EstadoMissao.COMPLETO;

        return prize;
    }

    @Override
    public String toString(){
        // return "Titulo: " + title + " | " + prize + " | Estado: " + state;
        return String.format("Título: %s%nRecompensa: %s%nEstado: %s", title, prize, state);
    }
}