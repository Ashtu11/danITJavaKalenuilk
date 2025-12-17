package java_core_hw_6;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private byte iq;
    private Family family;
    private Map<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

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

    public String getActivity(DayOfWeek day) {
        return schedule.get(day);
    }

    public void greetPet() {
        System.out.println("Hi, " + this.family.getPets() + "!");
    }

    public void generateCalend() {
        schedule.put(DayOfWeek.MONDAY, "Go to school");
        schedule.put(DayOfWeek.TUESDAY, "Go to cinema");
        schedule.put(DayOfWeek.WEDNESDAY, "Go to gym");
        schedule.put(DayOfWeek.THURSDAY, "Clean room");
        schedule.put(DayOfWeek.FRIDAY, "Learn Java");
        schedule.put(DayOfWeek.SATURDAY, "Rest");
        schedule.put(DayOfWeek.SUNDAY, "Go to church");
    }


    public void describePet() {
        for (Pet pet : this.family.getPets()) {
            System.out.println("I have " + pet.getSpecies() + ", he is " + pet.getAge() + " years, he " +
                    (pet.getTrickLevel() > 50 ? "very cunning" : "almost not cunning"));
            System.out.println(pet.getNickname());
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + schedule +
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
