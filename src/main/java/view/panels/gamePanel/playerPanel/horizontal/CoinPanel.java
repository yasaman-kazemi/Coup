package view.panels.gamePanel.playerPanel.horizontal;

import javax.swing.*;
import java.awt.*;

public class CoinPanel extends CardPanel {
    private int coinCount;

    public CoinPanel(String imageAddress, int coinCount) {
        super(imageAddress);
        this.coinCount = coinCount;
        JLabel coinCountLabel = new JLabel();
        setBackground(Color.yellow);

        setPreferredSize(new Dimension(80, 128));

        coinCountLabel.setFont(new java.awt.Font("Helvetica Neue", Font.PLAIN, 18));
        coinCountLabel.setText("X " + coinCount);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(this);
        setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(25, Short.MAX_VALUE)
                                .addComponent(coinCountLabel)
                                .addGap(29, 29, 29)
                        )
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(105, Short.MAX_VALUE)
                                .addComponent(coinCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
