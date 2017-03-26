package Catacomb_Entrance;

import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Cs35_Statue extends Statue {
    // ========================================================================
    public Cs35_Statue () {
        super();
        this.description = "The three robed males tower over you. Each bears in " +
                           "his hand what looks like an archaic key. The first " +
                           "male is bearded and wears a crown made of grass. " +
                           "The second is clean-shaven and holds a scepter. He " +
                           "wears the hat of a scholar. The third looks old and " +
                           "has a demonic presence to him. He holds a candelabra " +
                           "and wears an ostensibly metal crown.";
        this.searchDialog = "The keys are just part of the statue.";

        this.addNameKeys("males?", "male statues?");
    }
    // ========================================================================     
}


