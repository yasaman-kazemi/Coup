package view.panels.gamePanel;

import utils.ImageLoader;
import view.panels.gamePanel.playerPanel.horizontal.CardPanel;
import view.panels.gamePanel.playerPanel.horizontal.CoinPanel;

import javax.swing.*;

public class CenterPanel extends JPanel {
    public CenterPanel(int deskCoin) {
        setPreferredSize(new java.awt.Dimension(182, 128));

        CardPanel cardPanel = new CardPanel(ImageLoader.getBehindCard());
        CoinPanel coinPanel = new CoinPanel(ImageLoader.getCoin(), deskCoin);

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
                centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                                .addComponent(coinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        centerPanelLayout.setVerticalGroup(
                centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
