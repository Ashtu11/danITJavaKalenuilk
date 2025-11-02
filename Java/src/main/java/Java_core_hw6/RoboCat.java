package Java_core_hw6;

public class RoboCat extends Pet implements Foulable {

    public RoboCat() {
        super();
        setSpecies(Species.ROBO_CAT);
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBO_CAT);
    }

    @Override
    public void respond() {
        System.out.println("Beep-boop! Я робот-кіт " + getNickname() + "!");
    }

    @Override
    public void foul() {
        System.out.println("Робот-кіт допустив 'гидоту' — активую очистку системи...");
    }
}