package game.strategy.attackStrategy;

import card.Card;
import game.Desk;
import player.Player;

public class ChangeCardStrategy extends Strategy {
    private Player player;
    private Desk desk;

    public ChangeCardStrategy(Player player, Desk desk) {
        this.player = player;
        this.desk = desk;
    }

    @Override
    public void play() {
        desk.receiveCoin(player, 1);
        Card card = desk.getRandomCard();
        player.getCards().add(card);
    }

    @Override
    public String getName() {
        return "Change cards strategy";
    }
}
