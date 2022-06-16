package game.strategy.attackStrategy;

import player.Player;

public class CommanderStrategy extends Strategy{
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
}
