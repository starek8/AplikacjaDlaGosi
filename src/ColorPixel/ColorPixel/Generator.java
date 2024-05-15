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
                }
            }
        }

        try {
            ImageIO.write(image, "png", new File("Painting.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
