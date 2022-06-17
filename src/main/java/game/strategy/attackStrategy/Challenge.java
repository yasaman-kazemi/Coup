package game.strategy.attackStrategy;

import card.Card;
import game.Desk;
import player.Player;

public class Challenge {
    private Player challenger;
    private Player challenged;
    private String cardName;
    private Desk desk;

    public Challenge(Player challenger, Player challenged, String cardName, Desk desk) {
        this.challenger = challenger;
        this.challenged = challenged;
        this.cardName = cardName;
        this.desk = desk;
    }

    public int play() {
        Card card = challenged.getCard(cardName);
        if (card == null || !card.isHide()) {
            challenged.kill();
            return -1;
        } else {
            Card randomCard = desk.getRandomCard();
            challenged.getCards().add(randomCard);
            challenged.getCards().remove(card);
            desk.giveCard(card);
            challenger.kill();
            return 1;
        }
    }

    public String getName() {
        return "Challenge";
    }

    public Player getChallenged() {
        return challenged;
    }

    public String getCardName() {
        return cardName;
    }

    public Player getChallenger() {
        return challenger;
    }

    public Desk getDesk() {
        return desk;
    }
}
