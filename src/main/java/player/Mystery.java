package player;

import game.GameServices;

public class Mystery extends Player {
    public Mystery(GameServices gameServices) {
        super(gameServices);
    }

    @Override
    public String getName() {
        return "Mystery";
    }
}
