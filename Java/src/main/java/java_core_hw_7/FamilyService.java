package java_core_hw_7;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class FamilyService {
    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println(i + ": " + families.get(i));
        }
    }

    public List<Family> getFamiliesBiggerThan(int size) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() > size) {
                result.add(family);
                System.out.println(family);
            }
        }
        return result;
    }

    public List<Family> getFamiliesLessThan(int size) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() < size) {
                result.add(family);
                System.out.println(family);
            }
        }
        return result;
    }

    public int countFamiliesWithMemberNumber(int number) {
        int count = 0;
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() == number) count++;
        }
        return count;
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        return familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {

        boolean isBoy = Math.random() > 0.5;

        Human child = isBoy
                ? Human.createBoy(boyName, family)
                : Human.createGirl(girlName, family);

        family.addChild(child);
        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild(Family family, Human child) {
        child.setFamily(family);
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family family : familyDao.getAllFamilies()) {

            Iterator<Human> it = family.getChildren().iterator();

            while (it.hasNext()) {
                Human child = it.next();
                if (child.getAge() > age) {
                    it.remove();
                }
            }

            familyDao.saveFamily(family);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Pet> getPets(int familyIndex) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        return f != null ? new ArrayList<>(f.getPets()) : null;
    }

    public void addPet(int familyIndex, Pet pet) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        if (f != null) {
            f.addPet(pet);
            familyDao.saveFamily(f);
        }
    }
}
