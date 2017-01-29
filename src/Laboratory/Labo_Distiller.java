package Laboratory;

import A_Main.AudioPlayer;
import A_Main.Player;
import static A_Main.NameConstants.*;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Distiller extends Furniture {
    private final Labo_GasPipe PIPE_REF;
    private final Labo_Condenser CONDENSER_REF;
    private final Item TUBE_REF, VIAL_REF;
    private final Labo_Flask FLORENCE_FLASK_REF;
    // ========================================================================
    public Labo_Distiller (Furniture pipe, Furniture condenser, Item tstTube, Item vial) {
        super();

        this.PIPE_REF = (Labo_GasPipe)pipe;
        this.CONDENSER_REF = (Labo_Condenser)condenser;
        this.TUBE_REF = tstTube;
        this.VIAL_REF = vial;
        this.FLORENCE_FLASK_REF = new Labo_Flask(CONDENSER_REF, TUBE_REF, VIAL_REF);

        this.searchDialog = "The contraption is comprised of many alchemical compnents.\n"
                          + "Though they're alien to you, you note nothing out of the ordinary.";
        this.description = "It's one half of a larger alchemical contraption in the room.\n"
                         + "On the table is a metal flask rack and a bunsen burner\n"
                         + "under it. Above the setup is a curved glass tube connecting it\n"
                         + "to the condenser on the other side of the table.";

        this.addNameKeys("distillery?", "(?:bunsen )?burner", "(?:flask )?rack");
        this.addUseKeys(RUBBER_HOSE, FLORENCE_FLASK, STRIKER, HAND_TORCH, 
                        BEAKER, TEST_TUBE, EMPTY_VIAL, COPPER_POT, COPPER_PAN);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return Player.getPos().hasFurniture(FLORENCE_FLASK) ?
                "The flask now rests nicely on the rack in between the burner and the distillation tube." :
                this.description;
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        String name = item.toString();
        
        if (Player.hasItem(LAB_COAT)) {
            if (name.equals(RUBBER_HOSE)) {
                Player.getInv().remove(item);
                Player.getPos().addFurniture(new Labo_Hose());
                return "You connect the hose to the bunsen burner nozzle and the other end to the gas pipe.";
            }
            else if (name.equals(FLORENCE_FLASK)) {
                Player.getInv().remove(item);
                Player.getPos().addFurniture(FLORENCE_FLASK_REF);
                return "You place the florence flask onto the rack.";
            }
            else if (name.matches("beaker|test tube|empty vial|copper pot|copper pan")) {
                return "That type of vessel was not designed for boiling chemicals! Put it down before you set the room on fire.";
            }
            else {
                if (PIPE_REF.isOn() && Player.getPos().hasFurniture("hose")) {
                    if (Player.getPos().hasFurniture(FLORENCE_FLASK_REF)) {
                        AudioPlayer.playEffect(45);
                        FLORENCE_FLASK_REF.distill();
                        return null;
                    }
                    else {
                        AudioPlayer.playEffect(45);
                        return "You strike the top of the burner. For a minute, the burner burns\n"
                             + "with an intense flame under open space before dying out.";
                    }
                }
                else if (PIPE_REF.isOn() && ! Player.getPos().hasFurniture("hose")) {
                    AudioPlayer.playEffect(32, 5);
                    return "As you squeeze the striker, a big poof of fire ignites and singes your face.\n"
                         + "The smell of gas fades momentarily and slowly comes back.";
                }
                else
                    return "You strike the burner with no effect.";
            }
        }
        else
            return "You know, it really wouldn't be safe to fool around with this dangerous "
                 + "science equipment without first putting on a lab coat. Better find a lab coat first.";
    }
    // ========================================================================     
}


