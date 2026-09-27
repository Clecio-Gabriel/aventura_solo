package game.personagem.player;

import game.personagem.Personagem;

public class Mago extends Player{

    private int mana;

    public Mago(String name){
        this(name, 100, 15);
    }
    public Mago(String name, int life, int mana){
        super(name, life);
        this.mana = mana;
    }

    @Override
    public void attack(Personagem target){}
    @Override
    public String toString(){
        return String.format("%s (%d Energy left.).%nClasse: Mago  | Mana: %d%nGold: %d%nActive Mission:%n%s",
                             this.get_name(), this.get_life(),
                             this.mana, this.gold_qnty(),
                             (this.get_missao() == null) ? ("Sem missão ativa.") : this.get_missao()
                            );
    }

}
