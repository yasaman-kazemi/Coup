package player;

import card.Card;

import java.util.ArrayList;

public class Player {
    protected int coin;
    protected ArrayList<Card> cards;

    public Player() {
        this.cards = new ArrayList<>();
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void increaseCoin(int coin) {
        this.coin += coin;
    }

    public void decreaseCoin(int coin) {
        this.coin -= coin;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean isDead() {
        for (Card card : cards)
            if (card.isHide())
                return true;
        return false;
    }

    public void kill(Card card) {
        card.setHide(false);
    }
}
