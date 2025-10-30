package Code;

import java.util.Scanner;
import java.util.Arrays;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let the game begin!");
        System.out.println("Enter your name,please!");
        String name = scanner.next();
        int magicNumber = (int) (Math.random() * 101);
        int[] numbers = new int[99];
        int count = 0;

        while (true) {

            System.out.println("Print your number!");
            int number = scanner.nextInt();
            numbers[count] = number;
            count++;
            if (number > magicNumber) {
                System.out.println("Your number is too big. Please, try again..");
            } else if (number < magicNumber) {
                System.out.println("Your number is too small. Please, try again.. ");
            } else if (number == magicNumber) {
                System.out.println("Congratulations, " + name);
                int[] usedNumbers = Arrays.copyOf(numbers, count);
                Arrays.sort(usedNumbers);
                System.out.print("Your numbers: ");
                for (int i = 0; i < count; i++) {
                    System.out.print(numbers[i] + " ");
                }
                break;
            }
        }
    }
}
