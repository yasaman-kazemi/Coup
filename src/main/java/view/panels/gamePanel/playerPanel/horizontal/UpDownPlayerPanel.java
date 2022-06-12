package view.panels.gamePanel.playerPanel.horizontal;

import card.*;
import player.*;
import utils.ImageLoader;
import view.panels.gamePanel.playerPanel.PlayerPanel;

import javax.swing.*;
import java.util.ArrayList;

public class UpDownPlayerPanel extends PlayerPanel {
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private Player player;

    public UpDownPlayerPanel(Player player, boolean isYou) {
        this.player = player;
        String imageAddress1;
        String imageAddress2;
        if (isYou) {
            ArrayList<Card> cards = player.getCards();
            Card card0 = cards.get(0);
            Card card1 = cards.get(1);
            imageAddress1 = getImage(card0);
            imageAddress2 = getImage(card1);
        } else {
            imageAddress1 = ImageLoader.getUpCard();
            imageAddress2 = ImageLoader.getUpCard();
        }
        panel1 = new CoinPanel(ImageLoader.getCoin2(), player.getCoin());
        panel2 = new CardPanel(imageAddress1);
        panel3 = new CardPanel(imageAddress2);
        panel4 = new ProfilePanel(getImage(player));

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
