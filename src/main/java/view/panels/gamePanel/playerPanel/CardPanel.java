package view.panels.gamePanel.playerPanel;

import javax.swing.*;

public class CardPanel extends JPanel {
    public CardPanel() {
        setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
                cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );
        cardPanelLayout.setVerticalGroup(
                cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 128, Short.MAX_VALUE)
        );
    }
}
