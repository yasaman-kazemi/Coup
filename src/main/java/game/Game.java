package game;

import player.Player;

import javax.swing.*;

public class Game {
    private Player[] players;
    private Desk desk;
    private int turn;
    private int round = 0;

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

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void changeTurn() {
        this.turn = (this.turn + 1) % 4;
        if (turn == 0) round++;
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

    public int getRound() {
        return round;
    }

    public Player getPlayer(String playerName) {
        for (Player player : players)
            if (player.getName().equals(playerName))
                return player;
        return null;
    }
}
