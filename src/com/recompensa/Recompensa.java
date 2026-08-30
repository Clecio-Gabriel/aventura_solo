package com.recompensa;

import java.util.Objects;

public final class Recompensa {
    private final String item;
    private int quantidade;
    private TipoItem tipo;
    private Raridade raridade;

    // Construtor
    public Recompensa(String item, int quantidade, TipoItem tipo, Raridade raridade){
        this.item = Objects.requireNonNull(item, "Item é obrigatório.").trim();
        this.tipo = Objects.requireNonNull(tipo, "Tipo é obrigatótio.");
        this.raridade = Objects.requireNonNull(raridade, "Raridade é obrigatótio.");

        if(this.item.isEmpty()){
            throw new IllegalArgumentException("Item não pode ficar vazio.");
        }
        if(this.quantidade < 0){
            throw new IllegalArgumentException("Quantidade não ser um valor negativo.");
        }
        
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.raridade = raridade;

    }

    // Getters
    public String getItem(){ return item; }

    public int getQuantidade(){ return quantidade; }

    public TipoItem getTipoItem(){ return tipo; }

    public Raridade getRaridade(){ return raridade; }

    @Override
    public String toString(){
         return "Recompensa: " + item + " | Quantidade: " + quantidade + " | Tipo do item: " + tipo + " | Raridade: " + raridade;
    }
}
