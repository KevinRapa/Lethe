package Crypt;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cry2_Engraving extends Furniture {
    // ========================================================================
    public Cry2_Engraving () {
        super();
        this.searchable = false;
        
        this.description = "The tall coffin resembles a large stone box. The box\n"
                         + "has a lid, but something is holding it closed. The lid\n"
                         + "of the coffin is artfully decorated with a carving of\n"
                         + "a boney cloaked figure bearing a halo."
                         + "Around it is an engraving resembling\n"
                         + "a doorway. The engraving depicts two grooved\n"
                         + "columns holding up a roof.";
        this.actDialog = "You can't pry it open. Something is holding the coffin\n"
                       + "tightly closed.";
        
        this.addNameKeys("(?:wall )?engraving", "(?:stone )?(?:box|coffin|casket|lid)",
                "(?:(?:artfully )?decorated)?lid");
        this.addActKeys("open");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        if (Player.getPos().isAdjacent(Id.CAS1)) {
            return "The engraving frames a metal door in the center of it. The stone\n"
                 + "coffin stands off to the side.";
        }
        return this.description;
    }
    // ========================================================================   
}


