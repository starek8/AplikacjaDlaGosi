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
    int Columns = 10;
    int Rows = 10;

    public GUI(){

        JFrame frame = new JFrame("ColorPixel");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame2 = new JFrame("SET YOUR PAINTING SIZE");
        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(new FlowLayout());

        JLabel xAxis = new JLabel("X-Axis");
        JLabel yAxis = new JLabel("Y-Axis");
        final JTextField xAxisPlace = new JTextField(20);
        final JTextField yAxisPlace = new JTextField(20);

        frame2.add(xAxis, BorderLayout.CENTER);
        frame2.add(xAxisPlace, BorderLayout.CENTER);
        frame2.add(yAxis, BorderLayout.CENTER);
        frame2.add(yAxisPlace, BorderLayout.CENTER);

        JButton confirm = new JButton("Confirm");
        frame2.add(confirm, BorderLayout.SOUTH);


        ImageIcon smileyFace = new ImageIcon("png-clipart-smiley-desktop-happiness-face-smiley-miscellaneous-face-thumbnail.png");
        frame2.add(new JLabel(smileyFace), BorderLayout.EAST);
        frame2.pack(); // this part is responsible for making the page small
        frame2.setVisible(true);

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String tmp = yAxisPlace.getText();
                Columns = Integer.parseInt(tmp);
                tmp = xAxisPlace.getText();
                Rows = Integer.parseInt(tmp);

                frame.setVisible(true);
            }
        });

        char[][] painting = new char[Columns][Rows];

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                painting[j][i] = 'B';  //Black filling
            }
        }

        JPanel functionPanel = new JPanel();

        JLabel Color = new JLabel("Color");
        JLabel Percent = new JLabel("Percent");
        final JTextField ColorPlace= new JTextField(20);
        final JTextField PercentPlace = new JTextField(20);

        JButton Generate = new JButton("Generate");
        frame.add(Generate, BorderLayout.EAST);

        functionPanel.add(Color);
        functionPanel.add(ColorPlace);
        functionPanel.add(Percent);
        functionPanel.add(PercentPlace);
        functionPanel.add(Generate);

        ImageIcon icon = new ImageIcon("Painting.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

        JLabel label = new JLabel(icon);
        frame.add(label, BorderLayout.CENTER);

        if (screenWidth / Columns < screenHeight / Rows) {
            pixelSize = screenWidth / Columns;
        } else {
            pixelSize = screenHeight / Rows;
        }

        if (pixelSize == 0){
            pixelSize = 1;
        }

        Generator.generateImage(painting, Columns, Rows);
        refreshImage(label,Columns, Rows, screenWidth, screenHeight);

        frame.add(functionPanel, BorderLayout.NORTH);

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
