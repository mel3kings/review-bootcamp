package crackingcode.design;

public class Card {


    private CardSuite cardSuite;
    private int number;

    public void setCardSuite(CardSuite cardSuite) {
        this.cardSuite = cardSuite;
    }

    public CardSuite getCardSuite() {
        return cardSuite;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumber(FaceCard faceCard){
        this.number = faceCard.getNumber();
    }

    public int getNumber() {
        return number;
    }

    public enum FaceCard {
        KING(10), QUEEN(10);
        int number;

        FaceCard(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    public enum CardSuite {
        SPADE, HEART, DIAMOND, CLUBS
    }

}
