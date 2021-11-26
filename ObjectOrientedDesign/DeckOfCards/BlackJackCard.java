package ObjectOrientedDesign.DeckOfCards;

public class BlackJackCard extends Card {

    public BlackJackCard(int faceValue , Suit suit) {
        super(faceValue, suit);
    }

    public int getFaceValue(int faceValue) {
        if (isAce(faceValue))
            return 1;
        else if (faceValue >= 11 && faceValue <= 13) return 10;
        else return faceValue;
    }

    public int minValue(int faceValue) {
        if (isAce(faceValue)) return 1;
        else return getFaceValue();
    }

    public int maxValue(int faceValue) {
        if (isAce(faceValue)) return 11;
        else return getFaceValue(faceValue);
    }

    public boolean isAce(int faceValue) {
        return faceValue == 1;
     }

    public boolean isFaceCard(int faceValue) {
        return faceValue >= 11 && faceValue <= 13;
    }

}
