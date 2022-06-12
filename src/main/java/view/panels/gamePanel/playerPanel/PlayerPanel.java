package view.panels.gamePanel.playerPanel;

import card.*;
import player.*;
import utils.ImageLoader;

import javax.swing.*;

public class PlayerPanel extends JPanel {

    public String getImage(Player player) {
        if (player instanceof CautiousKiller) {
            return ImageLoader.getCautiousKiller();
        } else if (player instanceof Couper) {
            return ImageLoader.getCouper();
        } else if (player instanceof Mystery) {
            return ImageLoader.getMystery();
        } else if (player instanceof Paranoid){
            return ImageLoader.getParanoid();
        } else {
            return ImageLoader.getDuke();
        }
    }

    public String getImage(Card card) {
        if (card instanceof Ambassador) {
            return ImageLoader.getAmbassador();
        } else if (card instanceof Assassin) {
            return ImageLoader.getAssassin();
        } else if (card instanceof Commander) {
            return ImageLoader.getCommander();
        } else if (card instanceof Duke) {
            return ImageLoader.getDuke();
        } else {
            return ImageLoader.getPrinces();
        }
    }
}
