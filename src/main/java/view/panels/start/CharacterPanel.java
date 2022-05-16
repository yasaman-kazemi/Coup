package view.panels.start;

import javax.swing.*;
import java.awt.*;

public class CharacterPanel extends JPanel {
    private JLabel avatarImageLabel;
    private JLabel avatarName;

    public CharacterPanel(String avatarAddress, String characterName) {
        avatarImageLabel = new JLabel();
        avatarName = new JLabel();
        setBackground(new java.awt.Color(255, 255, 255));

        avatarImageLabel.setIcon(new javax.swing.ImageIcon(avatarAddress));

        avatarName.setFont(new java.awt.Font("Georgia", Font.PLAIN, 13));
        avatarName.setText(characterName);

        javax.swing.GroupLayout character1PanelLayout = new javax.swing.GroupLayout(this);
        setLayout(character1PanelLayout);
        character1PanelLayout.setHorizontalGroup(
                character1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(character1PanelLayout.createSequentialGroup()
                                .addGroup(character1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(character1PanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(avatarImageLabel))
                                        .addGroup(character1PanelLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(avatarName)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        character1PanelLayout.setVerticalGroup(
                character1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(character1PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(avatarImageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avatarName)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
