package ColorPixel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Generator {
    public static void generateImage(char[][] painting, int Columns, int Rows) {
        BufferedImage image = new BufferedImage(Columns, Rows, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                if (painting[j][i] == 'B') {
                    image.setRGB(j, i, Color.BLACK.getRGB());
                }else if (painting[j][i] == 'W') {
                    image.setRGB(j, i, Color.WHITE.getRGB());
                }else if (painting[j][i] == 'R') {
                    image.setRGB(j, i, Color.RED.getRGB());
                }else if (painting[j][i] == 'G') {
                    image.setRGB(j, i, Color.GREEN.getRGB());
                }else if (painting[j][i] == 'b') {
                    image.setRGB(j, i, Color.BLUE.getRGB());
                }else if (painting[j][i] == 'O') {
                    image.setRGB(j, i, Color.ORANGE.getRGB());
                }else{
                    System.out.println("Wrong color in char[][]");
                }
            }
        }

        try {
            ImageIO.write(image, "png", new File("Painting.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateOneColor(char[][] painting, int Columns, int Rows, char color) {

        String filename = "Painting";

        filename = filename + color + ".png";

        BufferedImage image = new BufferedImage(Columns, Rows, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                if (painting[j][i] == 'B' && painting[j][i] != color) {
                    image.setRGB(j, i, Color.BLACK.getRGB());
                }else if (painting[j][i] == 'W' &&  color =='W') {
                    image.setRGB(j, i, Color.WHITE.getRGB());
                }else if (painting[j][i] == 'R' &&  color =='R') {
                    image.setRGB(j, i, Color.RED.getRGB());
                }else if (painting[j][i] == 'G' &&  color =='G') {
                    image.setRGB(j, i, Color.GREEN.getRGB());
                }else if (painting[j][i] == 'b' &&  color =='b') {
                    image.setRGB(j, i, Color.BLUE.getRGB());
                }else if (painting[j][i] == 'O' &&  color =='O') {
                    image.setRGB(j, i, Color.ORANGE.getRGB());
                }
            }
        }
        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
