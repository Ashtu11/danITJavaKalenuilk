package java_core_hw_10;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    public Dog() { super(); this.species = Species.DOG; }

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, Species.DOG, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Woof! I'm " + nickname + ", your loyal friend!");
    }

    @Override
    public void foul() {
        System.out.println("Oops! I dug a hole in the yard again!");
    }
}