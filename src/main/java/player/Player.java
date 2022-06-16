package player;

import card.Card;
import game.GameServices;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Player {
    protected int coin;
    protected ArrayList<Card> cards;
    protected GameServices gameServices;

    public Player(GameServices gameServices) {
        this.cards = new ArrayList<>();
        this.gameServices = gameServices;
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
                return false;
        return true;
    }

    public void kill(Card card) {
        card.setHide(false);
    }

    public void kill() {
        if (cards.get(0).isHide() && cards.get(1).isHide()) {
            kill(cards.get(new Random().nextInt(2)));
        } else if (cards.get(0).isHide()) {
            kill(cards.get(0));
        } else {
            kill(cards.get(1));
        }
    }

    public void play() {
    }

    public Card getCard(String cardName) {
        for (Card card : cards)
            if (card.getName().equals(cardName))
                return card;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getCoin() == player.getCoin() && getCards().equals(player.getCards()) && gameServices.equals(player.gameServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoin(), getCards(), gameServices);
    }

    public String getName() {
        return "User";
    }
}
