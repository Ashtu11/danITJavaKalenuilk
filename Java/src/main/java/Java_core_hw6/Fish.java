package Java_core_hw6;

public class Fish extends Pet {

    public Fish() {
        super();
        setSpecies(Species.FISH);
    }

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("... (риба мовчить)");
    }

}
