package java_core_hw_9;

import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    protected Species species;
    protected String nickname;
    protected int age;
    protected int trickLevel;
    protected Set<String> habits;

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(Species rex, String species) {
    }

    public void eat() {
        System.out.println("I'm eating.");
    }

    public abstract void respond();

    public void foul() {
        System.out.println("I need to cover your tracks well...");
    }

    public Pet(String nickname, Species species) {
        this.nickname = nickname;
        this.species = species;
    }

    public Pet(String nickname, Species species, int trickLevel, int age, Set<String> habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.habits = habits;
        this.trickLevel = trickLevel;
    }

    public Species getSpecies() { return species; }
    public int getAge() { return age; }
    public String getNickname() { return nickname; }
    public int getTrickLevel() { return trickLevel; }
    public Set<String> getHabits() { return habits; }

    public void setSpecies(Species species) { this.species = species; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setAge(int age) { this.age = age; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public void setHabits(Set<String> habits) { this.habits = habits; }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tspecies: ").append(species).append("\n");
        sb.append("\t\tnickname: ").append(nickname).append("\n");
        sb.append("\t\tage: ").append(age).append("\n");
        sb.append("\t\ttrickLevel: ").append(trickLevel).append("\n");
        sb.append("\t\thabits: ").append(habits).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return prettyFormat();
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