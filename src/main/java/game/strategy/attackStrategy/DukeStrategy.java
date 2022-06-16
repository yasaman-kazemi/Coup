package game.strategy.attackStrategy;

import game.Desk;
import player.Player;

public class DukeStrategy extends Strategy{
    private Player player;
    private Desk desk;

    public DukeStrategy(Player player, Desk desk) {
        this.player = player;
        this.desk = desk;
    }

    @Override
    public void play() {
        desk.giveCoin(player, 3);
    }
}
