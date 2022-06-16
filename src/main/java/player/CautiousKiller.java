package player;

import card.Card;
import game.GameServices;
import game.strategy.attackStrategy.AmbassadorStrategy;
import game.strategy.attackStrategy.AssassinStrategy;
import game.strategy.attackStrategy.ChangeCardStrategy;
import game.strategy.attackStrategy.ForeignAid;

import java.util.ArrayList;
import java.util.Random;

public class CautiousKiller extends Player {
    public CautiousKiller(GameServices gameServices) {
        super(gameServices);
    }

    @Override
    public void play() {
        Card assassinCard = getCard("Assassin");
        if (assassinCard != null && assassinCard.isHide()) {
            if (coin > 2) {
                String[] alivePlayers = gameServices.getAlivePlayers();
                ArrayList<String> filteredAlivePlayers = getFilteredPlayers(alivePlayers);
                Player player = getRandomPlayerForShot(filteredAlivePlayers);
                new AssassinStrategy(this, player, gameServices).play();
            } else {
                new ForeignAid(this, gameServices.getDesk()).play();
            }
        } else {
            Card ambassador = getCard("Ambassador");
            if (ambassador != null && ambassador.isHide()) {
                new AmbassadorStrategy(this, gameServices.getDesk());
                gameServices.selectCards(this);
            } else {
                if (coin > 0) {
                    new ChangeCardStrategy(this, gameServices.getDesk()).play();
                    gameServices.selectCards(this);
                } else {
                    new ForeignAid(this, gameServices.getDesk()).play();
                }
            }
        }
    }

    private ArrayList<String> getFilteredPlayers(String[] alivePlayers) {
        ArrayList<String> filteredAlivePlayers = new ArrayList<>();
        for (String alivePlayer : alivePlayers)
            if (!alivePlayer.equals("*"))
                filteredAlivePlayers.add(alivePlayer);
        return filteredAlivePlayers;
    }

    private Player getRandomPlayerForShot(ArrayList<String> filteredAlivePlayers) {
        String side = filteredAlivePlayers.get(new Random().nextInt(filteredAlivePlayers.size()));
        Player player = gameServices.getPlayer(side);
        if (player.equals(this)){
            player = getRandomPlayerForShot(filteredAlivePlayers);
        }
        return player;
    }

    @Override
    public String getName() {
        return "Cautious Killer";
    }
}
