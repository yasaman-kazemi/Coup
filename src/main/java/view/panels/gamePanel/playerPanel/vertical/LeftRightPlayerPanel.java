package view.panels.gamePanel.playerPanel.vertical;

import card.*;
import player.CautiousKiller;
import player.Couper;
import player.Mystery;
import player.Player;
import utils.ImageLoader;
import view.panels.gamePanel.playerPanel.PlayerPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class LeftRightPlayerPanel extends PlayerPanel {
    private Player player;

    public LeftRightPlayerPanel(Player player, boolean isLeft, boolean isYourTurn) {
        super(player, isYourTurn);
        this.player = player;
        setPreferredSize(new Dimension(128, 338));
        String imageAddress1 = getImageAddress(player.getCards().get(0), isLeft, false, true);
        String imageAddress2 = getImageAddress(player.getCards().get(1), isLeft, false, true);
        CoinPanel coinPanel = new CoinPanel(ImageLoader.getCoin(), player);
        CardPanel cardPanel1 = new CardPanel(imageAddress1, player);
        CardPanel cardPanel2 = new CardPanel(imageAddress2, player);
        CardPanel profilePanel = new ProfilePanel(getImage(player, isLeft), player);
        if (isYourTurn) profilePanel.setBorder(new LineBorder(Color.ORANGE, 3));

        javax.swing.GroupLayout leftPlayerPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(leftPlayerPanelLayout);
        leftPlayerPanelLayout.setHorizontalGroup(
                leftPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(coinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPlayerPanelLayout.setVerticalGroup(
                leftPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftPlayerPanelLayout.createSequentialGroup()
                                .addComponent(coinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    public String getImage(Player player, boolean isLeft) {
        if (player instanceof CautiousKiller) {
            if (isLeft) return ImageLoader.getLeftCautiousKiller();
            else return ImageLoader.getRightCautiousKiller();
        } else if (player instanceof Couper) {
            if (isLeft) return ImageLoader.getLeftCouper();
            else return ImageLoader.getRightCouper();
        } else if (player instanceof Mystery) {
            if (isLeft) return ImageLoader.getLeftMystery();
            else return ImageLoader.getRightMystery();
        } else {
            if (isLeft) return ImageLoader.getLeftParanoid();
            else return ImageLoader.getRightParanoid();
        }
    }
}
