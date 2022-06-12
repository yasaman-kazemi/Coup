package view.panels.gamePanel.playerPanel.vertical;

import javax.swing.*;
import java.awt.*;

public class CoinPanel extends CardPanel {
    private int coinCount;

    public CoinPanel(String imageAddress, int coinCount) {
        super(imageAddress);
        this.coinCount = coinCount;
        setBackground(Color.yellow);
        JLabel jLabel1 = new JLabel();

        jLabel1.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        jLabel1.setText("X " + coinCount);

        GroupLayout v1Layout = new GroupLayout(this);
        setLayout(v1Layout);
        v1Layout.setHorizontalGroup(
                v1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, v1Layout.createSequentialGroup()
                                .addContainerGap(96, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap())
        );
        v1Layout.setVerticalGroup(
                v1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(v1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addContainerGap(26, Short.MAX_VALUE))
        );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
