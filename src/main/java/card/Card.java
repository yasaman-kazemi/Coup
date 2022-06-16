package card;

public abstract class Card {
    protected boolean isHide;

    public Card() {
        isHide = true;
    }

    public abstract String getName();

    public boolean isHide() {
        return isHide;
    }

    public void setHide(boolean hide) {
        isHide = hide;
    }
}
