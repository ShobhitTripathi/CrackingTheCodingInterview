package ObjectOrientedDesign.DeckOfCards;

public enum Suit {
    Invalid(-1), Club (0), Diamond (1), Heart (2), Spade(3);
    private int value;

    private Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        //define to get the Suit from value
        switch (value) {
            case 0: return Club;
            case 1: return Diamond;
            case 2: return Heart;
            case 3: return Spade;
            default:
                System.out.println("Not Proper value.");
                return Invalid;
        }
    }
}
