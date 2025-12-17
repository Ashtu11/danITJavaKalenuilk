package java_core_hw_10;

import java.util.List;

public class FamilyController {
    private final FamilyService service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    public List<Family> getAllFamilies() {
        return service.getAllFamilies();
    }

    public void displayAllFamilies() {
        service.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        return service.getFamiliesBiggerThan(number);
    }

    public List<Family> getFamiliesLessThan(int number) {
        return service.getFamiliesLessThan(number);
    }

    public int countFamiliesWithMemberNumber(int number) {
        return service.countFamiliesWithMemberNumber(number);
    }

    public Family createNewFamily(Human mother, Human father) {
        return service.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return service.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        return service.bornChild(family, boyName, girlName);
    }

    public Family adoptChild(Family family, Human child) {
        return service.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan(int age) {
        service.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return service.count();
    }

    public Family getFamilyById(int id) {
        return service.getFamilyById(id);
    }

    public List<Pet> getPets(int index) {
        return service.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        service.addPet(index, pet);
    }

    public void saveToFile(String path) throws Exception {
        service.saveToFile(path);
    }

    public void loadFromFile(String path) throws Exception {
        service.loadFromFile(path);
    }

    public void loadData(List<Family> families) {
        service.loadData(families);
    }
}