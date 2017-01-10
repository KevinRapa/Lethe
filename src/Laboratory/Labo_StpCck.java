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
        
        this.description = "They are small turnable switches for operating titrators.\n"
                         + "Both the dispensers and the burette have a stopcock.\n"
                         + "State 'burette stopcock' or 'dispenser stopcock'.";
        this.actDialog = "Both the dispensers and the burette have a stopcock.\n"
                       + "State 'burette stopcock' or 'dispenser stopcock'.";
        this.searchDialog = "Both the dispensers and the burette have a stopcock.\n"
                          + "State 'burette stopcock' or 'dispenser stopcock'.";;

        this.addNameKeys("stopcock");
        this.addActKeys("use", "dispense", "open", "drain", "rotate", "turn", "twist");
    }
    // ========================================================================   
}


