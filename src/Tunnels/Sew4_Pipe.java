package Tunnels;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Names;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
import A_Super.Unmoveable;
/**
 * The player must find a piece of pipe and use on this in order to properly
 * operate the valves.
 * 
 * @see Tunnels.Sew2_Vlvs
 * @author Kevin Rapa
 */
public class Sew4_Pipe extends Furniture implements Resetable, Unmoveable {
    private boolean hasPipe;
    private final int SEW1_RVR;
    private final Item PIPE_REF;
    //-------------------------------------------------------------------------
    public Sew4_Pipe (Furniture sew1Rvr, Item pipe) {
        super();
        
        this.SEW1_RVR = sew1Rvr.getID();
        this.PIPE_REF = pipe;
        
        this.hasPipe = false;
        
        this.description = "The rusty pipe runs along the ceiling around the "
                         + "bend right above the river. ";
        this.searchDialog = "The pipe has a gap where a piece has fallen.";
        this.useDialog = "The pipe is too high up for you to reach!";

        this.addNameKeys("(?:large )?(?:rusty )?(?:metal )?pip(?:e|ing)", "gap");
        this.addUseKeys(Names.PIECE_OF_PIPE);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return this.hasPipe ? 
                this.description :
                this.description.concat("The piping here has a short 2-foot section missing.");
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        return this.hasPipe ? "The pipe isn't hiding anything unusual." :
                this.searchDialog;
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        if (Player.getPos().hasFurniture(Names.METAL_LADDER)) {
            Player.getInv().remove(item);
            AudioPlayer.playEffect(51);
            this.hasPipe = true;
            Player.describeRoom();
            return "With all your strength, you shove the piping between the "
                 + "break in the piping. It's a good fit, but may not hold long...";
        }
        else
            return this.useDialog;
    }
    //-------------------------------------------------------------------------
    public boolean isMissingPipe() {
        return (! this.hasPipe);
    }
    //-------------------------------------------------------------------------
    /**
     * Puts pipe back in Sew1 river and sets hasPipe to false.
     */
    @Override public void reset() {
        if (this.hasPipe) {
            this.hasPipe = false;
            Player.getRoomObj(Id.SEW1).getFurnRef(SEW1_RVR)
                    .getInv().forceAdd(PIPE_REF); // Prevents dialog.
        }
    }
    //-------------------------------------------------------------------------
}


