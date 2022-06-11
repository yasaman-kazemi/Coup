package view.panels.gamePanel;

import javax.swing.*;

public class CenterPanel extends JPanel {
    public CenterPanel() {
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(160, 128));

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
                centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );
        centerPanelLayout.setVerticalGroup(
                centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 128, Short.MAX_VALUE)
        );
    }
}
