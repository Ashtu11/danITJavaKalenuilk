package Java_core_hw6;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("Both parents must be provided");
        }
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }

    public Human[] getChildren() { return children; }
    public void setChildren(Human[] children) { this.children = children; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public void addChild(Human child) {
        if (child == null) return;
        Human[] newArr = Arrays.copyOf(children, children.length + 1);
        newArr[children.length] = child;
        children = newArr;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human[] newArr = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i == index) continue;
            newArr[j++] = children[i];
        }
        children = newArr;
        return true;
    }

    public boolean deleteChild(Human child) {
        if (child == null) return false;
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                return deleteChild(i);
            }
        }
        return false;
    }

    public int countFamily() {
        return 2 + children.length + (pet != null ? 1 : 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Family{");
        sb.append("mother=").append(mother.getName()).append(" ").append(mother.getSurname()).append(", ");
        sb.append("father=").append(father.getName()).append(" ").append(father.getSurname()).append(", ");
        sb.append("children=").append(Arrays.toString(children)).append(", ");
        sb.append("pet=").append(pet);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }
}