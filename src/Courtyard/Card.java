package Courtyard;
/**
 * The class card for the integrated blackjack game.
 * 
 * @author Kevin Rapa
 */
import Super.Item;

public class Card extends Item {
    private final int VALUE; // The card's face value;
    //=========================================================================
    /**
     * Constructs a card.
     * The card's type is used in removing them all from your inventory
     * between games.
     * @param name The name of the card.
     */
    public Card(String name) {
        super(name);
        this.description = "It's a ghostly playing card that feels cold and eerily solid.";
        this.type = "card";
        this.VALUE = this.determineValue(name.substring(0,2));
    }
    //=========================================================================
    /**
     * Determines the value of each card.
     * For aces, the value is one, however if the value 11 is advantageous
     * during a game, that value is used instead.
     * Face cards are worth 10, all numbered ranks use their own value.
     * @param name The first two letters of a card's name.
     * @return The card's value.
     */
    private int determineValue(String name) {
        int value = 0;
        int[] vals = {1,2,3,4,5,6,7,8,9,10};
        String[] ranks = {"ac","tw","th","fo","fi","si","se","ei","ni","te"};
        
        if (name.matches("ja|qu|ki")) // It's a face card.
            value = 10;
        else
            for (int i = 0; i < 10; i++) {
                if (ranks[i].matches(name))
                    value = vals[i];       
            }
        return value;
    }
    //=========================================================================
    /**
     * @return This card's value.
     */
    public int getVal() {
        return this.VALUE;
    }
    //=========================================================================
    /**
     * @return The name of this card.
     */
    public String getName() {
        return this.NAME;
    }
    //=========================================================================
}
