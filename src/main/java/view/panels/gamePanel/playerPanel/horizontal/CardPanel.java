package view.panels.gamePanel.playerPanel.horizontal;

import utils.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CardPanel extends JPanel {
    protected Image image;

    public CardPanel(String imageAddress) {
        try {
            image = ImageIO.read(new File(imageAddress));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBackground(new java.awt.Color(51, 102, 204));
        setLayout();
    }

    private void setLayout() {
        GroupLayout cardPanelLayout = new GroupLayout(this);
        setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
                cardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );
        cardPanelLayout.setVerticalGroup(
                cardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 128, Short.MAX_VALUE)
        );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
