package Courtyard;
/**
 * The class card for the integrated blackjack game.
 * 
 * @author Kevin Rapa
 */
import A_Main.Names;
import java.util.HashMap;
import A_Super.Item;

public class Card extends Item {
    private final int VALUE; // The card's face value;
    private final static HashMap<String, Integer> MAP = new HashMap<>();
    
    static {
        MAP.put("ac", 1);   MAP.put("tw", 2);   MAP.put("th", 3);  
        MAP.put("fo", 4);   MAP.put("fi", 5);   MAP.put("si", 6);   
        MAP.put("se", 7);   MAP.put("ei", 8);   MAP.put("ni", 9);   
        MAP.put("te", 10);  MAP.put("ja", 10);  MAP.put("qu", 10);
        MAP.put("ki", 10); 
    }
    //=========================================================================
    /**
     * Constructs a card.
     * The card's type is used in removing them all from your inventory
     * between games.
     * @param name The name of the card.
     */
    public Card(String name) {
        super(name, 0);
        this.type = Names.CARD;
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
