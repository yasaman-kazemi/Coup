package game;

import card.*;
import player.Player;

import java.util.Collections;
import java.util.Stack;

public class Desk {
    private int coin;
    private Stack<Card> cards;

    public Desk() {
        reset();
    }

    private void reset() {
        this.coin = 50;
        this.cards = new Stack<>();
        for (int i = 0; i < 3; i++) {
            this.cards.push(new Duke());
            this.cards.push(new Assassin());
            this.cards.push(new Commander());
            this.cards.push(new Princess());
            this.cards.push(new Ambassador());
        }
    }

    public void distributePieces(Player[] players) {
        Collections.shuffle(this.cards);
        for (Player player : players) {
            giveCoin(player, 2);
            player.getCards().add(this.cards.pop());
            player.getCards().add(this.cards.pop());
        }
    }

    public void giveCoin(Player player, int coin) {
        if (this.coin >= coin) {
            this.coin -= coin;
            player.increaseCoin(coin);
        }
    }

    public void receiveCoin(Player player, int coin) {
        if (player.getCoin() >= coin) {
            player.decreaseCoin(coin);
            this.coin += coin;
        }
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

    public Card getRandomCard() {
        Collections.shuffle(cards);
        return cards.pop();
    }
}
