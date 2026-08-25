

public class Main{

    public static void main(String[] args){
        // Personagem p1 = new Personagem("Roberto", 20);
        Personagem p2 = new Personagem("Lucas");
        // System.out.println(p1);
        System.out.println(p2 + "\n");
        // p1.rest();
        // System.out.println("\nAfter resting...\n" + p1);

        Recompensa premio = new Recompensa("Pocão de energia", 30);
        Missao mis = new Missao("Mate o caba.", premio);
        System.out.println(mis + "\n");

        p2.receive(mis.endMission());

        System.out.println("\n" + mis + "\n\n" + p2);

    }

}