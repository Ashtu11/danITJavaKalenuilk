package Tests.java;

import java_core_hw_7.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    private FamilyService service;
    private FamilyDao dao;

    @BeforeEach
    void setUp() {
        dao = new CollectionFamilyDao();
        service = new FamilyService(dao);
    }

    @Test
    void testCreateNewFamily() {
        Human m = new Human("Anna", "Test", 1980);
        Human f = new Human("Ivan", "Test", 1978);

        service.createNewFamily(m, f);

        assertEquals(1, service.count());
        assertEquals(m, service.getFamilyById(0).getMother());
    }

    @Test
    void testGetAllFamilies() {
        service.createNewFamily(
                new Human("Anna", "A", 1980),
                new Human("Ivan", "A", 1978)
        );

        service.createNewFamily(
                new Human("Oksana", "B", 1982),
                new Human("Pavlo", "B", 1980)
        );

        List<Family> families = service.getAllFamilies();
        assertEquals(2, families.size());
    }

    @Test
    void testDeleteFamilyByIndex() {
        service.createNewFamily(
                new Human("Anna", "A", 1980),
                new Human("Ivan", "A", 1978)
        );

        boolean deleted = service.deleteFamilyByIndex(0);
        assertTrue(deleted);
        assertEquals(0, service.count());
    }

    @Test
    void testGetFamiliesBiggerThan() {
        Family f = service.createNewFamily(
                new Human("Anna", "Test", 1980),
                new Human("Ivan", "Test", 1978)
        );

        f.addChild(new Human("Oleh", "Test", 2010));
        f.addChild(new Human("Marina", "Test", 2012));
        dao.saveFamily(f);

        List<Family> result = service.getFamiliesBiggerThan(3); // сім'я = 4 людини

        assertEquals(1, result.size());
    }

    @Test
    void testGetFamiliesLessThan() {
        Family f = service.createNewFamily(
                new Human("Anna", "Test", 1980),
                new Human("Ivan", "Test", 1978)
        );
        List<Family> result = service.getFamiliesLessThan(3);
        assertEquals(1, result.size());
    }

    @Test
    void testCountFamiliesWithMemberNumber() {
        Family f1 = service.createNewFamily(
                new Human("Anna", "Test", 1980),
                new Human("Ivan", "Test", 1978)
        );

        Family f2 = service.createNewFamily(
                new Human("Oksana", "Test", 1982),
                new Human("Pavlo", "Test", 1980)
        );
        f2.addChild(new Human("Kid", "Test", 2010)); // 3 члени
        dao.saveFamily(f2);

        assertEquals(1, service.countFamiliesWithMemberNumber(2));
        assertEquals(1, service.countFamiliesWithMemberNumber(3));
    }

    @Test
    void testBornChild() {
        Family f = service.createNewFamily(
                new Human("Anna", "Test", 1980),
                new Human("Ivan", "Test", 1978)
        );

        Family updated = service.bornChild(f, "Oleh", "Olena");
        assertEquals(1, updated.getChildren().size());
        assertEquals(3, updated.countFamily());
    }

    @Test
    void testAdoptChild() {
        Family f = service.createNewFamily(
                new Human("Anna", "Test", 1980),
                new Human("Ivan", "Test", 1978)
        );

        Human child = new Human("Petro", "X", 2010);
        Family updated = service.adoptChild(f, child);
        assertEquals(1, updated.getChildren().size());
        assertEquals(f, child.getFamily());
    }

    @Test
    void testDeleteAllChildrenOlderThan() {
        Family f = service.createNewFamily(
                new Human("Anna", "Test", 1980),
                new Human("Ivan", "Test", 1978)
        );

        Human ch1 = new Human("Old", "Test", "01/01/2000", (byte) 90); // 24 роки
        Human ch2 = new Human("Young", "Test", "01/01/2015", (byte) 90); // 9 років

        f.addChild(ch1);
        f.addChild(ch2);
        dao.saveFamily(f);

        service.deleteAllChildrenOlderThen(18);

        assertEquals(1, f.getChildren().size());
        assertEquals("Young", f.getChildren().get(0).getName());
    }

    @Test
    void testGetFamilyById() {
        Human m = new Human("Anna", "Test", 1980);
        Human f = new Human("Ivan", "Test", 1978);

        service.createNewFamily(m, f);

        Family fam = service.getFamilyById(0);

        assertNotNull(fam);
        assertEquals(m, fam.getMother());
    }

    @Test
    void testGetPets() {
        Family f = service.createNewFamily(
                new Human("Anna", "Test", 1980),
                new Human("Ivan", "Test", 1978)
        );

        Pet p = new Pet("Rex", Species.DOG) {
            @Override
            public void respond() {

            }
        };
        f.addPet(p);
        dao.saveFamily(f);

        List<Pet> pets = service.getPets(0);

        assertEquals(1, pets.size());
        assertEquals("Rex", pets.get(0).getNickname());
    }

    @Test
    void testAddPet() {
        Family f = service.createNewFamily(
                new Human("Anna", "A", 1980),
                new Human("Ivan", "A", 1978)
        );

        Pet pet = new Pet(Species.CAT, "Murka") {
            @Override
            public void respond() {

            }
        };

        service.addPet(0, pet);

        assertEquals(1, f.getPets().size());
    }
}
