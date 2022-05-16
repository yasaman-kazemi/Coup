package view.panels.gamePanel;

import javax.swing.*;

public class CenterPanel extends JPanel {
    public CenterPanel() {
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
                centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 250, Short.MAX_VALUE)
        );
        centerPanelLayout.setVerticalGroup(
                centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 200, Short.MAX_VALUE)
        );
    }
}
