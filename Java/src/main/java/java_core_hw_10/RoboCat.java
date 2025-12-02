package java_core_hw_10;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat() { super(); this.species = Species.ROBOCAT; }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, Species.ROBOCAT, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Beep-boop! I'm RoboCat. Hello, human!");
    }
}