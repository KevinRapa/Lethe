package Laboratory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Labo_Tbl extends Furniture {
    // ========================================================================
    public Labo_Tbl () {
        super();
        this.searchable = false;
        
        this.description = "The small black table in the center of the room supports the burette on top.";
        this.actDialog = "There's fragile stuff on top. Better not do that!!";

        this.addNameKeys("(?:small )?(?:black )?table");
        this.addActKeys("kick|nudge|jostle");
    }
    // ========================================================================    
}


