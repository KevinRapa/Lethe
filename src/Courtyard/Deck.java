package Courtyard;

import java.util.Stack;
import java.util.Random;
/**
 * Represents a deck of cards.
 * @author Kevin Rapa
 */
public class Deck {
    private final Stack<Card> DECK = new Stack<>(); // The stack of cards.
    // ========================================================================
    /**
     * Constructs a deck of cards.
     */
    public Deck() {
        String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", 
                          "eight", "nine", "ten", "jack", "queen", "king"};
        String[] suits = {"hearts", "spades", "clubs", "diamonds"};
        
        for (String suit : suits) // Creates all the cards.
            for (String rank : ranks) {
                this.DECK.push(new Card(rank + " of " + suit));
            }
    }  
    // ========================================================================  
    /**
     * Shuffles the deck of cards.
     * Removes all the cards off the stack randomly into the array, then 
     * iterates through the array linearly, pushing each card back in.
     */
    public void shuffle() {
        int i = DECK.size(); // Index to remove card from DECK.
        int j = 0;  // Index to add the card in temp.
        Card[] temp = new Card[DECK.size()];
        Random generator = new Random();

        while (! this.DECK.isEmpty()) {
            int position = generator.nextInt(i);
            temp[j] = this.DECK.remove(position);
            j++;
            i--;
        }
        for (Card card : temp)
            this.DECK.push(card);
    }
    // ========================================================================  
    /**
     * Removes a card from the top of this deck.
     * @return A card object.
     */
    public Card draw() {
        return this.DECK.pop();
    }
    // ========================================================================  
}
