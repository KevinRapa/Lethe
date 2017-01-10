package Laboratory;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Cndsr extends Furniture {
    private boolean flapOpen;
    private final Labo_Bkr BEAKER_REF;
    // ========================================================================
    public Labo_Cndsr (Item beakerItem) {
        super();
        this.flapOpen = false;
        this.searchable = false;
        
        this.BEAKER_REF = new Labo_Bkr(beakerItem);
        
        this.description = "This half of the contraption consists of a long, curved\n"
                         + "glass tube on a stand. The glass tube has a switch attached to a stopper inside the tube."
                         + "The tube extends from the condenser and ends hanging above a ";
        this.actDialog = "You toggle the switch attached to the stopper. It's now ";
        this.searchDialog = "The contraption is comprised of many alchemical compnents.\n"
                          + "Though they're alien to you, you note nothing out of the ordinary.";
        this.useDialog = "You place the beaker on top of the drain, under the glass tube.";

        this.addNameKeys("condenser", "glass tube", "stopper", "switch");
        this.addUseKeys("beaker");
        this.addActKeys("flick", "switch", "turn", "toggle", "rotate");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.description.concat(Player.getPos().hasFurniture("beaker") ? 
                "beaker." : "drain on the table.");
    }
    // ========================================================================   
    @Override public String interact(String key) { 
        if (Player.hasItem("lab coat")) {
            this.flapOpen = ! this.flapOpen; 
            return flapOpen ? "open." : "closed.";
        }
        else
            return "You know, it really wouldn't be safe to fool around with this dangerous "
                 + "science equipment without first putting on a lab coat. Better find a lab coat first.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (Player.hasItem("lab coat")) {
            Player.getPos().addFurniture(BEAKER_REF);
            return this.useDialog;
        }
        else
            return "You know, it really wouldn't be safe to fool around with this dangerous "
                 + "science equipment without first putting on a lab coat. Better find a lab coat first.";
    }
    // ========================================================================  
    public boolean condense(int chemical) {
        if (this.flapOpen && Player.getPos().hasFurniture(BEAKER_REF)) {
            this.BEAKER_REF.setMode(chemical);
            
            return true;
        }
        return false;
    }
    // ========================================================================  
}


