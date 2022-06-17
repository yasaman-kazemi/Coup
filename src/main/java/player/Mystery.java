package player;

import game.GameServices;
import game.strategy.attackStrategy.AssassinStrategy;
import game.strategy.attackStrategy.DukeStrategy;

public class Mystery extends Player {
    public Mystery(GameServices gameServices) {
        super(gameServices);
    }

    @Override
    public void play() {
        if (coin < 3) {
            gameServices.playStrategy(this, new DukeStrategy(this, gameServices.getDesk()));
        } else {
            gameServices.playStrategy(this, new AssassinStrategy(this, gameServices.getRandomAlivePlayer(this), gameServices));
        }
    }

    @Override
    public String getName() {
        return "Mystery";
    }
}
