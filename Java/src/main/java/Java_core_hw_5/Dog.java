package Java_core_hw_5;

public class Dog extends Pet implements Foulable{
    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOG;
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
