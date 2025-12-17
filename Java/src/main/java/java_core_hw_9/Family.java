package java_core_hw_9;

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
        if (mother != null) mother.setFamily(this);
        if (father != null) father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public List<Human> getChildren() { return children; }
    public List<Pet> getPets() { return new ArrayList<>(pets); }

    public void setMother(Human mother) { this.mother = mother; }
    public void setFather(Human father) { this.father = father; }
    public void setChildren(List<Human> children) { this.children = children; }
    public void setPets(Set<Pet> pets) { this.pets = pets; }

    public void addPet(Pet pet) {
        if (pet != null) pets.add(pet);
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
        return prettyFormat();
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

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n");

        sb.append("\tmother:\n");
        if (mother != null) sb.append(mother.prettyFormat());
        else sb.append("\t\tnull\n");

        sb.append("\tfather:\n");
        if (father != null) sb.append(father.prettyFormat());
        else sb.append("\t\tnull\n");

        sb.append("\tchildren:\n");
        if (children == null || children.isEmpty()) {
            sb.append("\t\tnone\n");
        } else {
            for (Human child : children) {
                String gender;
                if (child instanceof Man) gender = "boy";
                else if (child instanceof Woman) gender = "girl";
                else gender = "child";
                sb.append("\t\t").append(gender).append(":\n");
                sb.append(child.prettyFormat());
            }
        }

        sb.append("\tpets:\n");
        if (pets == null || pets.isEmpty()) {
            sb.append("\t\tnone\n");
        } else {
            for (Pet pet : pets) {
                sb.append("\t\t").append(pet.getSpecies().toString()).append(":\n");
                sb.append(pet.prettyFormat());
            }
        }

        return sb.toString();
    }
}