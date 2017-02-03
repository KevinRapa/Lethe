package Tomb;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Tmb2_Light extends Furniture {
    // ========================================================================
    public Tmb2_Light () {
        super();
        
        this.description = "The orb is blinding and is the only thing lighting\n"
                         + "the room. It has no source, nor any vessel to contain it...";
        this.actDialog = "You attempt to touch the orb, but the orb just dodges\n"
                       + "it autonomously.";
        this.searchDialog = this.actDialog;

        this.addNameKeys("(?:inexplicable )?(?:orb of |ball of )?(?:blinding )?light");
        this.addActKeys(GETPATTERN);
        this.addActKeys(FEELPATTERN);
    }
    // ========================================================================     
}


