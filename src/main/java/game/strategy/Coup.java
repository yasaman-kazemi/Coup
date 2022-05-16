package game.strategy;

import game.Desk;
import game.GameServices;
import player.Player;

public class Coup extends Strategy{
    private Player couper;
    private Player beCouped;
    private Desk desk;
    private GameServices gameServices;

    public Coup(Player couper, Player beCouped, Desk desk, GameServices gameServices) {
        this.couper = couper;
        this.beCouped = beCouped;
        this.desk = desk;
        this.gameServices = gameServices;
    }

    @Override
    public void play() {
        desk.receiveCoin(couper, 7);
        gameServices.coupAgainst(beCouped);
    }
}
