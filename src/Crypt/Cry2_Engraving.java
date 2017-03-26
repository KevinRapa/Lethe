package Crypt;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Moveable;
/**
 * @author Kevin Rapa
 */
public class Cry2_Engraving extends Furniture implements Moveable {
    // ========================================================================
    public Cry2_Engraving () {
        super();
        this.description = "The tall coffin resembles a large stone box. The box "
                         + "has a lid, but something is holding it closed. The lid "
                         + "of the coffin is artfully decorated with a carving of "
                         + "a boney cloaked figure bearing a halo."
                         + "Around it is an engraving resembling "
                         + "a doorway. The engraving depicts two grooved "
                         + "columns holding up a roof.";
        this.actDialog = "You can't pry it open. Something is holding the coffin "
                       + "tightly closed.";
        
        this.addNameKeys("(?:wall )?(?:engraving|carving)", "(?:stone )?(?:box|coffin|casket|lid)",
                "(?:(?:artfully )?decorated)?lid");
        this.addActKeys("open");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        if (Player.getPos().isAdjacent(Id.CAS1)) {
            return "The engraving frames a metal door in the center of it. The stone "
                 + "coffin stands off to the side.";
        }
        return this.description;
    }
    // ========================================================================   
    @Override public String moveIt() {
        if (Player.getPos().isAdjacent(Id.CAS1))
            return "There really is no reason. The coffin has already been moved.";
        else
            return "As hard as you try, you cannot manage to budge it even a small distance.";
    }
    // ========================================================================   
}


