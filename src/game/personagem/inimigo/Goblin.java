package game.personagem.inimigo;

import game.personagem.Personagem;

public class Goblin extends Inimigo{

    private final int strength;

    public Goblin(String name){
        super(name, 100);
        this.strength = 10;
    }
    public Goblin(String name, int life, int strength){
        super(name, life);

        this.strength = strength;
    }

    @Override
    public void attack(Personagem target){
        System.out.printf("%s attack furiously!\n%d damage given.\n", this.get_name(), this.strength);
        target.takeDamage(this.strength);
    }

    @Override
    public void die(){
        System.out.printf("%s died and dropped some good prizes.\n", this.get_name());
        //possibilidade de implementar ganho de moedas
    }

    @Override
    public String toString(){
        return String.format("%s | GOBLIN | life: %d\n", get_name(), get_life(), isAlive());
    }
}
