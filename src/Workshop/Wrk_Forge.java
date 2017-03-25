package Workshop;

import static A_Main.Names.HAMMER;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Unmoveable;
        
public class Wrk_Forge extends Furniture implements Gettable, Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Forge() {
        super();

        this.description = "The brick forge's heat envelops the room. Though\n"
                         + "there's no fire in it, the smoldering ashes have only begun\n"
                         + "to cool.";
        this.actDialog = "You're smart enough not to put your hand in there.";
        this.useDialog = "You'd much rather work with wood than metal...";
        
        this.addActKeys(GETPATTERN);
        this.addActKeys(FEELPATTERN);
        this.addUseKeys(HAMMER);
        this.addNameKeys("(?:brick )?forge", "(?:smoldering )?ash(?:es)?");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(FEELPATTERN))
            return this.actDialog;
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/    
}
