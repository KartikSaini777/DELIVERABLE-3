package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Kartik Saini Student ID:991763064
 * Jaskaran Singh Student ID:991790247
 * Shazaib Hassan Student ID:991739526
 * Date: 20 March, 2025
 *
 * The class that models your game. You should create a more specific child of this class
 * and instantiate the methods given.
 */
public abstract class Game {

    private final String name; // the title of the game
    protected ArrayList<Player> players = new ArrayList<>(); // the players of the game

    public Game(String name) {
        this.name = name;
    }

    /**
     * @return the name of the game
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();
}
