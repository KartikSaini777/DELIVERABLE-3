package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Kartik Saini Student ID:991763064
 * Jaskaran Singh Student ID:991790247
 * Shazaib Hassan Student ID:991739526
 * Date: 20 March, 2025
 *
 * A concrete class that represents any grouping of cards for a Game.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 */
public class GroupOfCards {

    protected int size; // max size for the group
    protected ArrayList<Card> cards = new ArrayList<>(); // cards in the group

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * Shuffles the group of cards randomly.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the new size limit of the group
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the list of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
}
