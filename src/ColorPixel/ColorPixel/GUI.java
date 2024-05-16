package ColorPixel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {


    int pixelSize = 1;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height - 70;

    public GUI(char[][] painting, int Columns, int Rows){
        JFrame frame = new JFrame("ColorPixel");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel functionPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        JButton Pixel = new JButton("Pixel");
        frame.add(Pixel, BorderLayout.EAST);
        JButton Painting = new JButton("Painting");
        frame.add(Painting, BorderLayout.WEST);
        functionPanel.add(Pixel);
        functionPanel.add(Painting);

        ImageIcon icon = new ImageIcon("Painting.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

        JLabel label = new JLabel(icon);
        frame.add(label, BorderLayout.CENTER);

        Generator.generateImage(painting, Columns, Rows);
        refreshImage(label,Columns, Rows, screenWidth, screenHeight);

        frame.add(functionPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
    public void refreshImage(JLabel label, int Columns, int Rows, int screenHeight, int screenWidth) {
        boolean flag = screenHeight < Rows || screenWidth < Columns;

        ImageIcon icon = new ImageIcon( "Painting.png");
        Image image = icon.getImage();
        Image newimg = flag ?
                image.getScaledInstance(1365, 170, Image.SCALE_SMOOTH) :
                image.getScaledInstance(Columns * pixelSize, Rows * pixelSize, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        label.setIcon(icon);

    }

}
