package ColorPixel;

public class Main {
    public static void main(String[] args) {

        int Columns = Integer.parseInt(args[0]);
        int Rows = Integer.parseInt(args[1]);
        char[][] painting = new char[Columns][Rows];

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                painting[j][i] = 'B';  //Black filling
            }
        }

        //new GUI(painting, Columns, Rows);



    }
}
