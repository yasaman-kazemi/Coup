package game.strategy;

import card.Card;
import game.Desk;
import game.GameServices;
import player.Player;

public class ChangeCardStrategy extends Strategy{
    private Player player;
    private Desk desk;
    private GameServices gameServices;

    public ChangeCardStrategy(Player player, Desk desk, GameServices gameServices) {
        this.player = player;
        this.desk = desk;
        this.gameServices = gameServices;
    }

    @Override
    public void play() {
        desk.receiveCoin(player, 1);
        Card card = desk.getRandomCard();
        player.getCards().add(card);
        //todo change card
        gameServices.removeCard(player, 1);
    }
}
