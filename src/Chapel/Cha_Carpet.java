package Chapel;

import A_Super.Carpet;
/**
 * @author Kevin Rapa
 */
public class Cha_Carpet extends Carpet {
    // ========================================================================
    public Cha_Carpet () {
        super();
        
        this.description = "The long red carpet runs in between the pews. Small\n"
                         + "puffs of smoke rise up with each step you take on it.";
        
        this.searchDialog = "You lift the carpet to find nothing.";
        this.actDialog = this.searchDialog;

        this.addNameKeys("(?:long )?(?:red )?carpet(?: runner)?");
        this.addActKeys("lift");
    }
    // ========================================================================   
}


