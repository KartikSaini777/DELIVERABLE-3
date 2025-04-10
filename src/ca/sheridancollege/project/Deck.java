package ca.sheridancollege.project;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Kartik Saini Student ID:991763064
 * Jaskaran Singh Student ID:991790247
 * Shazaib Hassan Student ID:991739526
 * Date: 20 March, 2025
 *
 * A deck of standard 52 playing cards. Inherits from GroupOfCards.
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super(52);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                // Create anonymous Card objects with rank and suit only
                cards.add(new Card(rank, suit) {});
            }
        }
        shuffle();
    }

    /**
     * Deals the cards evenly to two players.
     * @param p1 First player
     * @param p2 Second player
     */
    public void dealCards(Player p1, Player p2) {
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                p1.collectCard(cards.get(i));
            } else {
                p2.collectCard(cards.get(i));
            }
        }
    }
}
