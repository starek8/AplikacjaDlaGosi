package ColorPixel;

import java.util.Random;

public class RandomColor {
    public static void RandomGen(char[][] painting, int Columns, int Rows, int per, char color) {
        Random random = new Random();
        int randomNumber;

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                randomNumber = random.nextInt(101);
                if (randomNumber <= per) {
                    painting[i][j] = color;
                }
            }
        }

        if (per > 100) {
            System.out.println(per + " This % is not allowed");
        }

    }
}
