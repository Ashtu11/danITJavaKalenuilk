package Java_core_hw4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private byte iq;
    private Family family;
    private String[][] schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }


    public Human(String name, String surname, int year, byte iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public Human(String name, String surname, int year, Human Mother, Human Father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }


    public Human() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }


    public void greetPet() {
        System.out.println("Hi, " + this.family.getPet().getNickname() + "!");
    }

    public void describe() {
        Human father = this.family.getFather();
        Human mother = this.family.getMother();
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Year of birth: " + year);
        System.out.println("IQ: " + iq);
        if (mother != null)
            System.out.println("Mother: " + mother.getFullName());
        if (father != null)
            System.out.println("Dad: " + father.getFullName());
    }

    public void describePet() {
        Pet pet = this.family.getPet();
        System.out.println("I have " +
                pet.getSpecies() +
                " he is " + pet.getAge() +
                " years, he " +
                (pet.getTrickLevel() > 50 ? "very cunning" : "almost not cunning"));
        System.out.println(pet.getNickname());

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.toString(schedule) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, iq);
    }
}
