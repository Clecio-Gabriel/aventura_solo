import java.util.Objects;

public final class Recompensa {
    private String item;
    private int energy;

    Recompensa(String item, int energy){
        this.item = Objects.requireNonNull(item, "Item é obrigatório").trim();
        if(this.item.isEmpty()){
            throw new IllegalArgumentException("Item não pode ficar vazio.");
        }
        if(this.energy < 0){
            throw new IllegalArgumentException("Energia não ser um valor negativo.");
        }
        this.energy = energy;
    }

    public String getItem(){
        return item;
    }

    public int getEnergy(){
        return energy;
    }

    @Override
    public String toString(){
         return String.format("%s (+%d energia)",item, energy);
    }
}
