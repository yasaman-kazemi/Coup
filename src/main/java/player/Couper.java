package player;

import game.GameServices;

public class Couper extends Player{
    public Couper(GameServices gameServices) {
        super(gameServices);
    }

    @Override
    public String getName() {
        return "Couper";
    }
}
