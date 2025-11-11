package Java_core_hw_5;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public void eat() {
        System.out.println("I'm eating.");

    }

    public void respond() {
        System.out.println("Hello, master. I am " + this.nickname + "I missed you!");
    }

    public void foul() {
        System.out.println("I need to cover your tracks well...");

    }

    public Pet() {

    }

    public Pet(String nickname, Species species) {
        this.nickname = nickname;
        this.species = species;
    }

    public Pet(String nickname, Species species, int trickLevel, int age, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.habits = habits;
        this.trickLevel = trickLevel;

    }

    public Species getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getNickname() {
        return nickname;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return species + "{" +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, trickLevel);
    }
}
