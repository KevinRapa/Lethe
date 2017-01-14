package Tunnels;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
/**
 * The player must find a piece of pipe and use on this in order to properly
 * operate the valves.
 * 
 * @see Tunnels.Sew2_Vlvs
 * @author Kevin Rapa
 */
public class Sew4_Pp extends Furniture implements Resetable {
    private boolean hasPipe;
    private final Furniture SEW1_RVR;
    private final Item PIPE_REF;
    // ========================================================================
    public Sew4_Pp (Furniture sew1Rvr, Item pipe) {
        super();
        
        this.SEW1_RVR = sew1Rvr;
        this.PIPE_REF = pipe;
        
        this.searchable = false;
        this.hasPipe = false;
        
        this.description = "The rusty pipe runs along the ceiling around the\n"
                         + "bend right above the river. ";
        this.searchDialog = "The pipe is missing a piece.";
        this.useDialog = "The pipe is too high up for you to reach!";

        this.addNameKeys("(?:large )?(?:rusty )?(?:metal )?pip(?:e|ing)");
        this.addUseKeys("piece of pipe");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.hasPipe ? 
                this.description.concat("This section of piping has a short 2-foot section missing.") : 
                this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.hasPipe ? "The pipe isn't hiding anything unusual." :
                this.searchDialog;
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (Player.getPos().hasFurniture("metal ladder")) {
            Player.getInv().remove(item);
            this.hasPipe = true;
            return "With all your strength, you shove the piping into the break in the piping. It's a good fit.";
        }
        else {
            return this.useDialog;
        }
    }
    // ========================================================================
    public boolean isMissingPipe() {
        return (! this.hasPipe);
    }
    // ========================================================================
    @Override public void reset() {
        if (this.hasPipe) 
            this.SEW1_RVR.getInv().contents().add(PIPE_REF);
        
        this.hasPipe = false;
    }
    // ========================================================================
    
}


