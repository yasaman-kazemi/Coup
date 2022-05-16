package game;

import card.Card;
import player.Player;

public class Challenge {
    private Player player;
    private Card card;

    public Challenge(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
