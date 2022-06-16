package player;

import game.GameServices;

public class Paranoid extends Player {
    public Paranoid(GameServices gameServices) {
        super(gameServices);
    }

    @Override
    public String getName() {
        return "Paranoid";
    }
}
