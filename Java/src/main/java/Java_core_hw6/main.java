package Java_core_hw6;

public class main
{public static void main(String[] args) {
    Pet dog = new Dog("Rock", 5, 75, new String[]{"eat","drink","sleep"});
    Pet cat = new DomesticCat("Mila", 3, 40, new String[]{"sleep","hunt"});
    Pet fish = new Fish("Nemo", 1, 10, new String[]{"swim"});

    Man father = new Man("Vito", "Karleone", 1975, 90, new String[][]{{"Sunday","rest"}});
    Woman mother = new Woman("Jane", "Karleone", 1977, 85, new String[][]{{"Monday","yoga"}});

    Family family = new Family(mother, father);


    family.setPet(dog);


    Human child = new Human("Michael", "Karleone", 2003, 70, new String[][]{{"Tuesday","football"}, {"Wednesday","piano"}});

    family.addChild(child);


    child.greetPet();
    child.describePet();
    family.getPet().respond();
    family.getPet().eat();

    if (family.getPet() instanceof Foulable) {
        ((Foulable) family.getPet()).foul();
    }


    System.out.println(child);
    System.out.println(family);

    System.out.println("Кількість членів сім'ї: " + family.countFamily());


    father.repairCar();
    mother.makeup();


    boolean deleted = family.deleteChild(new Human("Michael", "Karleone", 2003));
    System.out.println("Дитину видалено? " + deleted);
    System.out.println("Кількість після видалення: " + family.countFamily());
}
    }

