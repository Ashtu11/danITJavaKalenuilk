package java_core_hw_7;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public List<Human> getChildren() { return children; }
    public List<Pet> getPets() {
        return new ArrayList<>(pets);
    }

    public void setMother(Human mother) { this.mother = mother; }
    public void setFather(Human father) { this.father = father; }
    public void setChildren(List<Human> children) { this.children = children; }
    public void setPets(Set<Pet> pets) { this.pets = pets; }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public boolean removePet(Pet pet) {
        return pets.remove(pet);
    }

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

    public int countFamily() {
        return 2 + children.size();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children +
                ", pets=" + pets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother)
                && Objects.equals(father, family.father)
                && Objects.equals(children, family.children)
                && Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }
}