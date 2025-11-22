package java_core_hw_10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionFamilyDao implements FamilyDao {
    private final List<Family> families = new ArrayList<>();
    private final ObjectMapper mapper;

    public CollectionFamilyDao() {
        mapper = new ObjectMapper().findAndRegisterModules();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public List<Family> getAllFamilies() { return families; }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < 0 || index >= families.size()) return null;
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) return false;
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        if (!families.contains(family)) families.add(family);
        else {
            int idx = families.indexOf(family);
            families.set(idx, family);
        }
        return family;
    }

    @Override
    public void loadData(List<Family> families) {
        this.families.clear();
        if (families != null) this.families.addAll(families);
    }

    public void saveToFile(String path) throws Exception {
        Objects.requireNonNull(path);
        System.out.println("Save Families" + families);
        mapper.writeValue(new File(path), families);
    }

    public List<Family> loadFromFile(String path) throws Exception {
        Objects.requireNonNull(path);
        File f = new File(path);
        if (!f.exists()) return new ArrayList<>();
        Family[] arr = mapper.readValue(f, Family[].class);
        return new ArrayList<>(Arrays.asList(arr));
    }
}