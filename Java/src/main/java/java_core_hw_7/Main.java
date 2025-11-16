package java_core_hw_7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        FamilyController controller = new FamilyController(service);

        Pet dog = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        Pet cat = new DomesticCat("Murka", 2, 45, new HashSet<>(Arrays.asList("scratch", "sleep")));
        Pet roboCat = new RoboCat("R2-MEOW", 1, 90, new HashSet<>(Arrays.asList("charge", "analyze")));
        Pet fish = new Fish("Nemo", 1, 10, new HashSet<>(Arrays.asList("swim")));

        Human mother1 = new Woman("Jane", "Karleone", 1975, (byte) 80);
        Human father1 = new Man("Vito", "Karleone", 1970, (byte) 80);

        Human mother2 = new Woman("Anna", "Smith", 1980, (byte) 90);
        Human father2 = new Man("Michael", "Smith", 1977, (byte) 90);

        Family f1 = controller.createNewFamily(mother1, father1);
        Family f2 = controller.createNewFamily(mother2, father2);

        mother1.generateCalend();
        mother2.generateCalend();

        System.out.println("Jane's Monday activity: " + mother1.getActivity(DayOfWeek.MONDAY));
        System.out.println("Anna's Friday activity: " + mother2.getActivity(DayOfWeek.FRIDAY));

        Family family1 = new Family(mother1, father1);
        family1.addPet(dog);

        Family family2 = new Family(mother2, father2);
        family2.addPet(cat);

        Human child1 = new Man("Michael", "Karleone", 2000, (byte) 75);
        Human child2 = new Woman("Sophie", "Smith", 2005, (byte) 85);

        family1.addChild(child1);
        family2.addChild(child2);

        Human adoptedChild = new Woman("Jane", "Karloene", 1975, (byte) 80);
        family1.addChild(adoptedChild);

        System.out.println("\nAdopted child age: " + adoptedChild.describeAge());

        family1.getPets().forEach(Pet::eat);
        family2.getPets().forEach(Pet::eat);
        fish.eat();

        family2.addPet(roboCat);

        System.out.println("\nFamily 1 ");
        System.out.println(family1);
        System.out.println("Number of family members: " + family1.countFamily());
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

        ((Man) father1).repairCar();
        ((Woman) mother2).makeup();

        System.out.println("\n===== CONTROLLER METHODS DEMO =====\n");

        controller.displayAllFamilies();

        List<Family> all = controller.getAllFamilies();
        System.out.println("\nAll families from controller: " + all);

        System.out.println("\nFamilies bigger than 2:");
        System.out.println(controller.getFamiliesBiggerThan(2));

        System.out.println("\nFamilies less than 4:");
        System.out.println(controller.getFamiliesLessThan(4));

        System.out.println("\nFamilies with 3 members: "
                + controller.countFamiliesWithMemberNumber(3));

        System.out.println("\nBorn child for first family via controller:");
        controller.bornChild(f1, "John", "Emily");
        System.out.println(f1);

        System.out.println("\nAdopt child to second family:");
        controller.adoptChild(f2, new Woman("Lilly", "Adopted", 2015, (byte) 50));
        System.out.println(f2);

        System.out.println("\nDelete all children older than 18:");
        controller.deleteAllChildrenOlderThan(18);
        controller.displayAllFamilies();

        System.out.println("\nFamily count: " + controller.count());

        System.out.println("\nFamily by id (0): " + controller.getFamilyById(0));

        System.out.println("\nPets of family index 0: " + controller.getPets(0));

        System.out.println("\nAdd fish to family 0:");
        controller.addPet(0, fish);
        System.out.println(controller.getPets(0));

        System.out.println("\nDelete family by index 1");
        controller.deleteFamilyByIndex(1);
        controller.displayAllFamilies();
    }
}