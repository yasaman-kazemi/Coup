package view.panels.gamePanel.playerPanel;

import card.*;
import player.Player;
import utils.ImageLoader;

import javax.swing.*;

public class PlayerPanel extends JPanel {
    protected Player player;
    protected boolean isYourTurn;

    public PlayerPanel(Player player, boolean isYourTurn) {
        this.player = player;
        this.isYourTurn = isYourTurn;
    }

    public String getImageAddress(Card card, boolean isLeftOrDown, boolean isYou, boolean isVertical) {
        if (card.isHide() && !isYou) {
            if (isVertical) {
                if (isLeftOrDown) return ImageLoader.getLeftCard();
                else return ImageLoader.getRightCard();
            } else {
                return ImageLoader.getUpCard();
            }
        } else {
            if (card instanceof Ambassador) {
                if (isVertical) {
                    if (isLeftOrDown) return ImageLoader.getAmbassadorLeft();
                    else return ImageLoader.getAmbassadorRight();
                } else {
                    if (isLeftOrDown) return ImageLoader.getAmbassador();
                    else return ImageLoader.getAmbassadorUp();
                }
            } else if (card instanceof Assassin) {
                if (isVertical) {
                    if (isLeftOrDown) return ImageLoader.getAssassinLeft();
                    else return ImageLoader.getAssassinRight();
                } else {
                    if (isLeftOrDown) return ImageLoader.getAssassin();
                    else return ImageLoader.getAssassinUp();
                }
            } else if (card instanceof Commander) {
                if (isVertical) {
                    if (isLeftOrDown) return ImageLoader.getCommanderLeft();
                    else return ImageLoader.getCommanderRight();
                } else {
                    if (isLeftOrDown) return ImageLoader.getCommander();
                    else return ImageLoader.getCommanderUp();
                }
            } else if (card instanceof Duke) {
                if (isVertical) {
                    if (isLeftOrDown) return ImageLoader.getDukeLeft();
                    else return ImageLoader.getDukeRight();
                } else {
                    if (isLeftOrDown) return ImageLoader.getDuke();
                    else return ImageLoader.getDukeUp();
                }
            } else {
                if (isVertical) {
                    if (isLeftOrDown) return ImageLoader.getPrincesLeft();
                    else return ImageLoader.getPrincesRight();
                } else {
                    if (isLeftOrDown) return ImageLoader.getPrincess();
                    else return ImageLoader.getPrincesUp();
                }
            }
        }
    }
}
