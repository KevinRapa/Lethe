package Laboratory;

import A_Main.GUI;
import A_Main.Player;
import static A_Main.Names.*;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Moveable;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Condenser extends Furniture implements Moveable {
    private boolean flapOpen;
    private final Labo_Beaker BEAKER_REF;
    // ========================================================================
    public Labo_Condenser (Item beakerItem) {
        super();
        this.flapOpen = false;
        
        this.BEAKER_REF = new Labo_Beaker(beakerItem);
        
        this.description = "This half of the contraption consists of a long, curved\n"
                         + "glass tube on a stand. The glass tube has a switch attached to a stopper inside the tube.\n"
                         + "The tube extends from the condenser and ends hanging above a ";
        this.actDialog = "You toggle the switch attached to the stopper. It's now ";
        this.searchDialog = "The contraption is comprised of many alchemical components.\n"
                          + "Though they're alien to you, you note nothing out of the ordinary.";
        this.useDialog = "You place the beaker on top of the drain, under the glass tube.";

        this.addNameKeys("condenser", "(?:glass )?tube|stopper|switch|drain");
        this.addUseKeys(BEAKER, TEST_TUBE, FLORENCE_FLASK, EMPTY_VIAL, "copper (?:pot|pan)");
        this.addActKeys("flick", "turn", "toggle", "rotate");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.description.concat(Player.getPos().hasFurniture(BEAKER) ? 
                "beaker." : "drain on the table.");
    }
    // ========================================================================   
    @Override public String interact(String key) { 
        this.flapOpen = ! this.flapOpen; 
        return this.actDialog.concat(flapOpen ? "open." : "closed.");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().matches("florence flask|test tube|empty vial|copper pot|copper pan")) {
            return "That type of vessel was not designed for collecting chemicals! Put it down before you poke your eye out.";
        }
        else {
            Player.getInv().remove(item);
            Player.getPos().addFurniture(BEAKER_REF);
            return this.useDialog;
        }
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
    @Override public String moveIt() {
        return "The contraption looks pretty fragile. You think it best to leave it where it is.";
    }
    // ========================================================================
}


