package java_core_hw_7;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, Species.FISH, trickLevel, age, habits);
    }

    @Override
    public void respond() {
        System.out.println("I am a fish and I do not talk to humans.");
    }
}


