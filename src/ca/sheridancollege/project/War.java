package ca.sheridancollege.project;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Kartik Saini Student ID:991763064
 * Jaskaran Singh Student ID:991790247
 * Shazaib Hassan Student ID:991739526
 * Date: 20 March, 2025
 *
 * A special round triggered when two players tie. War continues recursively until one wins.
 */
public class War extends Round {

    private LinkedList<Card> warPile;
    private Scanner input;

    public War(Player player1, Player player2, LinkedList<Card> existingPile, Scanner input) {
        super(player1, player2);
        this.warPile = existingPile;
        this.input = input;
    }

    /**
     * Handles the War sequence: 3 face-down cards and 1 face-up card,
     * compare, and resolve. Recursively continues if another tie occurs.
     */
    public void playWar() {
        System.out.println("\nEach player places 3 cards face-down...");

        for (int i = 1; i <= 3; i++) {
            if (player1.hasCards()) {
                System.out.print("Player 1, press Enter to place face-down card #" + i + "...");
                input.nextLine();
                warPile.add(player1.playCard());
                System.out.println("Player 1 placed face-down card.");
            }
            if (player2.hasCards()) {
                System.out.print("Player 2, press Enter to place face-down card #" + i + "...");
                input.nextLine();
                warPile.add(player2.playCard());
                System.out.println("Player 2 placed face-down card.");
            }
        }

        System.out.println("\nNow each player will play their face-up War card.");

        System.out.print("Player 1, press Enter to play your War card...");
        input.nextLine();
        Card c1 = player1.playCard();
        if (c1 != null) {
            warPile.add(c1);
            System.out.println("Player 1 plays WAR card: " + c1);
        }

        System.out.print("Player 2, press Enter to play your War card...");
        input.nextLine();
        Card c2 = player2.playCard();
        if (c2 != null) {
            warPile.add(c2);
            System.out.println("Player 2 plays WAR card: " + c2);
        }

        if (c1 == null || c2 == null) return;

        int result = c1.compareTo(c2);

        if (result > 0) {
            System.out.println("\nPlayer 1 wins the war and takes all " + warPile.size() + " cards!");
            player1.collectCards(warPile);
        } else if (result < 0) {
            System.out.println("\nPlayer 2 wins the war and takes all " + warPile.size() + " cards!");
            player2.collectCards(warPile);
        } else {
            System.out.println("\nAnother tie in War! Going to War again...");
            playWar(); // Recursive call
        }
    }

    /**
     * Separate method for handling tie reuse (optional if triggered elsewhere).
     */
    public void handleTie() {
        playWar();
    }
}
