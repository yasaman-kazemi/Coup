package game.strategy;

import game.Desk;
import game.GameServices;
import player.Player;

public class AssassinStrategy extends Strategy{
    private Player assassin;
    private Player killed;
    private Desk desk;
    private GameServices gameServices;

    public AssassinStrategy(Player assassin, Player killed, Desk desk, GameServices gameServices) {
        this.assassin = assassin;
        this.killed = killed;
        this.desk = desk;
        this.gameServices = gameServices;
    }

    @Override
    public void play() {
        desk.receiveCoin(assassin, 3);
        gameServices.kill(killed);
    }
}
