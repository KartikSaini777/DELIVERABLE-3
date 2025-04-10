package ca.sheridancollege.project;

import java.util.LinkedList;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Kartik Saini Student ID:991763064
 * Jaskaran Singh Student ID:991790247
 * Shazaib Hassan Student ID:991739526
 * Date: 20 March, 2025
 * 
 * A class that models each Player in the game. Players have a name and a hand of cards.
 */
public abstract class Player {

    private String name; // unique player name
    protected LinkedList<Card> hand = new LinkedList<>();

    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return true if the player has cards
     */
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    /**
     * @return the number of cards the player currently has
     */
    public int getCardCount() {
        return hand.size();
    }

    /**
     * Adds multiple cards to the player's hand
     * @param cards cards to be collected
     */
    public void collectCards(LinkedList<Card> cards) {
        hand.addAll(cards);
    }

    /**
     * Adds a single card to the bottom of the hand
     */
    public void collectCard(Card card) {
        if (card != null) hand.addLast(card);
    }

    /**
     * Removes and returns the top card from the hand
     * @return the top card
     */
    public Card playCard() {
        return hand.pollFirst();
    }

    /**
     * To be implemented in child class — logic for how the player takes a turn
     */
    public abstract void play();
}
