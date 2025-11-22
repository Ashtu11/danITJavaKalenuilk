package java_core_hw_10;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;
import java.util.Set;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "petType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "Dog"),
        @JsonSubTypes.Type(value = RoboCat.class, name = "RoboCat"),
        @JsonSubTypes.Type(value = Fish.class, name = "Fish")
})
public abstract class Pet {
    protected Species species;
    protected String nickname;
    protected int age;
    protected int trickLevel;
    protected Set<String> habits;

    public Pet() { }

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(String nickname, Species species) {
        this.nickname = nickname;
        this.species = species;
    }

    public Pet(String nickname, Species species, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.species = species;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I'm eating.");
    }

    public abstract void respond();

    public void foul() {
        System.out.println("I need to cover my tracks well...");
    }

    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getTrickLevel() { return trickLevel; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }

    public Set<String> getHabits() { return habits; }
    public void setHabits(Set<String> habits) { this.habits = habits; }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("{species=").append(species)
                .append(", nickname='").append(nickname).append("'")
                .append(", age=").append(age)
                .append(", trickLevel=").append(trickLevel)
                .append(", habits=").append(habits)
                .append("}");
        return sb.toString();
    }

    @Override
    public String toString() { return prettyFormat(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel &&
                Objects.equals(nickname, pet.nickname) &&
                species == pet.species;
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }
}