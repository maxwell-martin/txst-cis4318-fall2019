package beans;

import java.io.Serializable;

public class Order implements Serializable {
    private String shipping;
    private String[] cards;

    public Order() {
    }

    public Order(String shipping, String[] cards) {
        this.shipping = shipping;
        this.cards = cards;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }
}
