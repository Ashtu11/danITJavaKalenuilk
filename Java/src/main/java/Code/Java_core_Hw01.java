package Code;

import java.util.Scanner;

public class Java_core_Hw01 {
    public static void main(String[] args) {
        System.out.println("All Set. Get ready to rumble!");
        Scanner scanner = new Scanner(System.in);
        char[][] place = new char[5][5];
        boolean gameOVER = false;

        int column = (int) (Math.random() * 5);
        int columnTWO = (int) (Math.random() * 5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                place[i][j] = '-';
            }
        }
        while (gameOVER == false) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    System.out.print(place[row][col]);
                }
                System.out.println();
            }
            System.out.println("Column one!");
            int numb = scanner.nextInt();
            System.out.println("Column TWO!");
            int numTWO = scanner.nextInt();
            if (numb > 5 || numb < 0 || numTWO < 0 || numTWO > 5) {
                System.out.println("Pls,try again");
                continue;
            }
            if (place[numb-1][numTWO-1] == '*') {
                System.out.println("ви сюди стріляли, оберіть інше місце");
                continue;
            }
            if (numb == column && numTWO == columnTWO) {
                gameOVER = true;
                scanner.close();
                System.out.println("You have won!");
                place[numb - 1][numTWO - 1] = 'x';
                for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 5; col++) {
                        System.out.print(place[row][col]);
                    }
                    System.out.println();
                }
            } else {
                place[numb - 1][numTWO - 1] = '*';

            }

        }
    }
}



