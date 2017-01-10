package Laboratory;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Dstllr extends Furniture {
    private final Labo_GsPipe PIPE_REF;
    private final Labo_Cndsr CONDENSER_REF;
    private Runnable distillMethod;
    // ========================================================================
    public Labo_Dstllr (Furniture pipe, Furniture condenser) {
        super();
        this.PIPE_REF = (Labo_GsPipe)pipe;
        this.CONDENSER_REF = (Labo_Cndsr)condenser;
        
        this.searchable = false;
        
        this.searchDialog = "The contraption is comprised of many alchemical compnents.\n"
                          + "Though they're alien to you, you note nothing out of the ordinary.";
        this.description = "It's one half of a larger alchemical contraption in the room.\n"
                         + "On the table is a metal flask rack and a bunsen burner\n"
                         + "under it. Above the setup is a curved glass tube connecting\n"
                         + "to the condenser on the other side of the table.";
        this.useDialog = "You strike the top of the burner. For a minute, the burner burns\n"
                       + "against the flasks bottom, boiling the insides aggressively. After\n"
                       + "a minute, the flame dies out.";

        this.addNameKeys("distillery?", "(?:bunsen )?burner", "(?:flask )?rack");
        this.addUseKeys("rubber hose", "florence flask", "striker", "torch");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return Player.getPos().hasFurniture("florence flask") ?
                "The flask now rests nicely on the rack in between the burner and the distillation tube." :
                this.description;
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (Player.hasItem("lab coat")) {
            if (item.toString().matches("rubber hose")) {
                Player.getInv().remove(item);
                Player.getPos().addFurniture(new Labo_Hose());
                return "You connect the hose to the bunsen burner nozzle and the other end to the gas pipe.";
            }
            else if (item.toString().matches("florence flask")) {
                Player.getInv().remove(item);
                Labo_Flsk flask = new Labo_Flsk(this, CONDENSER_REF); // Don't want to pass this in constructor.
                Player.getPos().addFurniture(flask);
                this.distillMethod = () -> flask.distill();
                return "You place the florence flask onto the rack.";
            }
            else {
                if (PIPE_REF.isOn() && Player.getPos().hasFurniture("hose")) {
                    if (Player.getPos().hasFurniture("florence flask")) {
                        distillMethod.run(); // Cannot run before runDistill has been assigned a value.
                            
                        return this.useDialog;
                    }
                    else {
                        return "You strike the top of the burner. For a minute, the burner burns\n"
                             + "with an intense flame under open space before dying out.";
                    }
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


