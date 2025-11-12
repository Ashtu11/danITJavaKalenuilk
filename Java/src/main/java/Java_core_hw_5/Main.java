package Java_core_hw_5;

public class Main {
    public static void main(String[] args) {
        Pet dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        Pet cat = new DomesticCat("Murka", 2, 45, new String[]{"scratch", "sleep"});
        Pet roboCat = new RoboCat("R2-MEOW", 1, 90, new String[]{"charge", "analyze"});
        Pet fish = new Fish("Nemo", 1, 10, new String[]{"swim"});

        Human mother1 = new Woman("Jane", "Karleone", 1975, (byte) 80);
        Human father1 = new Man("Vito", "Karleone", 1970, (byte) 80);

        Human mother2 = new Woman("Anna", "Smith", 1980, (byte) 90);
        Human father2 = new Man("Michael", "Smith", 1977, (byte) 90);

        mother1.generateCalend();
        mother2.generateCalend();

        System.out.println("Jane's Monday activity: " + mother1.getActivity(DayOfWeek.MONDAY));
        System.out.println("Anna's Friday activity: " + mother2.getActivity(DayOfWeek.FRIDAY));

        Family family1 = new Family(mother1, father1);
        family1.setPet(dog);

        Family family2 = new Family(mother2, father2);
        family2.setPet(cat);

        Human child1 = new Man("Michael", "Karleone", 2000, (byte) 75);
        Human child2 = new Woman("Sophie", "Smith", 2005, (byte) 85);

        family1.addChild(child1);
        family2.addChild(child2);

        family1.getPet().eat();
        family2.getPet().eat();
        family2.setPet(roboCat);

        System.out.println(" Family 1 ");
        System.out.println(family1);
        System.out.println("Number of family members:" + family1.countFamily());
        child1.greetPet();
        child1.describePet();

        System.out.println("\nFamily 2 ");
        System.out.println(family2);
        System.out.println("Number of family members:" + family2.countFamily());
        child2.greetPet();
        child2.describePet();

        System.out.println("\nAre families the same? " + family1.equals(family2));
        System.out.println("Are the parents the same? " + father1.equals(father2));
        System.out.println("Are the animals the same?" + dog.equals(cat));

        ((Man) father1).repairCar();
        ((Woman) mother2).makeup();
    }


}










