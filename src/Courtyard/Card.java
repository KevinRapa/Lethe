package Courtyard;
/**
 * The class card for the integrated blackjack game.
 * 
 * @author Kevin Rapa
 */
import A_Main.NameConstants;
import java.util.HashMap;
import A_Super.Item;

public class Card extends Item {
    private final int VALUE; // The card's face value;
    private final static HashMap<String, Integer> MAP = new HashMap<>();
    
    static {
        MAP.put("Ac", 1);   MAP.put("Tw", 2);   MAP.put("Th", 3);  
        MAP.put("Fo", 4);   MAP.put("Fi", 5);   MAP.put("Si", 6);   
        MAP.put("Se", 7);   MAP.put("Ei", 8);   MAP.put("Ni", 9);   
        MAP.put("Te", 10);  MAP.put("Ja", 10);  MAP.put("Qu", 10);
        MAP.put("Ki", 10); 
    }
    //=========================================================================
    /**
     * Constructs a card.
     * The card's type is used in removing them all from your inventory
     * between games.
     * @param name The name of the card.
     */
    public Card(String name) {
        super(name);
        this.type = NameConstants.CARD;
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
