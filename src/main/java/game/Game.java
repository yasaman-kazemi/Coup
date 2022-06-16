package game;

import game.strategy.attackStrategy.Strategy;
import player.Player;

import javax.swing.*;

public class Game {
    private Player[] players;
    private Desk desk;
    private int turn;

    public Game() {
        players = new Player[4];
        this.desk = new Desk();
        this.turn = 0;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public void setPlayers(Player[] players) {
        this.players[0] = players[0];
        this.players[1] = players[1];
        this.players[2] = players[2];
        this.players[3] = players[3];
    }

    public void start() {
        desk.distributePieces(players);
    }

    public void play(Strategy strategy) {

    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void changeTurn() {
        this.turn = (this.turn + 1) % 4;
        Player winner = hasEnd();
        if (winner != null) {
            JOptionPane.showMessageDialog(null, "Winner: " + winner.getName());
            System.exit(0);
        }
        if (players[turn].isDead()) changeTurn();
    }

    public Player hasEnd() {
        int counter = 0;
        Player result = null;
        for (Player player : players) {
            if (player.isDead()) counter++;
            else result = player;
        }
        if (counter == 3) return result;
        else return null;
    }

    public Player[] getPlayers() {
        return players;
    }
}
