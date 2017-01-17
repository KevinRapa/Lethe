package Strange_Pool;

import A_Super.Furniture;
/**
 * The grate the player climb out of in escaping the cell.
 * The player is not allowed to go backwards.
 * 
 * @author Kevin Rapa
 */
public class Sewp_Grt extends Furniture {
    // ========================================================================
    public Sewp_Grt () {
        super();
        this.searchable = false;
        
        this.description = "It's an open metal grate with the ladder descending\n"
                         + "into the hole that you escaped out of.";
        this.actDialog = "You've just escaped! No need to back into the dangerous tunnel.";

        this.addNameKeys("(?:metal )?(?:ladder|grate)");
        this.addActKeys("climb", "descend", "use");
    }
    // ========================================================================    
}


