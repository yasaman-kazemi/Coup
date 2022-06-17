package game.strategy.attackStrategy;

import game.strategy.Strategy;
import player.Player;

public class CommanderStrategy extends Strategy {
    private Player commander;
    private Player robbed;

    public CommanderStrategy(Player commander, Player robbed) {
        this.commander = commander;
        this.robbed = robbed;
    }

    @Override
    public void play() {
        commander.increaseCoin(2);
        robbed.decreaseCoin(2);
    }

    @Override
    public String getName() {
        return "Commander";
    }

    public Player getCommander() {
        return commander;
    }

    public Player getRobbed() {
        return robbed;
    }
}
