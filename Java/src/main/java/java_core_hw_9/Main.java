package java_core_hw_9;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        CollectionFamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        FamilyController controller = new FamilyController(service);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {

            printMenu();
            System.out.print("Enter command number (or 'exit'): ");
            String input = scanner.nextLine().trim();

            try {
                if (input.equalsIgnoreCase("exit")) {
                    running = false;
                    System.out.println("Exiting...");
                    continue;
                }

                int cmd = Integer.parseInt(input);
                switch (cmd) {

                    case 1:
                        seedTestData(controller);
                        System.out.println("Test data created.");

                        System.out.println("\n=== Loaded Families ===");
                        controller.getAllFamilies().forEach(f -> {
                            System.out.println(f.prettyFormat());
                            System.out.println();
                        });
                        System.out.println("====================================\n");

                        break;

                    case 2:
                        controller.displayAllFamilies();
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        int bigger = Integer.parseInt(scanner.nextLine().trim());
                        controller.getFamiliesBiggerThan(bigger);
                        break;

                    case 4:
                        System.out.print("Enter number: ");
                        int less = Integer.parseInt(scanner.nextLine().trim());
                        controller.getFamiliesLessThan(less);
                        break;

                    case 5:
                        System.out.print("Enter number: ");
                        int eq = Integer.parseInt(scanner.nextLine().trim());
                        int count = controller.countFamiliesWithMemberNumber(eq);
                        System.out.println("Count: " + count);
                        break;

                    case 6:
                        createFamily(scanner, controller);
                        break;

                    case 7:
                        System.out.print("Enter family ID to delete (number): ");
                        int delId = Integer.parseInt(scanner.nextLine().trim());
                        boolean deleted = controller.deleteFamilyByIndex(delId - 1);
                        System.out.println("Deleted: " + deleted);
                        break;

                    case 8:
                        editFamilyMenu(scanner, controller);
                        break;

                    case 9:
                        System.out.print("Enter age threshold: ");
                        int age = Integer.parseInt(scanner.nextLine().trim());
                        controller.deleteAllChildrenOlderThan(age);
                        System.out.println("Deleted children older than " + age);
                        break;

                    default:
                        System.out.println("Unknown command.");
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number format. Please enter digits only.");
            } catch (FamilyOverflowException foe) {
                System.out.println("Family error: " + foe.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Seed test data");
        System.out.println("2. Display all families");
        System.out.println("3. Display families with members > n");
        System.out.println("4. Display families with members < n");
        System.out.println("5. Count families with member number = n");
        System.out.println("6. Create new family");
        System.out.println("7. Delete family by index");
        System.out.println("8. Edit family");
        System.out.println("9. Delete all children older than age");
        System.out.println("Type 'exit' to quit.");
    }

    private static void printEditMenu() {
        System.out.println("=== EDIT MENU ===");
        System.out.println("1. Born child");
        System.out.println("2. Adopt child");
        System.out.println("3. Back to main menu");
    }

    private static void createFamily(Scanner scanner, FamilyController controller) {
        System.out.print("Mother name: ");
        String mname = scanner.nextLine().trim();

        System.out.print("Mother surname: ");
        String msurname = scanner.nextLine().trim();

        System.out.print("Mother birth YEAR: ");
        int myear = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Mother birth MONTH (1–12): ");
        int mmonth = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Mother birth DAY (1–31): ");
        int mday = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Mother IQ: ");
        byte miq = Byte.parseByte(scanner.nextLine().trim());


        System.out.print("Father name: ");
        String fname = scanner.nextLine().trim();

        System.out.print("Father surname: ");
        String fsurname = scanner.nextLine().trim();

        System.out.print("Father birth YEAR: ");
        int fyear = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Father birth MONTH (1–12): ");
        int fmonth = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Father birth DAY (1–31): ");
        int fday = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Father IQ: ");
        byte fiq = Byte.parseByte(scanner.nextLine().trim());


        String motherBirth = String.format("%02d/%02d/%04d", mday, mmonth, myear);
        String fatherBirth = String.format("%02d/%02d/%04d", fday, fmonth, fyear);

        Human mother = new Woman(mname, msurname, motherBirth, miq);
        Human father = new Man(fname, fsurname, fatherBirth, fiq);

        controller.createNewFamily(mother, father);
        System.out.println("Family created.");
    }

    private static void editFamilyMenu(Scanner scanner, FamilyController controller) {
        boolean editing = true;

        while (editing) {
            printEditMenu();
            System.out.print("Choose edit option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": {
                    System.out.print("Enter family ID: ");
                    int famId = Integer.parseInt(scanner.nextLine().trim());
                    Family fam = controller.getFamilyById(famId - 1);

                    if (fam == null) {
                        System.out.println("Family not found.");
                        break;
                    }

                    System.out.print("Boy name: ");
                    String boy = scanner.nextLine().trim();
                    System.out.print("Girl name: ");
                    String girl = scanner.nextLine().trim();

                    controller.bornChild(fam, boy, girl);
                    System.out.println("Child born.");
                    break;
                }

                case "2": {
                    System.out.print("Enter family ID: ");
                    int famId = Integer.parseInt(scanner.nextLine().trim());
                    Family fam = controller.getFamilyById(famId - 1);

                    if (fam == null) {
                        System.out.println("Family not found.");
                        break;
                    }

                    System.out.print("Child name: ");
                    String cname = scanner.nextLine().trim();
                    System.out.print("Child surname: ");
                    String csurname = scanner.nextLine().trim();
                    System.out.print("Child birth year: ");
                    int cyear = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Child IQ: ");
                    byte ciq = Byte.parseByte(scanner.nextLine().trim());

                    Human adopted = new Human(cname, csurname, cyear, ciq);
                    controller.adoptChild(fam, adopted);
                    System.out.println("Child adopted.");
                    break;
                }

                case "3":
                    editing = false;
                    break;

                default:
                    System.out.println("Unknown edit option.");
            }
        }
    }

    private static void seedTestData(FamilyController controller) {

        Human m1 = new Woman("Kate", "Bibo", 1991, (byte)95);
        Human f1 = new Man("Karl", "Bibo", 1990, (byte)90);
        Family fam1 = controller.createNewFamily(m1, f1);

        Human c1 = new Human("Donna", "Bibo", "23/10/2018", (byte)92);
        Human c2 = new Human("Sun", "Bibo", "23/10/2018", (byte)92);
        Human c3 = new Human("Kurt", "Kobein", "05/05/2003", (byte)85);

        fam1.addChild(c1);
        fam1.addChild(c2);
        fam1.addChild(c3);

        Set<String> habits1 = new HashSet<>();
        habits1.add("sleep");

        Set<String> habits2 = new HashSet<>();
        habits2.add("eat");
        habits2.add("play");

        Pet p1 = new Dog("Jack", 3, 35, habits1);
        Pet p2 = new RoboCat("Oscar", 5, 81, habits2);

        fam1.addPet(p1);
        fam1.addPet(p2);
        controller.addPet(controller.getAllFamilies().indexOf(fam1), p1);
        controller.addPet(controller.getAllFamilies().indexOf(fam1), p2);

        Human m2 = new Woman("Anna", "Smith", 1988, (byte)88);
        Human f2 = new Man("John", "Smith", 1985, (byte)92);
        Family fam2 = controller.createNewFamily(m2, f2);

        Human c4 = new Human("Kurt", "Kobein", "05/05/2003", (byte)85);
        fam2.addChild(c4);
    }
}