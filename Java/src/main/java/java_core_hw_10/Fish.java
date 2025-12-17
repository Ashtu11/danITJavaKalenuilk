package java_core_hw_10;

import java.util.Set;

public class Fish extends Pet {
    public Fish() { super(); this.species = Species.FISH; }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, Species.FISH, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("... (silent swim) ...");
    }
}