package game.personagem.player;

import game.personagem.Personagem;

public class Arqueiro extends Player{

    private int dexterity;

    public Arqueiro(String name){
        this(name, 100, 15);
    }
    public Arqueiro(String name, int life, int dexterity){
        super(name, life);
        this.dexterity = dexterity;
    }

    @Override
    public void attack(Personagem target){
        System.out.printf("%s attacks %s.\n", this.get_name(), target.get_name());
        target.takeDamage(this.dexterity);
    }
    @Override
    public String toString(){
        return String.format("%s (%d Energy left.).%nClasse: Arqueiro  | Destreza: %d%nGold: %d%nActive Mission:%n%s",
                             this.get_name(), this.get_life(),
                             this.dexterity, this.gold_qnty(),
                             (this.get_missao() == null) ? ("Sem missão ativa.") : this.get_missao()
                            );
    }

}
