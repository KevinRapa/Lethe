package Workshop;

import Super.Furniture;
        
public class Wrk_Frg extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Frg(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The brick forge's heat envelops the room. Though\n"
                         + "there's no fire in it, the smouldering ashes have only begun\n"
                         + "to cool.";
        this.interactDialog = "You're smart enough not to put your hand in there.";
        this.addActKeys("touch");
        this.addNameKeys("forge", "brick forge");
    }
/*----------------------------------------------------------------------------*/
}
