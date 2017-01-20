package Cistern;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cis_Darkness extends Furniture {
    // ========================================================================
    public Cis_Darkness () {
        super();
        this.searchable = false;
        
        this.description = "The darkness hides the true size of the room, though\n" +
                           "you suppose it could be as big as 100 feet across and\n" +
                           "50 feet high, perhaps more. The darkness combined with\n" +
                           "the turgid air gives you claustrophobia.";

        this.addNameKeys("darkness", "dark void", "void", "blackness");
    }
    // ========================================================================    
}


