package game.strategy.attackStrategy;

import card.Card;
import game.GameServices;
import player.Player;

public class Challenge {
    private Player challenger;
    private Player challenged;
    private String cardName;
    private GameServices gameServices;

    public Challenge(Player challenger, Player challenged, String cardName, GameServices gameServices) {
        this.challenger = challenger;
        this.challenged = challenged;
        this.cardName = cardName;
        this.gameServices = gameServices;
    }

    public int play() {
        Card card = challenged.getCard(cardName);
        if (card == null || !card.isHide()) {
            gameServices.kill(challenged);
            return -1;
        } else {
            gameServices.change1CardRandomly(challenged, card);
            gameServices.kill(challenger);
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
}
