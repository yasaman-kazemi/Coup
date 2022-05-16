import game.Game;
import game.GameServices;
import view.ViewController;

public class Coup {
    public static void main(String[] args) {
        Game game = new Game();
        GameServices gameServices = new GameServices(game);
        ViewController viewController = new ViewController(gameServices);
        viewController.start();
    }
}
