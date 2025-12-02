package java_core_hw_10;

import java.util.List;

public interface FamilyDao {
    java.util.List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    Family saveFamily(Family family);

    void loadData(List<Family> families);
}