package game.strategy;

import game.Desk;
import player.Player;

public class CommanderStrategy extends Strategy{
    private Player commander;
    private Desk desk;
    private Player robbed;

    public CommanderStrategy(Player commander, Desk desk, Player robbed) {
        this.commander = commander;
        this.desk = desk;
        this.robbed = robbed;
    }

    @Override
    public void play() {
        commander.increaseCoin(2);
        robbed.decreaseCoin(2);
    }
}
