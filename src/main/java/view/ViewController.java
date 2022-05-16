package view;

import game.GameServices;
import view.panels.start.SelectPlayerPanel;

public class ViewController {
    private GameServices gameServices;
    private MyFrame frame;

    public ViewController(GameServices gameServices) {
        this.gameServices = gameServices;
    }

    public void start() {
        this.frame = new MyFrame(new SelectPlayerPanel());
    }
}
