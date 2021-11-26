package ObjectOrientedDesign.DeckOfCards;

import java.util.ArrayList;

public class Deck<T extends Card> {
    private ArrayList<T> cards; // all cards, dealt or not
    public int dealtIndex = 0; // marks first undealt card

    public void setDeckOfCards(ArrayList<T> cards) {
        //set the deck
    }

    public void shuffle() {

    }

    public int remainingCards() {
         return cards.size() - dealtIndex;
    }

    //return value should be T[]
    public void dealHands(int number) {
        // cards in hand
    }

    //return value should be T
    public void deaICard() { }
}
