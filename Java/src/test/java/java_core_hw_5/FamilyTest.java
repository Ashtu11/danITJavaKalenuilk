package java_core_hw_5;

import Java_core_hw_5.Family;
import Java_core_hw_5.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class FamilyTest {

    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Family family;

    @BeforeEach
    public void setup() {
        mother = new Human("Anna","Kawa", 1980);
        father = new Human("Oleh","Bdzilka", 1978);
        child1 = new Human("Maks", "Wertappen",2010);
        child2 = new Human("Ira","Povidlo", 2012);

        family = new Family(mother, father);
        family.addChild(child1);
        family.addChild(child2);
    }

    @Test
    public void testToStringReturnsCorrectString() {
        String result = family.toString();
        assertTrue(result.contains("Anna"));
        assertTrue(result.contains("Oleh"));
        assertTrue(result.contains("Maks"));
        assertTrue(result.contains("Ira"));
    }

    @Test
    public void testDeleteChild_DoesNothingIfChildNotExist() {
        Human stranger = new Human("Roman","Torba", 2015);

        boolean removed = family.deleteChild(stranger);

        assertFalse(removed);
        assertEquals(2, family.getChildren().length);
    }

    @Test
    public void testDeleteChildByIndex_RemovesCorrectChild() {
        boolean removed = family.deleteChild(0);

        assertTrue(removed);
        assertEquals(1, family.getChildren().length);
        assertEquals("Ira", family.getChildren()[0].getName());
    }

    @Test
    public void testDeleteChildByIndex_InvalidIndexDoesNothing() {
        boolean removed = family.deleteChild(10);

        assertFalse(removed);
        assertEquals(2, family.getChildren().length);
    }

    @Test
    public void testAddChild_IncreasesArrayAndSavesTheChild() {
        Human newChild = new Human("Taras","Yack", 2016);

        family.addChild(newChild);

        assertEquals(3, family.getChildren().length);
        assertEquals("Taras", family.getChildren()[2].getName());
        assertSame(family, newChild.getFamily());
    }

    @Test
    public void testCountFamily_ReturnsCorrectNumber() {
        assertEquals(4, family.countFamily());
    }
}

