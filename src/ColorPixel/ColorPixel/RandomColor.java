package ColorPixel;

import java.util.Random;

public class RandomColor {
    int randomNumber;
    public void RandomGen(char[][] painting, int Columns, int Rows, int per, char color){
        Random random=new Random();

        if(per == 5){
            randomNumber = random.nextInt(101);
            for(int i = 0; i < Rows; i++){
                for(int j = 0; j < Columns; j++){
                    randomNumber = random.nextInt(101);
                    if(randomNumber >=0 && randomNumber <=20) {
                        painting[i][j] = color;
                    }
                }
            }
        }else if(per == 10){
            randomNumber = random.nextInt(101);
            for(int i = 0; i < Rows; i++) {
                for (int j = 0; j < Columns; j++) {
                    randomNumber = random.nextInt(101);
                    if (randomNumber >= 0 && randomNumber <= 10) {
                        painting[i][j] = color;
                    }
                }
            }

        }else if(per == 25){
            randomNumber = random.nextInt(101);
                for(int i = 0; i < Rows; i++) {
                    for (int j = 0; j < Columns; j++) {
                        randomNumber = random.nextInt(101);
                        if (randomNumber >= 0 && randomNumber <= 4) {
                            painting[i][j] = color;
                        }
                    }
                }

        }else if(per == 50){
            randomNumber = random.nextInt(101);
            for(int i = 0; i < Rows; i++) {
                for (int j = 0; j < Columns; j++) {
                    randomNumber = random.nextInt(101);
                    if (randomNumber >= 0 && randomNumber <= 2) {
                        painting[i][j] = color;
                    }
                }
            }

        }else{
            System.out.println(per+"This % is not allowed");
        }
    }
}
