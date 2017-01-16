package Chapel;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cha_Crpt extends Furniture {
    // ========================================================================
    public Cha_Crpt () {
        super();
        this.searchable = false;
        
        this.description = "The long red carpet runs in between the pews. Small\n"
                         + "puffs of smoke rise up with each step you take on it.";
        
        this.searchDialog = "You lift the carpet to find nothing.";
        this.actDialog = this.searchDialog;

        this.addNameKeys("(?:long )?(?:red )?carpet(?: runner)?");
        this.addActKeys("lift");
    }
    // ========================================================================   
}


