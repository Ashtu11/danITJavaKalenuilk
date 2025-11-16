package java_core_hw_7;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {
    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOMESTIC_CAT;
    }
    @Override
    public void respond() {
        System.out.println("Meow! I'm " + nickname + ", your lovely cat!");
    }

    @Override
    public void foul() {
        System.out.println("I scratched the couch again... need to hide the evidence!");
    }

}
