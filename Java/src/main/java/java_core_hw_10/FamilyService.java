package java_core_hw_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyService {
    private final FamilyDao familyDao;
    private final int MAX_FAMILY_SIZE = 6;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() { return familyDao.getAllFamilies(); }

    public void displayAllFamilies() {
        familyDao.getAllFamilies().stream()
                .map(Family::prettyFormat)
                .forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int size) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() > size)
                .peek(f -> System.out.println(f.prettyFormat()))
                .toList();
    }

    public List<Family> getFamiliesLessThan(int size) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() < size)
                .peek(f -> System.out.println(f.prettyFormat()))
                .toList();
    }

    public int countFamiliesWithMemberNumber(int number) {
        return (int) familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() == number)
                .count();
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        return familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        if (family.countFamily() >= MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException("Cannot born child: family size would exceed limit (" + MAX_FAMILY_SIZE + ").");
        }

        boolean isBoy = Math.random() > 0.5;
        Human child = isBoy ? Human.createBoy(boyName, family) : Human.createGirl(girlName, family);
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        if (family.countFamily() >= MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException("Cannot adopt child: family size would exceed limit (" + MAX_FAMILY_SIZE + ").");
        }
        child.setFamily(family);
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyDao.getAllFamilies().forEach(family -> {
            family.getChildren().removeIf(child -> child.getAge() > age);
            familyDao.saveFamily(family);
        });
    }

    public int count() { return familyDao.getAllFamilies().size(); }

    public Family getFamilyById(int index) { return familyDao.getFamilyByIndex(index); }

    public List<Pet> getPets(int familyIndex) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        return f != null ? new ArrayList<>(f.getPets()) : null;
    }

    public void addPet(int familyIndex, Pet pet) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        if (f != null) { f.addPet(pet); familyDao.saveFamily(f); }
    }


    public void saveToFile(String path) throws Exception {
        if (familyDao instanceof CollectionFamilyDao) ((CollectionFamilyDao) familyDao).saveToFile(path);
        else throw new UnsupportedOperationException("Save not supported by DAO");
    }

    public void loadFromFile(String path) throws Exception {
        if (familyDao instanceof CollectionFamilyDao) {
            List<Family> loaded = ((CollectionFamilyDao) familyDao).loadFromFile(path);
            familyDao.loadData(loaded);
        } else throw new UnsupportedOperationException("Load not supported by DAO");
    }

    public void loadData(List<Family> families) { familyDao.loadData(families); }
}