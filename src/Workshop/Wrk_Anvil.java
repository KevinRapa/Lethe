package Workshop;

import static A_Main.Names.HAMMER;
import A_Super.Furniture;
import A_Super.Unmoveable;
        
public class Wrk_Anvil extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Anvil() {
        super();

        this.description = "It's a quintessential anvil if you've ever seen one. "
                         + "It looks heavily used.";
        this.searchDialog = "There's nothing to search for on an anvil.";
        this.actDialog = "There's a plethora of weapons downstairs. No need for that.";
        this.addActKeys(HAMMER, "use");
        this.addNameKeys("anvil");
    }
/*----------------------------------------------------------------------------*/
}