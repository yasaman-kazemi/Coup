package view;

import card.Card;
import game.Desk;
import game.GameServices;
import game.strategy.attackStrategy.*;
import player.Player;
import view.panels.gamePanel.GamePanel;
import view.panels.start.SelectPlayerPanel;

import javax.swing.*;
import java.util.ArrayList;

public class ViewController {
    private GameServices gameServices;
    private GamePanel gamePanel;
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
        refresh();
    }

    private void refresh() {
        frame.remove(frame.getMainPanel());
        gamePanel = new GamePanel(this);
        frame.setMainPanel(gamePanel);
        frame.setMyLayout();
        frame.setVisible(true);
    }

    private Player[] getPlayers() {
        return gameServices.getPlayers();
    }

    public Player getPlayer(int id) {
        return getPlayers()[id];
    }

    public Desk getDesk() {
        return gameServices.getDesk();
    }

    public int getDeskCoin() {
        return getDesk().getCoin();
    }

    public int getTurn() {
        return gameServices.getTurn();
    }

    public Player getTurnPlayer() {
        return getPlayer(getTurn());
    }

    public GameServices getGameService() {
        return gameServices;
    }

    public void changeTurn() {
        gameServices.changeTurn();
        refresh();
    }

    public void earn() {
        gameServices.playStrategy(new Earn(getTurnPlayer(), getDesk()));
        changeTurn();
    }

    public void foreignAid() {
        gameServices.playStrategy(new ForeignAid(getTurnPlayer(), getDesk()));
        changeTurn();
    }

    public void coup() {
        if (getTurnPlayer().getCoin() > 6) {
            String[] options = gameServices.getAlivePlayers();
            int response = JOptionPane.showOptionDialog(null,
                    "Choose the one you want to coup against", "select player for coup",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (response == 0) {
                wrongChoice();
                coup();
            } else coup(options, response);
        } else {
            JOptionPane.showMessageDialog(null,
                    "You don't have enough coin to coup against anyone", "Not enough coin",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void coup(String[] options, int chosenPlayerId) {
        if (options[chosenPlayerId].equals("*")) {
            wrongChoice();
            coup();
        } else {
            gameServices.playStrategy(new Coup(getTurnPlayer(), getPlayer(chosenPlayerId), getGameService()));
            changeTurn();
        }
    }

    private void wrongChoice() {
        JOptionPane.showMessageDialog(null, "choose one of alive opponents",
                "Wrong choice", JOptionPane.ERROR_MESSAGE);
    }

    public void dukeStrategy() {
        gameServices.playStrategy(new DukeStrategy(getTurnPlayer(), getDesk()));
        changeTurn();
    }

    public void assassinStrategy() {
        if (getTurnPlayer().getCoin() > 2) {
            String[] options = gameServices.getAlivePlayers();
            int playerId = JOptionPane.showOptionDialog(null,
                    "Choose the one you want to assault against", "select player to assault",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (playerId == 0) {
                wrongChoice();
                assassinStrategy();
            } else {
                gameServices.playStrategy(new AssassinStrategy(getTurnPlayer(), getPlayer(playerId), gameServices));
                changeTurn();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "You don't have enough coin to assassin anyone", "Not enough coin",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void commanderStrategy() {
        String[] options = gameServices.getAlivePlayers();
        int playerId = JOptionPane.showOptionDialog(null,
                "Choose the one you want to get 2 coin from", "select player to get 2 coin",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (playerId == 0) {
            wrongChoice();
            commanderStrategy();
        } else {
            gameServices.playStrategy(new CommanderStrategy(getTurnPlayer(), getPlayer(playerId)));
            changeTurn();
        }
    }

    public void ambassadorStrategy() {
        Player turnPlayer = getTurnPlayer();
        gameServices.playStrategy(new AmbassadorStrategy(turnPlayer, getDesk()));
        selectCards(turnPlayer);
    }

    public void changeCard() {
        Player turnPlayer = getTurnPlayer();
        if (turnPlayer.getCoin() > 0) {
            gameServices.playStrategy(new ChangeCardStrategy(turnPlayer, getDesk()));
            selectCards(turnPlayer);
        } else {
            JOptionPane.showMessageDialog(null,
                    "You don't have enough coin to change card", "Not enough coin",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selectCards(Player turnPlayer) {
        ArrayList<Card> cards = turnPlayer.getCards();
        int selectionNumber = 2;
        for (Card card : cards)
            if (!card.isHide())
                selectionNumber--;
        new CardSelectionFrame(this, cards.toArray(new Card[0]), selectionNumber);
    }

    public void selectCards(Card[] cards, int[] selectedIndexes, CardSelectionFrame cardSelectionFrame) {
        gameServices.selectCards(cards, selectedIndexes);
        changeTurn();
        if (cardSelectionFrame != null) cardSelectionFrame.dispose();
    }
}
