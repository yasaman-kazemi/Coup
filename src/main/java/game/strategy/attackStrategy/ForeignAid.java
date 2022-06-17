package game.strategy.attackStrategy;

import game.Desk;
import game.strategy.Strategy;
import player.Player;

public class ForeignAid extends Strategy {
    private Player player;
    private Desk desk;

    public ForeignAid(Player player, Desk desk) {
        this.player = player;
        this.desk = desk;
    }

    @Override
    public void play() {
        desk.giveCoin(player, 2);
    }

    @Override
    public String getName() {
        return "Foreign aid";
    }

    public Player getPlayer() {
        return player;
    }

    public Desk getDesk() {
        return desk;
    }
}
