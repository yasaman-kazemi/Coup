package view.panels.gamePanel.playerPanel.vertical;

import player.Player;

import javax.swing.*;
import java.awt.*;

public class CoinPanel extends CardPanel {
    public CoinPanel(String imageAddress, Player player) {
        super(imageAddress, player);
        setBackground(Color.yellow);
        JLabel coinCounterLabel = new JLabel();

        coinCounterLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        coinCounterLabel.setText("X " + player.getCoin());

        GroupLayout coinPanelLayout = new GroupLayout(this);
        setLayout(coinPanelLayout);
        coinPanelLayout.setHorizontalGroup(
                coinPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, coinPanelLayout.createSequentialGroup()
                                .addContainerGap(96, Short.MAX_VALUE)
                                .addComponent(coinCounterLabel)
                                .addContainerGap())
        );
        coinPanelLayout.setVerticalGroup(
                coinPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(coinPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(coinCounterLabel)
                                .addContainerGap(26, Short.MAX_VALUE))
        );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
