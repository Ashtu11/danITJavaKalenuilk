package Java_core_hw_5;

public class RoboCat extends Pet {
    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.ROBOCAT;
    }

    @Override
    public void respond() {
        System.out.println("Beep-boop! I'm RoboCat model X9. Hello, human!");
    }

}
