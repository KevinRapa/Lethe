package Workshop;

import Super.Furniture;
        
public class Wrk_Anvl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Anvl() {
        super();
        this.searchable = false;
        this.description = "It's a quintessential anvil if you've ever seen one.\n"
                         + "It looks heavily used.";
        this.searchDialog = "There's nothing to search for on an anvil.";
        this.interactDialog = "There's a plethora of weapons downstairs. No need for that.";
        this.addActKeys("hammer", "use");
        this.addNameKeys("anvil");
    }
/*----------------------------------------------------------------------------*/
}