package crackingcode.design;

public class SampleGame {
    public static void main(String[] args){
        Card c = new Card();
        c.setCardSuite(Card.CardSuite.CLUBS);
        c.setNumber(10);

        Card king = new Card();
        c.setCardSuite(Card.CardSuite.DIAMOND);
        c.setNumber(Card.FaceCard.KING);

        assert(king.getNumber() == 10);

    }
}
