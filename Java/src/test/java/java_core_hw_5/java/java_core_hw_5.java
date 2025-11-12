package java_core_hw_5.java;

import Java_core_hw_5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class java_core_hw_5 {
        private Family family;
        private Man father;
        private Woman mother;
        private Dog dog;

        @BeforeEach
        void setUp() {
            dog = new Dog("Rock", 5, 75, new String[]{"eat", "sleep"});
            mother = new Woman("Jane", "Karleone", 1975, (byte) 80);
            father = new Man("Vito", "Karleone", 1970, (byte) 90);
            family = new Family(mother, father);
            family.setPet(dog);
        }

        @Test
        void testPetSpeciesAssignment() {
            assertEquals(Species.DOG, dog.getSpecies());
        }

        @Test
        void testPetRespondAndEat() {
            assertDoesNotThrow(() -> dog.respond());
            assertDoesNotThrow(() -> dog.eat());
        }

        @Test
        void testCountFamily() {
            family.addChild(new Man("Michael", "Karleone", 2000, (byte) 75));
            assertEquals(3, family.countFamily()); // 2 parents + 1 child
        }

        @Test
        void testGreetPetFromChild() {
            Human child = new Woman("Sophie", "Karleone", 2005, (byte) 85);
            family.addChild(child);
            child.setFamily(family);
            assertDoesNotThrow(child::greetPet);
        }

        @Test
        void testDescribePet() {
            Human child = new Man("Michael", "Karleone", 2000, (byte) 70);
            child.setFamily(family);
            assertDoesNotThrow(child::describePet);
        }

        @Test
        void testEqualsAndHashCode() {
            Dog dog2 = new Dog("Rock", 5, 75, new String[]{"eat", "sleep"});
            assertEquals(dog, dog2);
            assertEquals(dog.hashCode(), dog2.hashCode());
        }

        @Test
        void testManUniqueMethod() {
            assertDoesNotThrow(father::repairCar);
        }

        @Test
        void testWomanUniqueMethod() {
            assertDoesNotThrow(mother::makeup);
        }

        @Test
        void testRoboCatRespond() {
            RoboCat roboCat = new RoboCat("R2-MEOW", 1, 90, new String[]{"charge"});
            assertDoesNotThrow(roboCat::respond);
            assertEquals(Species.ROBOCAT, roboCat.getSpecies());
        }

        @Test
        void testFishDoesNotFoul() {
            Fish fish = new Fish("Nemo", 1, 20, new String[]{"swim"});
            assertEquals(Species.FISH, fish.getSpecies());
            assertThrows(ClassCastException.class, () -> {
                ((Foulable) fish).foul();
            });
        }

        @Test
        void testFamilyEquality() {
            Family family2 = new Family(mother, father);
            family2.setPet(dog);
            assertEquals(family, family2);
        }
    }

