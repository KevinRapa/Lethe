package Crypt;

import A_Super.Furniture;
/**
 * Serves as a dummy furniture to display input whenever the player speaks
 * in the crypt.
 * 
 * @see Crypt.Cry2_Psswd
 * @author Kevin Rapa
 */
public class Cry_Dummy extends Furniture {
    // ========================================================================
    public Cry_Dummy () {
        super();
        this.searchable = false;
        
        this.description = this.searchDialog = this.useDialog =
                "There is nothing with that name here.";
        this.actDialog = "You speak the words, but nothing happens";
        
        this.addNameKeys(".+");
        this.addUseKeys(".+");
        this.addActKeys("talk", "speak", "say", "announce", "whisper");
    }
    // ========================================================================  
}


