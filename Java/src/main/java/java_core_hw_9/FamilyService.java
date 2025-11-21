package java_core_hw_9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyService {
    private final FamilyDao familyDao;
    private final int MAX_FAMILY_SIZE = 6;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ": " + families.get(i).prettyFormat());
        }
    }

    public List<Family> getFamiliesBiggerThan(int size) {
        List<Family> result = new ArrayList<>();
        List<Family> families = familyDao.getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            Family family = families.get(i);
            if (family.countFamily() > size) {
                result.add(family);
                System.out.println((i + 1) + ": " + family.prettyFormat());
            }
        }
        return result;
    }

    public List<Family> getFamiliesLessThan(int size) {
        List<Family> result = new ArrayList<>();
        List<Family> families = familyDao.getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            Family family = families.get(i);
            if (family.countFamily() < size) {
                result.add(family);
                System.out.println((i + 1) + ": " + family.prettyFormat());
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
        if (family.countFamily() >= MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException("Cannot born child: family size would exceed limit (" + MAX_FAMILY_SIZE + ").");
        }

        boolean isBoy = Math.random() > 0.5;

        Human child = isBoy
                ? Human.createBoy(boyName, family)
                : Human.createGirl(girlName, family);

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