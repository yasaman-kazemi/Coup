package game.strategy.attackStrategy;

import game.Desk;
import game.strategy.Strategy;
import player.Player;

public class Earn extends Strategy {
    private Player player;
    private Desk desk;

    public Earn(Player player, Desk desk) {
        this.player = player;
        this.desk = desk;
    }

    @Override
    public void play() {
        desk.giveCoin(player, 1);
    }

    @Override
    public String getName() {
        return "Earn";
    }

    public Player getPlayer() {
        return player;
    }

    public Desk getDesk() {
        return desk;
    }
}
