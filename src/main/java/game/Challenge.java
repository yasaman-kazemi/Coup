package game;

import player.Player;

public class Challenge {
    private Player player;
    private String cardName;

    public Challenge(Player player, String cardName) {
        this.player = player;
        this.cardName = cardName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
