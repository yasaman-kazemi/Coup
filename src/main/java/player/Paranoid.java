package player;

import game.GameServices;
import game.strategy.Strategy;
import game.strategy.attackStrategy.AssassinStrategy;
import game.strategy.attackStrategy.Coup;
import game.strategy.attackStrategy.Earn;

public class Paranoid extends Player {
    public Paranoid(GameServices gameServices) {
        super(gameServices);
    }

    @Override
    public void play() {
        if (coin < 7) {
            gameServices.playStrategy(this, new Earn(this, gameServices.getDesk()));
        } else {
            gameServices.playStrategy(this, new Coup(this, gameServices.getRandomAlivePlayer(this), gameServices));
        }
    }

    public void challenge(Player player, Strategy strategy) {
        gameServices.challenge(this, player, strategy);
    }

    @Override
    public String getName() {
        return "Paranoid";
    }
}
