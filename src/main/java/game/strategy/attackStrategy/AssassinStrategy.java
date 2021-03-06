package game.strategy.attackStrategy;

import game.GameServices;
import game.strategy.Strategy;
import player.Player;

public class AssassinStrategy extends Strategy {
    private Player assassin;
    private Player killed;
    private GameServices gameServices;

    public AssassinStrategy(Player assassin, Player killed, GameServices gameServices) {
        this.assassin = assassin;
        this.killed = killed;
        this.gameServices = gameServices;
    }

    @Override
    public void play() {
        gameServices.getDesk().receiveCoin(assassin, 3);
        gameServices.kill(killed);
    }

    @Override
    public String getName() {
        return "Assassin";
    }

    public Player getAssassin() {
        return assassin;
    }

    public Player getKilled() {
        return killed;
    }

    public GameServices getGameServices() {
        return gameServices;
    }
}
