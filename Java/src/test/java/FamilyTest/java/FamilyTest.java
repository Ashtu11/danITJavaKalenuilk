package FamilyTest.java;


import java_core_hw_6.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    private Family family;
    private Human mother;
    private Human father;
    private Pet dog;
    private Pet cat;

    @BeforeEach
    public void setup() {
        mother = new Woman("Mary", "Black", 1990, (byte) 90);
        father = new Man("Tom", "Black", 1988, (byte) 85);
        family = new Family(mother, father);

        dog = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "sleep", "play")));
        cat = new DomesticCat("Murka", 2, 45, new HashSet<>(Arrays.asList("sleep", "scratch")));
    }

    @Test
    public void testAddChildAddsToList() {
        Human child = new Human("Bob", "Black", 2015, (byte) 50);
        family.addChild(child);

        List<Human> children = family.getChildren();
        assertEquals(1, children.size());
        assertTrue(children.contains(child));
    }

    @Test
    public void testDeleteChildRemovesFromList() {
        Human child = new Human("Alice", "Black", 2012, (byte) 60);
        family.addChild(child);
        assertEquals(1, family.getChildren().size());

        family.deleteChild(child);
        assertEquals(0, family.getChildren().size());
    }

    @Test
    public void testAddMultipleChildren() {
        family.addChild(new Human("Anna", "Black", 2010, (byte) 70));
        family.addChild(new Human("Mark", "Black", 2013, (byte) 65));

        assertEquals(2, family.getChildren().size());
    }

    @Test
    public void testAddPetAddsUniquePet() {
        family.addPet(dog);
        family.addPet(cat);

        Set<Pet> pets = family.getPets();
        assertEquals(2, pets.size());
        assertTrue(pets.contains(dog));
        assertTrue(pets.contains(cat));
    }

    @Test
    public void testAddDuplicatePetNotAddedTwice() {
        family.addPet(dog);
        family.addPet(dog);

        assertEquals(1, family.getPets().size());
    }

    @Test
    public void testPetsHashCodeWorksWithHashSet() {
        Pet dog2 = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "sleep", "play")));
        Set<Pet> pets = new HashSet<>();
        pets.add(dog);
        pets.add(dog2);
        assertEquals(1, pets.size());
    }

    @Test
    public void testChildrenListIndependentFromOutsideChanges() {
        Human child = new Human("Kate", "Black", 2014, (byte) 55);
        family.addChild(child);
        List<Human> children = family.getChildren();
        children.clear();
        assertEquals(0, family.getChildren().size());
    }
}