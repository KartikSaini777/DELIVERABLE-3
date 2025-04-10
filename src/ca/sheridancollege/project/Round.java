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
 * Represents a single round of play between two players in the War card game.
 */
public class Round {

    protected Player player1;
    protected Player player2;

    public Round(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Plays one round: each player plays a card, the cards are compared,
     * and the winner collects both. If it's a tie, War is triggered.
     */
    public void playRound(Scanner input) {
        LinkedList<Card> pile = new LinkedList<>();

        System.out.println("\n--- Round Start ---\n");

        System.out.print("Player 1, press Enter to play your card...");
        input.nextLine();
        Card c1 = player1.playCard();
        System.out.println("Player 1 plays: " + c1);
        pile.add(c1);

        System.out.print("\nPlayer 2, press Enter to play your card...");
        input.nextLine();
        Card c2 = player2.playCard();
        System.out.println("Player 2 plays: " + c2);
        pile.add(c2);

        int result = c1.compareTo(c2);

        if (result > 0) {
            System.out.println("\nPlayer 1 wins the round!");
            player1.collectCards(pile);
        } else if (result < 0) {
            System.out.println("\nPlayer 2 wins the round!");
            player2.collectCards(pile);
        } else {
            System.out.println("\nIt's a tie! WAR begins!");
            new War(player1, player2, pile, input).playWar();
        }

        System.out.println("\nPlayer 1 has " + player1.getCardCount() + " cards. Player 2 has " + player2.getCardCount() + " cards.");
        System.out.print("\nPress Enter to continue to the next round...");
        input.nextLine();
    }

    /**
     * Compares number of cards between two players.
     */
    public int compareCards() {
        return Integer.compare(player1.getCardCount(), player2.getCardCount());
    }

    /**
     * Entry point to run the War card game.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Game game = new Game("War") {
            @Override
            public void play() {
                Player p1 = new Player("Player 1") {
                    @Override public void play() {} 
                };
                Player p2 = new Player("Player 2") {
                    @Override public void play() {} 
                };

                players.add(p1);
                players.add(p2);

                System.out.println("Welcome to the War Card Game!\n");
                System.out.println("Shuffling the deck...");
                System.out.println("Dealing 26 cards to each player...\n");
                System.out.println("Player 1 and Player 2 are ready to battle!");
                System.out.println("First to collect all 52 cards wins the game.\n");
                System.out.print("Press Enter to start the first round...");
                input.nextLine();

                Deck deck = new Deck();
                deck.dealCards(p1, p2);

                while (p1.hasCards() && p2.hasCards()) {
                    new Round(p1, p2).playRound(input);
                }

                declareWinner();
            }

            @Override
            public void declareWinner() {
                Player p1 = players.get(0);
                Player p2 = players.get(1);

                System.out.println("\n=== GAME OVER ===");
                if (p1.getCardCount() == 52) {
                    System.out.println(p1.getName() + " wins the game!");
                } else if (p2.getCardCount() == 52) {
                    System.out.println(p2.getName() + " wins the game!");
                } else {
                    System.out.println("Game ends in a draw.");
                }
            }
        };

        game.play();
        input.close();
    }
}
