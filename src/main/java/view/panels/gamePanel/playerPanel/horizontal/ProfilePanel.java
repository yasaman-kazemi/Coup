package view.panels.gamePanel.playerPanel.horizontal;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends CardPanel {
    public ProfilePanel(String imageAddress) {
        super(imageAddress);
        setBackground(new java.awt.Color(51, 102, 204));
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
