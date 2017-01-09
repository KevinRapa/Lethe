package Catacomb_Entrance;

import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Cs35_Stat extends Statue {
    // ========================================================================
    public Cs35_Stat () {
        super();
        this.description = "The three robed males tower over you. Each bears in\n" +
                           "his hand what looks like an archaic key. The first\n" +
                           "male is bearded and wears a crown made of grass.\n" +
                           "The second is clean-shaven and holds a scepter. He\n" +
                           "wears the hat of a scholar. The third looks old and\n" +
                           "has a demonic presence to him. He holds a candelabra\n" +
                           "and wears an ostensibly metal crown.";
        this.searchDialog = "The keys are just part of the statue.";

        this.addNameKeys("males?", "male statues?");
    }
    // ========================================================================     
}


