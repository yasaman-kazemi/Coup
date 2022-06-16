package view;

import utils.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    protected ViewController viewController;
    private Image image;

    public MyPanel(ViewController viewController) {
        this.viewController = viewController;
        setPreferredSize(new java.awt.Dimension(808, 588));

        try {
            image = ImageIO.read(new File(ImageLoader.getBackGround()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 788, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 588, Short.MAX_VALUE)
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
