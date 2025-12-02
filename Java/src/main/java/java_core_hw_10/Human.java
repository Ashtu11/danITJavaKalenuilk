package java_core_hw_10;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "humanType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Man.class, name = "Man"),
        @JsonSubTypes.Type(value = Woman.class, name = "Woman")
})
public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private byte iq;
    @JsonBackReference
    private Family family;
    private Map<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Human() { }

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
        this.birthDate = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public Human(String name, String surname, long birthDate, byte iq, Human adoptMother, Human adoptFather) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.family = new Family(adoptMother, adoptFather);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Long getBirthDate() { return birthDate; }
    public void setBirthDate(Long birthDate) { this.birthDate = birthDate; }

    public byte getIq() { return iq; }
    public void setIq(byte iq) { this.iq = iq; }

    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }

    public Map<DayOfWeek, String> getSchedule() { return schedule; }
    public void setSchedule(Map<DayOfWeek, String> schedule) { this.schedule = schedule; }

    public String getFullName() { return name + " " + surname; }

    public String getActivity(DayOfWeek day) { return schedule.get(day); }

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
        if (family == null || family.getPets().isEmpty()) {
            System.out.println("Hi, I don't have a pet!");
        } else {
            family.getPets().forEach(p -> System.out.println("Hi, " + p.getNickname() + "!"));
        }
    }

    public void describePet() {
        if (family == null) return;
        for (Pet pet : family.getPets()) {
            System.out.println("I have " + pet.getSpecies() + ", he is " + pet.getAge() +
                    " years, he " + (pet.getTrickLevel() > 50 ? "very cunning" : "almost not cunning"));
        }
    }

    public int getAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public String describeAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birth, LocalDate.now());
        return period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days";
    }

    public String getFormattedBirthDate() {
        return Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate().format(FORMATTER);
    }

    public static Human createBoy(String name, Family family) {
        int currentYear = LocalDate.now().getYear();
        Human boy = new Man(name, family.getFather().getSurname(), currentYear, (byte) 70);
        boy.setFamily(family);
        return boy;
    }

    public static Human createGirl(String name, Family family) {
        int currentYear = LocalDate.now().getYear();
        Human girl = new Woman(name, family.getFather().getSurname(), currentYear, (byte) 70);
        girl.setFamily(family);
        return girl;
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("{name='").append(name).append("', ");
        sb.append("surname='").append(surname).append("', ");
        sb.append("birthDate='").append(getFormattedBirthDate()).append("', ");
        sb.append("iq=").append(iq).append(", ");
        sb.append("schedule=");
        if (schedule == null || schedule.isEmpty()) sb.append("null");
        else sb.append(schedule);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String toString() { return prettyFormat(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq &&
                Objects.equals(name, human.name) && Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() { return Objects.hash(name, surname, birthDate, iq); }
}