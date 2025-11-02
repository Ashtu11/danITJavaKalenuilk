package Java_core_hw6;

public class Dog extends Pet implements Foulable {

    public Dog() {
        super();
        setSpecies(Species.DOG);
    }

    public Dog(String nickname) {
        super(nickname);
        setSpecies(Species.DOG);
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Гав-гав! Я твій собака, " + getNickname() + "!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}

