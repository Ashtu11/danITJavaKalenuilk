package Java_core_hw6;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat() {
        super();
        setSpecies(Species.DOMESTIC_CAT);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOMESTIC_CAT);
    }

    @Override
    public void respond() {
        System.out.println("Мяу! Я - " + getNickname() + ", я скучив(ла)!");
    }

    @Override
    public void foul() {
        System.out.println("Кіт зробив гидоту — треба прибрати...");
    }
}
