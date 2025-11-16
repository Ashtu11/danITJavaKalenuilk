package java_core_hw_7;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.ROBOCAT;
    }

    @Override
    public void respond() {
        System.out.println("Beep-boop! I'm RoboCat model X9. Hello, human!");
    }

}
