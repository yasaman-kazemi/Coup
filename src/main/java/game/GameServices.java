package game;

import card.Card;
import game.strategy.Strategy;
import game.strategy.attackStrategy.AssassinStrategy;
import game.strategy.attackStrategy.Challenge;
import game.strategy.attackStrategy.CommanderStrategy;
import player.CautiousKiller;
import player.Paranoid;
import player.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

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
        Player[] finalPlayers = new Player[4];
        finalPlayers[0] = new Player(this);
        System.arraycopy(players, 0, finalPlayers, 1, 3);
        game.setPlayers(finalPlayers);
    }

    public void start() {
        game.start();
    }

    public void coupAgainst(Player beCouped) {
        beCouped.kill();
    }

    public void kill(Player killed) {
        killed.kill();
    }

    public int challenge(Player challenger, Player challenged, Strategy strategy) {
        if (challenger.isDead()) return 0;
        String cardName = strategy.getName();
        if (challenger.equals(challenged) || cardName.equals("Change cards") || cardName.equals("Coup") ||
                cardName.equals("Earn") || cardName.equals("Foreign aid")) return 0;
        int response = 0;
        if (challenger.equals(getPlayers()[0])) {
            String msg = "will you challenge " + challenged.getName() + " for " + cardName;
            if (strategy instanceof AssassinStrategy) {
                String opponentName = ((AssassinStrategy) strategy).getKilled().getName();
                msg = msg + " against " + opponentName;
            } else if (strategy instanceof CommanderStrategy) {
                String opponentName = ((CommanderStrategy) strategy).getRobbed().getName();
                msg = msg + " against " + opponentName;
            }
            response = JOptionPane.showConfirmDialog(null,
                    msg, "Challenging",
                    JOptionPane.YES_NO_OPTION);
        }
        if (response == 0) {
            Challenge challenge = new Challenge(challenger, challenged, cardName, getDesk());
            return challenge.play();
        }
        return 0;
    }

    public void playStrategy(Player player, Strategy strategy) {
        int response = challenge(getPlayers()[0], player, strategy);
        if (response == 0) {
            strategy.play();
            if (game.getRound() % 2 == 1) {
                Paranoid paranoid = (Paranoid) game.getPlayer("Paranoid");
                if (paranoid != null && !paranoid.isDead()) {
                    paranoid.challenge(player, strategy);
                }
            }
        } else if (response == 1) {
            strategy.play();
        }
    }


    public Player[] getPlayers() {
        return game.getPlayers();
    }

    public Desk getDesk() {
        return game.getDesk();
    }

    public int getTurn() {
        return game.getTurn();
    }

    public void changeTurn() {
        game.changeTurn();
    }

    public void selectCards(Card[] cards, int[] selectedIndexes) {
        selectCards(getPlayers()[0], cards, selectedIndexes);
    }

    public void selectCards(Player player, Card[] cards, int[] selectedIndexes) {
        ArrayList<Card> playerCards = new ArrayList<>();
        for (int index : selectedIndexes) {
            playerCards.add(cards[index]);
            cards[index] = null;
        }
        if (playerCards.size() < 2) {
            for (int i = 0; i < 4; i++) {
                Card card = cards[i];
                if (card != null && !card.isHide()) {
                    playerCards.add(card);
                    cards[i] = null;
                    break;
                }
            }
        }
        player.setCards(playerCards);
        for (Card card : cards)
            if (card != null)
                getDesk().giveCard(card);
    }

    public String[] getAlivePlayers() {
        String[] alivePlayers = new String[4];
        Player[] players = getPlayers();
        if (players[0].isDead()) alivePlayers[0] = "*";
        else alivePlayers[0] = "down";
        if (players[1].isDead()) alivePlayers[1] = "*";
        else alivePlayers[1] = "right";
        if (players[2].isDead()) alivePlayers[2] = "*";
        else alivePlayers[2] = "up";
        if (players[3].isDead()) alivePlayers[3] = "*";
        else alivePlayers[3] = "left";
        return alivePlayers;
    }

    public Player getPlayer(String side) {
        switch (side) {
            case "down":
                return getPlayers()[0];
            case "right":
                return getPlayers()[1];
            case "up":
                return getPlayers()[2];
            default:
                return getPlayers()[3];
        }
    }

    public void selectCards(CautiousKiller cautiousKiller) {
        ArrayList<Card> cards = cautiousKiller.getCards();
        if (cards.size() > 2) {
            ArrayList<Card> chosenCards = new ArrayList<>();
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                if (!card.isHide()) {
                    chosenCards.add(card);
                    cards.remove(i);
                    i--;
                }
            }
            if (chosenCards.size() == 2) {
                separateCards(cautiousKiller, cards, chosenCards);
                return;
            }
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                if (card.getName().equals("Assassin")) {
                    chosenCards.add(card);
                    cards.remove(i);
                    if (chosenCards.size() == 2) {
                        separateCards(cautiousKiller, cards, chosenCards);
                        return;
                    }
                    i--;
                }
            }
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                if (card.getName().equals("Ambassador")) {
                    chosenCards.add(card);
                    cards.remove(i);
                    if (chosenCards.size() == 2) {
                        separateCards(cautiousKiller, cards, chosenCards);
                        return;
                    }
                    i--;
                }
            }
            while (chosenCards.size() < 2) {
                chosenCards.add(cards.get(0));
                cards.remove(0);
            }
            separateCards(cautiousKiller, cards, chosenCards);
        }
    }

    private void separateCards(CautiousKiller cautiousKiller, ArrayList<Card> cards, ArrayList<Card> chosenCards) {
        for (Card card : cards) {
            getDesk().giveCard(card);
        }
        cautiousKiller.setCards(chosenCards);
    }

    public ArrayList<String> getFilteredAlivePlayers() {
        ArrayList<String> filteredAlivePlayers = new ArrayList<>();
        for (String alivePlayer : getAlivePlayers())
            if (!alivePlayer.equals("*"))
                filteredAlivePlayers.add(alivePlayer);
        return filteredAlivePlayers;
    }

    public Player getRandomAlivePlayer(Player player) {
        ArrayList<String> filteredAlivePlayers = getFilteredAlivePlayers();
        String side = filteredAlivePlayers.get(new Random().nextInt(filteredAlivePlayers.size()));
        Player result = getPlayer(side);
        if (result.equals(player)) {
            result = getRandomAlivePlayer(player);
        }
        return result;
    }
}
