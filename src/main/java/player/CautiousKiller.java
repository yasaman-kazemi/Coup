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
                Player player = gameServices.getRandomAlivePlayer(this);
                gameServices.playStrategy(new AssassinStrategy(this, player, gameServices));
            } else {
                gameServices.playStrategy(new ForeignAid(this, gameServices.getDesk()));
            }
        } else {
            Card ambassador = getCard("Ambassador");
            if (ambassador != null && ambassador.isHide()) {
                gameServices.playStrategy(new AmbassadorStrategy(this, gameServices.getDesk()));
                gameServices.selectCards(this);
            } else {
                if (coin > 0) {
                    gameServices.playStrategy(new ChangeCardStrategy(this, gameServices.getDesk()));
                    gameServices.selectCards(this);
                } else {
                    gameServices.playStrategy(new ForeignAid(this, gameServices.getDesk()));
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Cautious Killer";
    }
}
