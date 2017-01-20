package Courtyard;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.SHOVEL;
import static A_Main.NameConstants.TROWEL;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
/**
 * The player digs a hole here to find a brass plate needed for Observatory puzzle
 * 
 * @see Observatory.Obs_Stats
 * @see Observatory.Obs_Slts
 * @see Courtyard.Cou1_Hl
 * @author Kevin Rapa
 */
public class Cou1_Flr extends Furniture {
    private final Furniture HOLE_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Cou1_Flr(Furniture hole, Item ... items) {
            super(items);
            this.HOLE_REF = hole;
            this.description = "The ground is a mixture of grass, weeds, and clover.\n"
                             + "It is roughened, as if someone had dug it up recently.";
            this.searchDialog = "You crouch down and scan the ground.";
            this.actDialog = "You have nothing to dig the ground with.";
            this.useDialog = "You dig about a foot-deep hole in the ground. In the hole,\n"
                           + "you uncover something.";
            this.addActKeys("dig", SHOVEL);
            this.addUseKeys(SHOVEL, TROWEL);
            this.addNameKeys("floor", "ground");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (Player.getPos().hasFurniture("hole"))
            return "The ground is a mixture of grass, weeds, and clover, interrupted\n"
                 + "by the small hole you dug.";
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (Player.getPos().hasFurniture("hole"))
            return "You have already dug up the ground here.";
        else {
            Player.getPos().addFurniture(HOLE_REF);
            AudioPlayer.playEffect(34);
            return this.useDialog;
        }
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {              
        if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL))
            return this.useEvent(null); // Safe. Item is unused in interact here.
        else
            return "You have nothing suitable to dig the ground with.";
    }
/*----------------------------------------------------------------------------*/ 
}
