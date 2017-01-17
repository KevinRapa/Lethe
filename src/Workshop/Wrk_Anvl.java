package Workshop;

import static A_Main.NameConstants.HAMMER;
import A_Super.Furniture;
        
public class Wrk_Anvl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Anvl() {
        super();
        this.searchable = false;
        this.description = "It's a quintessential anvil if you've ever seen one.\n"
                         + "It looks heavily used.";
        this.searchDialog = "There's nothing to search for on an anvil.";
        this.actDialog = "There's a plethora of weapons downstairs. No need for that.";
        this.addActKeys(HAMMER, "use");
        this.addNameKeys("anvil");
    }
/*----------------------------------------------------------------------------*/
}