package game.personagem.player;

import game.personagem.Personagem;

public class Guerreiro extends Player{

    private int strength;

    public Guerreiro(String name){
        this(name, 100, 15);
    }
    public Guerreiro(String name, int life, int strength){
        super(name, life);
        this.strength = strength;
    }

    @Override
    public void attack(Personagem target){
        System.out.printf("%s attacks %s.\n", this.get_name(), target.get_name());
        target.takeDamage(this.strength);
    }
    @Override
    public String toString(){
        return String.format("%s (%d Energy left.).%nClasse: Guerreiro  | Força: %d%nGold: %d%nActive Mission:%n%s",
                             this.get_name(), this.get_life(),
                             this.strength, this.gold_qnty(),
                             (this.get_missao() == null) ? ("Sem missão ativa.") : this.get_missao()
                            );
    }

}
