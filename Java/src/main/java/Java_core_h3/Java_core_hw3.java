package Java_core_h3;
import java.util.Scanner;

public class Java_core_hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] DaysOfTheWEEk = new String[7][2];

        DaysOfTheWEEk[0][0] = "Sunday";
        DaysOfTheWEEk[0][1] = "do home work";

        DaysOfTheWEEk[1][0] = "Monday";
        DaysOfTheWEEk[1][1] = "go to courses; watch a film";

        DaysOfTheWEEk[2][0] = "Tuesday";
        DaysOfTheWEEk[2][1] = "go to the gym";

        DaysOfTheWEEk[3][0] = "Wednesday";
        DaysOfTheWEEk[3][1] = "meet with friends";

        DaysOfTheWEEk[4][0] = "Thursday";
        DaysOfTheWEEk[4][1] = "study Java";

        DaysOfTheWEEk[5][0] = "Friday";
        DaysOfTheWEEk[5][1] = "clean the room";

        DaysOfTheWEEk[6][0] = "Saturday";
        DaysOfTheWEEk[6][1] = "rest and play games";


        while (true) {
            System.out.println("Please, input the day of the week:");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
            boolean found = false;
            for (int i = 0; i < DaysOfTheWEEk.length; i++) {
                if (DaysOfTheWEEk[i][0].equalsIgnoreCase(input)) {
                    System.out.println("Your tasks for " + DaysOfTheWEEk[i][0] + ": " + DaysOfTheWEEk[i][1] + ".");
                    found = true;
                    break;
                }
            }


            if (!found) {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }

        scanner.close();
    }
}
