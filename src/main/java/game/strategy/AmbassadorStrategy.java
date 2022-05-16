package game.strategy;

import card.Card;
import game.Desk;
import game.GameServices;
import player.Player;

public class AmbassadorStrategy extends Strategy {
    private Desk desk;
    private Player player;
    private GameServices gameServices;

    public AmbassadorStrategy(Desk desk, Player player, GameServices gameServices) {
        this.desk = desk;
        this.player = player;
        this.gameServices = gameServices;
    }

    @Override
    public void play() {
        Card card1 = desk.getRandomCard();
        Card card2 = desk.getRandomCard();
        player.getCards().add(card1);
        player.getCards().add(card2);
        gameServices.removeCard(player, 2);
    }
}
