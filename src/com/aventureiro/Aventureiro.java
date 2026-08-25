package com.aventureiro;

import enums.estadomissao.EstadoMissao;

public class Aventureiro {
    private final String nome;
    private float vida;
    private EstadoMissao missao;


    public Aventureiro(String nome){
        this.nome = nome;
        this.vida = 100;
        this.missao = EstadoMissao.INATIVO;
    }

    public String getNome(){
        return this.nome;
    }

    public float getVida(){
        return this.vida;
    }
}
