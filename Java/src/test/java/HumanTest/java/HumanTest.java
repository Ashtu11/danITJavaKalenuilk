package HumanTest.java;
import java_core_hw_6.Human;
import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    @Test
    void testBirthDateFromYearConstructor() {
        Human human = new Human("John", "Doe", 1990);

        long expected = LocalDate.of(1990, 1, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        assertEquals(expected, human.getBirthDate(),
                "birthDate must be correctly converted into Unix millis");
    }

    @Test
    void testBirthDateFromStringConstructor() {

        Human human = new Human("Anna", "Stone", "20/03/2016", (byte) 90);

        long expected = LocalDate.of(2016, 3, 20)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        assertEquals(expected, human.getBirthDate(),
                "Constructor with dd/MM/yyyy string must correctly parse the date");
    }

    @Test
    void testDescribeAge() {
        long birthMillis = LocalDate.of(2000, 1, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        Human human = new Human("Test", "User", 2000);

        LocalDate birthDate = Instant.ofEpochMilli(human.getBirthDate())
                .atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate current = LocalDate.now();

        Period expected = Period.between(birthDate, current);

        String result = human.describeAge();

        assertTrue(result.contains(expected.getYears() + " years"),
                "Age description must contain correct years");

        assertTrue(result.contains(expected.getMonths() + " months"),
                "Age description must contain correct months");

        assertTrue(result.contains(expected.getDays() + " days"),
                "Age description must contain correct days");
    }

    @Test
    void testToStringShowsFormattedBirthDate() {
        Human human = new Human("Alice", "Brown", "15/08/2010", (byte) 70);
        String toStr = human.toString();
        assertTrue(toStr.contains("15/08/2010"),
                "toString() must display birthDate in dd/MM/yyyy format");
    }
}
