package java_core_hw1;

import java.util.Scanner;

public class AreaShooting {
    public static void main(String[] args) {
        System.out.println("All Set. Get ready to rumble!");
        Scanner scanner = new Scanner(System.in);
        char[][] place = new char[5][5];
        boolean gameOver = false;

        int column = (int) (Math.random() * 5);
        int Row = (int) (Math.random() * 5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                place[i][j] = '-';
            }
        }
        while (gameOver == false) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    System.out.print(place[row][col]);
                }
                System.out.println();
            }
            System.out.println("Enter row pls!");
            int EnteredRow = scanner.nextInt();
            System.out.println("Enter column!");
            int EnteredColumn = scanner.nextInt();
            if (EnteredColumn > 5 || EnteredColumn < 0 || EnteredRow < 0 || EnteredRow > 5) {
                System.out.println("Pls,try again");
                continue;
            }
            if (place[EnteredRow-1][EnteredColumn-1] == '*') {
                System.out.println("You're already shooting here.");
                continue;
            }
            if (EnteredRow == column && EnteredColumn == Row) {
                gameOver = true;
                scanner.close();
                System.out.println("You have won!");
                place[EnteredRow - 1][EnteredColumn - 1] = 'x';
                for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 5; col++) {
                        System.out.print(place[row][col]);
                    }
                    System.out.println();
                }
            } else {
                place[EnteredRow - 1][EnteredColumn - 1] = '*';

            }

        }
    }
}



