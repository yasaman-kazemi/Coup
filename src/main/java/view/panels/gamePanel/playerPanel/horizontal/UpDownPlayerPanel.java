package view.panels.gamePanel.playerPanel.horizontal;

import card.*;
import player.*;
import utils.ImageLoader;
import view.panels.gamePanel.playerPanel.PlayerPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class UpDownPlayerPanel extends PlayerPanel {
    private CoinPanel coinPanel;
    private CardPanel cardPanel1;
    private CardPanel cardPanel2;
    private ProfilePanel profilePanel;

    public UpDownPlayerPanel(Player player, boolean isDown, boolean isYourTurn) {
        super(player, isYourTurn);
        String imageAddress1 = getImageAddress(player.getCards().get(0), isDown, isDown, false);
        String imageAddress2 = getImageAddress(player.getCards().get(1), isDown, isDown, false);
        coinPanel = new CoinPanel(ImageLoader.getCoin(), player.getCoin());
        cardPanel1 = new CardPanel(imageAddress1);
        cardPanel2 = new CardPanel(imageAddress2);
        profilePanel = new ProfilePanel(getImage(player));

        if (isYourTurn) {
            profilePanel.setBorder(new LineBorder(Color.ORANGE, 3));
        }

        setLayout();
    }

    private void setLayout() {
        GroupLayout downPlayerPanelLayout = new GroupLayout(this);
        setLayout(downPlayerPanelLayout);
        downPlayerPanelLayout.setHorizontalGroup(
                downPlayerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(downPlayerPanelLayout.createSequentialGroup()
                                .addComponent(coinPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profilePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        downPlayerPanelLayout.setVerticalGroup(
                downPlayerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(coinPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profilePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public String getImage(Player player) {
        if (player instanceof CautiousKiller) {
            return ImageLoader.getUpCautiousKiller();
        } else if (player instanceof Couper) {
            return ImageLoader.getUpCouper();
        } else if (player instanceof Mystery) {
            return ImageLoader.getUpMystery();
        } else if (player instanceof Paranoid){
            return ImageLoader.getUpParanoid();
        } else {
            return ImageLoader.getTempAvatar();
        }
    }
}
