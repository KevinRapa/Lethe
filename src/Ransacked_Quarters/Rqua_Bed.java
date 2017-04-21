package Ransacked_Quarters;

import A_Main.AudioPlayer;
import A_Super.Furniture;
        
public class Rqua_Bed extends Furniture {
    private boolean moved;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Bed () {
        super();

        this.moved = false;
        this.description = "It's a plain, wooden bedframe. The mattress has been thrown off. A tile beneath "
                          + "the bed looks suspicious.";
        this.searchDialog = "Nothing here. It's a bad place to hide something, "
                          + "as someone has already searched it. A tile beneath "
                          + "the bed looks suspicious, though.";
        this.actDialog = "You move the bed out of the way, exposing a loose tile. "
                       + "The woman in the room keeps grinning wildly at you.";
        this.addNameKeys("(?:flimsy )?(?:metal )?(?:bedframe|bed)");
        this.addActKeys(MOVEPATTERN, SITPATTERN);
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {  
        if (key.matches(MOVEPATTERN)) {
            if (! this.moved) {
                this.moved = true;
                AudioPlayer.playEffect(41);
                return this.actDialog;
            }
            return "You have already moved the bed.";
        }
        else
            return "This bed looks most uncomfortable.";
    }
//-----------------------------------------------------------------------------
    public boolean isMoved() {
        return this.moved;
    }
//-----------------------------------------------------------------------------
}
