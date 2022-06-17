package game.strategy.attackStrategy;

import game.GameServices;
import game.strategy.Strategy;
import player.Player;

public class Coup extends Strategy {
    private Player couper;
    private Player beCouped;
    private GameServices gameServices;

    public Coup(Player couper, Player beCouped, GameServices gameServices) {
        this.couper = couper;
        this.beCouped = beCouped;
        this.gameServices = gameServices;
    }

    @Override
    public void play() {
        gameServices.getDesk().receiveCoin(couper, 7);
        gameServices.coupAgainst(beCouped);
    }

    @Override
    public String getName() {
        return "Coup";
    }

    public Player getCouper() {
        return couper;
    }

    public Player getBeCouped() {
        return beCouped;
    }

    public GameServices getGameServices() {
        return gameServices;
    }
}
