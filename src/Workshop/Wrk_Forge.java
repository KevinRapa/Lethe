package Workshop;

import A_Super.Furniture;
        
public class Wrk_Forge extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Forge() {
        super();
        this.searchable = false;
        this.description = "The brick forge's heat envelops the room. Though\n"
                         + "there's no fire in it, the smouldering ashes have only begun\n"
                         + "to cool.";
        this.actDialog = "You're smart enough not to put your hand in there.";
        this.addActKeys("touch");
        this.addNameKeys("forge", "brick forge");
    }
/*----------------------------------------------------------------------------*/
}
