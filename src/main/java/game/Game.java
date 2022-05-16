package game;

import game.strategy.Strategy;
import player.Player;

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

    public void setPlayers(Player player1, Player player2, Player player3) {
        this.players[0] = new Player();
        this.players[1] = player1;
        this.players[2] = player2;
        this.players[3] = player3;
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
    }
}
