package Laboratory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Labo_Table extends Furniture {
    // ========================================================================
    public Labo_Table () {
        super();

        this.description = "The small black table in the center of the room supports the burette on top.";
        this.actDialog = "There's fragile stuff on top. Better not do that!!";
        this.searchDialog = "Nothing but a burette on top";
        
        this.addNameKeys("(?:small )?(?:black )?table");
        this.addActKeys("kick|nudge|jostle");
    }
    // ========================================================================    
}


