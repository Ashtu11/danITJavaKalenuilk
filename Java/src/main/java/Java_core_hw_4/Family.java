package Java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human Mother;
    private Human Father;
    private Human[] Children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.Mother = mother;
        this.Father = father;
        this.Children = new Human[0];
        mother.setFamily(this);
        father.setFamily(this);

    }

    public void setMother(Human mother) {
        Mother = mother;
    }

    public void setFather(Human father) {
        Father = father;
    }

    public void setChildren(Human[] children) {
        Children = children;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return Mother;
    }

    public Human getFather() {
        return Father;
    }

    public Human[] getChildren() {
        return Children;
    }

    public Pet getPet() {
        return pet;
    }

    public void addChild(Human child) {
        Human[] newChildren = Arrays.copyOf(Children, Children.length + 1);
        newChildren[Children.length] = child;
        Children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= Children.length) {
            return false;
        }
        Children[index].setFamily(null);
        Human[] newChildren = new Human[Children.length - 1];
        for (int i = 0, j = 0; i < Children.length; i++) {
            if (i != index) {
                newChildren[j++] = Children[i];
            }
        }
        Children = newChildren;
        return true;
    }


    public int countFamily() {
        return 2 + Children.length;
    }


    @Override
    public String toString() {
        return "Family{" +
                "Mother=" + Mother +
                ", Father=" + Father +
                ", Children=" + Arrays.toString(Children) +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(Mother, family.Mother) && Objects.equals(Father, family.Father) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Mother, Father, pet);
    }
}
