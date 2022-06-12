package view.panels.gamePanel.playerPanel.vertical;

import player.Player;
import utils.ImageLoader;
import view.panels.gamePanel.playerPanel.PlayerPanel;

import java.awt.*;

public class LeftRightPlayerPanel extends PlayerPanel {
    private Player player;

    public LeftRightPlayerPanel(Player player, boolean isLeft) {
        setBackground(new Color(153, 153, 255));
        setPreferredSize(new Dimension(128, 338));
        String imageAddress;
        if (isLeft) {
            imageAddress = ImageLoader.getLeftCard();
        } else {
            imageAddress = ImageLoader.getRightCard();
        }
        CoinPanel v1 = new CoinPanel(ImageLoader.getCoin2(), player.getCoin());
        CardPanel v2 = new CardPanel(imageAddress);
        CardPanel v3 = new CardPanel(imageAddress);
        CardPanel v4 = new ProfilePanel(ImageLoader.getMystery());

        javax.swing.GroupLayout leftPlayerPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(leftPlayerPanelLayout);
        leftPlayerPanelLayout.setHorizontalGroup(
                leftPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(v1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(v2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(v3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(v4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPlayerPanelLayout.setVerticalGroup(
                leftPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftPlayerPanelLayout.createSequentialGroup()
                                .addComponent(v1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(v2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(v3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(v4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
}
