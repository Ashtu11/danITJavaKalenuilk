package Java_core_hw4;

public class Main {
    public static void main(String[] args) {
        Pet dog = new Pet("Rock", "dog", 75, 5, new String[]{"eat", "drink", "sleep"});
        Pet cat = new Pet("", "Murka", 45, 2, new String[]{"scratch", "sleep"});


        Human mother1 = new Human("Jane", "Karleone", 1975, (byte) 80);
        Human father1 = new Human("Vito", "Karleone", 1970, (byte) 80);

        Human mother2 = new Human("Anna", "Smith", 1980, (byte) 90);
        Human father2 = new Human("Michael", "Karleone", 1977, (byte) 90);


        Family family1 = new Family(mother1, father1);
        family1.setPet(dog);

        Family family2 = new Family(mother2, father2);
        family2.setPet(cat);


        Human child1 = new Human("Michael", "Karleone", 2000);
        Human child2 = new Human("Sophie", "Smith", 2005);


        family1.addChild(child1);
        family2.addChild(child2);


        System.out.println(" Family 1 ");
        System.out.println(family1);
        System.out.println("Number of family members:" + family1.countFamily());
        child1.greetPet();
        child1.describePet();

        System.out.println("\nFamily 2 ");
        System.out.println(family2);
        System.out.println("Number of family members: " + family2.countFamily());
        child2.greetPet();
        child2.describePet();


        System.out.println("\nAre families the same? " + family1.equals(family2));
        System.out.println("Are the parents the same? " + father1.equals(father2));
        System.out.println("Are the animals the same? " + dog.equals(cat));
    }
}










