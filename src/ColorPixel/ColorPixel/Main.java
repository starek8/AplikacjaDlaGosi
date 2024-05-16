package ColorPixel;

public class Main {
    public static void main(String[] args) {

        int Columns = Integer.parseInt(args[0]);
        int Rows = Integer.parseInt(args[1]);
        int per1 =50;
        int per2 =25;
        int per3 =10;
        char[][] painting = new char[Columns][Rows];

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                painting[j][i] = 'B';  //Black filling
            }
        }

        RandomColor.RandomGen(painting, Columns, Rows, per1,'W');
        RandomColor.RandomGen(painting, Columns, Rows, per2,'G');
        RandomColor.RandomGen(painting, Columns, Rows, per2,'R');

        new GUI(painting, Columns, Rows);



    }
}
