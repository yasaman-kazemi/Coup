package game;

import card.Card;
import player.Player;

public class GameServices {
    private Game game;

    public GameServices(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void selectPlayers(Player[] players) {
        game.setPlayers(players);
    }

    public void coupAgainst(Player beCouped) {

    }

    public void start() {
        game.start();
    }

    public void coupAgainst(Player beCouped, Card card) {
        beCouped.kill(card);
    }

    public void kill(Player killed) {

    }

    public void kill(Player killed, Card card) {
        killed.kill(card);
    }

    public void removeCard(Player player, int numberOfCards) {

    }

    public void challenge(Player player, Card card) {
        Challenge challenge = new Challenge(player, card);
    }
}
