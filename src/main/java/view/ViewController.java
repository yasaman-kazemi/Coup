package view;

import card.*;
import game.GameServices;
import player.*;
import utils.ImageLoader;
import view.panels.gamePanel.GamePanel;
import view.panels.start.SelectPlayerPanel;

public class ViewController {
    private GameServices gameServices;
    private MyFrame frame;

    public ViewController(GameServices gameServices) {
        this.gameServices = gameServices;
    }

    public void start() {
        this.frame = new MyFrame(new SelectPlayerPanel(this));
    }

    public void startGame(Player[] players) {
        gameServices.selectPlayers(players);
        gameServices.start();
        frame.remove(frame.getMainPanel());
        frame.setMainPanel(new GamePanel(this));
        frame.setMyLayout();
        frame.setVisible(true);
    }

    public Player[] getPlayers() {
        return gameServices.getPlayers();
    }
}
