package Laboratory;

import A_Main.GUI;
import A_Main.Player;
import static A_Main.NameConstants.*;
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
        this.searchDialog = "The contraption is comprised of many alchemical components.\n"
                          + "Though they're alien to you, you note nothing out of the ordinary.";
        this.useDialog = "You place the beaker on top of the drain, under the glass tube.";

        this.addNameKeys("condenser", "glass tube", "stopper", "switch", "drain");
        this.addUseKeys(BEAKER, TEST_TUBE, FLORENCE_FLASK, EMPTY_VIAL, "copper pot", "copper pan");
        this.addActKeys("flick", "switch", "turn", "toggle", "rotate");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.description.concat(Player.getPos().hasFurniture(BEAKER) ? 
                "beaker." : "drain on the table.");
    }
    // ========================================================================   
    @Override public String interact(String key) { 
        if (Player.hasItem(LAB_COAT)) {
            this.flapOpen = ! this.flapOpen; 
            return this.actDialog.concat(flapOpen ? "open." : "closed.");
        }
        else
            return "You know, it really wouldn't be safe to fool around with this dangerous "
                 + "science equipment without first putting on a lab coat. Better find a lab coat first.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (Player.hasItem(LAB_COAT)) {
            if (item.toString().matches("florence flask|test tube|empty vial|copper pot|copper pan")) {
                return "That type of vessel was not designed for collecting chemicals! Put it down before you poke your eye out.";
            }
            else {
                Player.getInv().remove(item);
                Player.getPos().addFurniture(BEAKER_REF);
                return this.useDialog;
            }
        }
        else
            return "You know, it really wouldn't be safe to fool around with this dangerous "
                 + "science equipment without first putting on a lab coat. Better find a lab coat first.";
    }
    // ========================================================================  
    public boolean condense(int chemical) {
        String result = "You strike the top of the burner. For a minute, it burns against the flask's bottom,\n"
                      + "boiling the insides aggressively. % After a minute, the flame dies out.";
        
        if (this.flapOpen) {
            if (Player.getPos().hasFurniture(BEAKER_REF)) {
                this.BEAKER_REF.setMode(chemical);
                GUI.out(result.replaceFirst("%", "The chemical condenses into the beaker on the other side."));
            }
            else {
                GUI.out(result.replaceFirst("%", 
                        "You watch in horror as the chemical condenses into the glass tube and\n"
                      + "flows down the drain under the condenser."));
            }
        return true;
        }
        else {
            GUI.out(result.replaceFirst("%", 
                    "The liquid evaporates up into the glass tube, but starts dripping back\n"
                  + "out into the florence flask. You scratch your head."));

            return false; 
        }
    }
    // ========================================================================  
}


