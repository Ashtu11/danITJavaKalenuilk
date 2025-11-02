package Java_core_hw6;
import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private Species species = Species.UNKNOWN;
    private String nickname;
    private int age;
    private int trickLevel; // 0..100
    private String[] habits;

    public Pet() {}

    // Конструктор без species — вид встановлюється у підкласі
    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, String[] habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits == null ? new String[0] : habits;
    }

    // eat реалізовано тут (усі їдять однаково)
    public void eat() {
        System.out.println("Я їм!");
    }

    // кожна тварина по-різному відгукується
    public abstract void respond();

    // getter / setter
    public Species getSpecies() {
        return species;
    }

    protected void setSpecies(Species species) {
        this.species = species == null ? Species.UNKNOWN : species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits == null ? new String[0] : habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        // формат: dog{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}
        return species.toString().toLowerCase() +
                "{nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(getHabits()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname);
    }
}
