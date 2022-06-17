package player;

import game.GameServices;
import game.strategy.attackStrategy.Coup;
import game.strategy.attackStrategy.DukeStrategy;

public class Couper extends Player {
    public Couper(GameServices gameServices) {
        super(gameServices);
    }

    @Override
    public void play() {
        if (coin < 7) {
            gameServices.playStrategy(this, new DukeStrategy(this, gameServices.getDesk()));
        } else {
            gameServices.playStrategy(this, new Coup(this, gameServices.getRandomAlivePlayer(this), gameServices));
        }
    }

    @Override
    public String getName() {
        return "Couper";
    }
}
