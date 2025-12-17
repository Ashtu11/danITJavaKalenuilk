package Java_core_hw_5;

public class Fish extends Pet{
    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.FISH;
    }
}
