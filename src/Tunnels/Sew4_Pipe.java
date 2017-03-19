package Tunnels;

import A_Main.NameConstants;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Heavy;
import A_Super.Item;
import A_Super.Resetable;
/**
 * The player must find a piece of pipe and use on this in order to properly
 * operate the valves.
 * 
 * @see Tunnels.Sew2_Vlvs
 * @author Kevin Rapa
 */
public class Sew4_Pipe extends Furniture implements Resetable, Heavy {
    private boolean hasPipe;
    private final Furniture SEW1_RVR;
    private final Item PIPE_REF;
    // ========================================================================
    public Sew4_Pipe (Furniture sew1Rvr, Item pipe) {
        super();
        
        this.SEW1_RVR = sew1Rvr;
        this.PIPE_REF = pipe;
        
        this.hasPipe = false;
        
        this.description = "The rusty pipe runs along the ceiling around the\n"
                         + "bend right above the river. ";
        this.searchDialog = "The pipe is missing a piece.";
        this.useDialog = "The pipe is too high up for you to reach!";

        this.addNameKeys("(?:large )?(?:rusty )?(?:metal )?pip(?:e|ing)");
        this.addUseKeys(NameConstants.PIECE_OF_PIPE);
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
        if (Player.getPos().hasFurniture(NameConstants.METAL_LADDER)) {
            Player.getInv().remove(item);
            this.hasPipe = true;
            Player.describeRoom();
            return "With all your strength, you shove the piping between the "
                    + "break in the piping. It's a good fit, but may not hold long...";
        }
            
        return this.useDialog;
    }
    // ========================================================================
    public boolean isMissingPipe() {
        return (! this.hasPipe);
    }
    // ========================================================================
    /**
     * Puts pipe back in Sew1 river and sets hasPipe to false.
     */
    @Override public void reset() {
        if (this.hasPipe) {
            this.hasPipe = false;
            this.SEW1_RVR.getInv().contents().add(PIPE_REF);
        }
    }
    // ========================================================================
}


