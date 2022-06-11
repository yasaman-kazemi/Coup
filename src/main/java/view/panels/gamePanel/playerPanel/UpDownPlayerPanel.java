package view.panels.gamePanel.playerPanel;

import javax.swing.*;

public class UpDownPlayerPanel extends JPanel {
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public UpDownPlayerPanel() {
        panel1 = new CardPanel();
        panel2 = new CardPanel();
        panel3 = new CardPanel();
        panel4 = new CardPanel();

        setLayout();
    }

    private void setLayout() {
        setBackground(new java.awt.Color(153, 153, 255));

        GroupLayout downPlayerPanelLayout = new GroupLayout(this);
        setLayout(downPlayerPanelLayout);
        downPlayerPanelLayout.setHorizontalGroup(
                downPlayerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(downPlayerPanelLayout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        downPlayerPanelLayout.setVerticalGroup(
                downPlayerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
