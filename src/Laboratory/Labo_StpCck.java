package Laboratory;

import A_Super.Furniture;
/**
 * This is used to resolve ambiguity since there are multiple stopcocks in the 
 * room for the player to turn.
 * 
 * @author Kevin Rapa
 */
public class Labo_StpCck extends Furniture {
    // ========================================================================
    public Labo_StpCck () {
        super();
        this.searchable = false;
        
        this.actDialog = "Both the dispensers and the burette have a stopcock.\n"
                       + "State 'burette stopcock' or 'dispenser stopcock'.";
        
        this.description = "They are small turnable switches for operating titrating instruments. " 
                + this.actDialog;
        
        this.searchDialog = this.actDialog;

        this.addNameKeys("stopcocks?");
        this.addActKeys("use", "dispense", "open", "drain", "rotate", "turn", "twist");
    }
    // ========================================================================   
}


