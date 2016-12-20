package Courtyard;
/**
 * The class card for the integrated blackjack game.
 * 
 * @author Kevin Rapa
 */
import java.util.HashMap;
import Super.Item;

public class Card extends Item {
    private final int VALUE; // The card's face value;
    private final static HashMap<String, Integer> MAP = new HashMap() {{
        // Static mapping for card values.
        put("Ac", 1);   put("Tw", 2);   put("Th", 3);  put("Fo", 4);  
        put("Fi", 5);   put("Si", 6);   put("Se", 7);  put("Ei", 8);  
        put("Ni", 9);   put("Te", 10);  put("Ja", 10); put("Qu", 10);
        put("Ki", 10); 
    }};
    //=========================================================================
    /**
     * Constructs a card.
     * The card's type is used in removing them all from your inventory
     * between games.
     * @param name The name of the card.
     */
    public Card(String name) {
        super(name);
        this.description = "A ghostly and eerily solid playing card. It feels cool to the touch.";
        this.VALUE = this.determineValue(name.substring(0,2));
    }
    //=========================================================================
    /**
     * Determines the value of each card using the hash map.
     * For aces, the value is one, however if the value 11 is advantageous
     * during a game, that value is used instead. Face cards are worth 10,
     * all numbered ranks use their own value.
     * @param name The first two letters of a card's name.
     * @return The card's value.
     */
    private int determineValue(String name) {
        return MAP.get(name);
    }
    //=========================================================================
    /**
     * @return This card's value.
     */
    public int getVal() {
        return this.VALUE;
    }
    //=========================================================================
}
