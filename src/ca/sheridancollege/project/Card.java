package ca.sheridancollege.project;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Kartik Saini Student ID:991763064
 * Jaskaran Singh Student ID:991790247
 * Shazaib Hassan Student ID:991739526
 * Date: 20 March, 2025
 * 
 * A class to be used as the base Card class for the project.
 */
public abstract class Card {

    private int rank; // 2–14 (where 11=J, 12=Q, 13=K, 14=A)
    private String suit; // Hearts, Diamonds, Clubs, Spades

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    /**
     * Compares two cards by rank
     * @param other the card to compare with
     * @return positive if this is higher, negative if lower, 0 if tie
     */
    public int compareTo(Card other) {
        return Integer.compare(this.rank, other.rank);
    }

    /**
     * @return String representation of the card (e.g., "10 of Hearts")
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
