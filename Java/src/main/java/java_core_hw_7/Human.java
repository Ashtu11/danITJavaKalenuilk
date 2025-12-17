package java_core_hw_7;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private byte iq;
    private Family family;
    private Map<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;

        this.birthDate = LocalDate.of(year, 1, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    public Human(String name, String surname, int year, byte iq) {
        this(name, surname, year);
        this.iq = iq;
    }

    public Human(String name, String surname, String birthDateStr, byte iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;

        LocalDate localDate = LocalDate.parse(birthDateStr, FORMATTER);
        this.birthDate = localDate
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    public Human(String name, String surname, long birthDate, byte iq,
                 Human adoptMother, Human adoptFather) {

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.family = new Family(adoptMother, adoptFather);
    }

    public Human() {
    }


    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public String getActivity(DayOfWeek day) {
        return schedule.get(day);
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

    public void greetPet() {
        System.out.println("Hi, " + this.family.getPets() + "!");
    }

    public void describePet() {
        for (Pet pet : this.family.getPets()) {
            System.out.println("I have " + pet.getSpecies() + ", he is " + pet.getAge() + " years, he " +
                    (pet.getTrickLevel() > 50 ? "very cunning" : "almost not cunning"));
            System.out.println(pet.getNickname());
        }
    }

    public int getAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(birth, LocalDate.now()).getYears();
    }

    public String describeAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate now = LocalDate.now();

        Period period = Period.between(birth, now);

        return period.getYears() + " years, "
                + period.getMonths() + " months, "
                + period.getDays() + " days";
    }

    public String getFormattedBirthDate() {
        return Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(FORMATTER);
    }

    public static Human createBoy(String name, Family family) {
        int currentYear = LocalDate.now().getYear();

        Human boy = new Man(
                name,
                family.getFather().getSurname(),
                currentYear,
                (byte) 70
        );

        boy.setFamily(family);
        return boy;
    }

    public static Human createGirl(String name, Family family) {
        int currentYear = LocalDate.now().getYear();

        Human girl = new Woman(
                name,
                family.getFather().getSurname(),
                currentYear,
                (byte) 70
        );
        girl.setFamily(family);
        return girl;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + getFormattedBirthDate() +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate, iq);
    }
}