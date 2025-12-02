package java_core_hw_10;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

public class Family {
    @JsonManagedReference
    private Human mother;
    @JsonManagedReference
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family() {
        this.children = new ArrayList<>();
        this.pets = new LinkedHashSet<>();
    }

    public Family(Human mother, Human father) {
        this();
        this.mother = mother;
        this.father = father;
        if (mother != null) mother.setFamily(this);
        if (father != null) father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; if (mother != null) mother.setFamily(this); }

    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; if (father != null) father.setFamily(this); }

    public List<Human> getChildren() { return children; }
    public void setChildren(List<Human> children) {
        this.children = children != null ? children : new ArrayList<>();
        if (this.children != null) this.children.forEach(c -> c.setFamily(this));
    }

    public List<Pet> getPets() { return new ArrayList<>(pets); }
    public void setPets(Set<Pet> pets) { this.pets = pets != null ? pets : new LinkedHashSet<>(); }

    public void addPet(Pet pet) { if (pet != null) pets.add(pet); }

    public boolean removePet(Pet pet) { return pets.remove(pet); }

    public void addChild(Human child) {
        if (child != null) {
            children.add(child);
            child.setFamily(this);
        }
    }

    public boolean deleteChild(Human child) {
        if (child == null) return false;
        boolean removed = children.remove(child);
        if (removed) child.setFamily(null);
        return removed;
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) return false;
        Human removed = children.remove(index);
        if (removed != null) removed.setFamily(null);
        return true;
    }

    public int countFamily() { return 2 + children.size(); }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n");
        sb.append("\tmother: ").append(mother != null ? mother.prettyFormat() : "null").append(",\n");
        sb.append("\tfather: ").append(father != null ? father.prettyFormat() : "null").append(",\n");
        sb.append("\tchildren:\n");
        if (children == null || children.isEmpty()) {
            sb.append("\t\tnone\n");
        } else {
            for (Human child : children) {
                String gender = (child instanceof Man) ? "boy" : (child instanceof Woman) ? "girl" : "child";
                sb.append("\t\t").append(gender).append(": ").append(child.prettyFormat()).append("\n");
            }
        }
        sb.append("\tpets: ");
        if (pets == null || pets.isEmpty()) {
            sb.append("[]");
        } else {
            sb.append("[");
            boolean first = true;
            for (Pet pet : pets) {
                if (!first) sb.append(", ");
                sb.append(pet.prettyFormat());
                first = false;
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @Override
    public String toString() { return prettyFormat(); }
}