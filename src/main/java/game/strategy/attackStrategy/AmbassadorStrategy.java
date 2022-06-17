package game.strategy.attackStrategy;

import card.Card;
import game.Desk;
import player.Player;

public class AmbassadorStrategy extends Strategy {
    private Player player;
    private Desk desk;

    public AmbassadorStrategy(Player player, Desk desk) {
        this.player = player;
        this.desk = desk;
    }

    @Override
    public void play() {
        Card card1 = desk.getRandomCard();
        Card card2 = desk.getRandomCard();
        player.getCards().add(card1);
        player.getCards().add(card2);
    }

    @Override
    public String getName() {
        return "Ambassador strategy";
    }
}
