package Tests.java;

import java_core_hw_9.Family;
import java_core_hw_9.Human;
import java_core_hw_9.Man;
import java_core_hw_9.Woman;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsImpl {
    @Test
    void testCreateHuman() {
        LocalDate date = LocalDate.of(2010, 5, 15);
        long expectedBirthDate = date.atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        Human h = new Human("Lila", "Cooper", "15/05/2010", (byte) 90);

        assertEquals("Lila", h.getName());
        assertEquals("Cooper", h.getSurname());
        assertEquals(expectedBirthDate, h.getBirthDate());
        assertEquals(90, h.getIq());
    }
    @Test
    void testFamilyCreation() {
        Human mother = new Woman("Alice", "Cooper", "10/10/1980", (byte) 95);
        Human father = new Man("John", "Cooper", "12/12/1978", (byte) 92);

        Family f = new Family(mother, father);

        assertEquals(2, f.countFamily());
        assertEquals(mother, f.getMother());
        assertEquals(father, f.getFather());
    }

    @Test
    void testAddChild() {
        Human mother = new Woman("Alice", "Cooper", "10/10/1980", (byte) 95);
        Human father = new Man("John", "Cooper", "12/12/1978", (byte) 92);
        Family f = new Family(mother, father);

        Human child = new Human("Baby", "Cooper", "01/01/2020", (byte) 70);
        f.addChild(child);

        assertEquals(3, f.countFamily());
        assertTrue(f.getChildren().contains(child));
    }

}
