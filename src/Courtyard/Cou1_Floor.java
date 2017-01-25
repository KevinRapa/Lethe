package Courtyard;

import A_Main.AudioPlayer;
import A_Main.Inventory;
import static A_Main.NameConstants.SHOVEL;
import static A_Main.NameConstants.TROWEL;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import A_Super.Gettable;
import A_Super.SearchableFurniture;
/**
 * The player digs a hole here to find a brass plate needed for Observatory puzzle
 * 
 * @see Observatory.Obs_Stats
 * @see Observatory.Obs_Slts
 * @see Courtyard.Cou1_Hl
 * @author Kevin Rapa
 */
public class Cou1_Floor extends SearchableFurniture implements Gettable{
    private final Furniture HOLE_REF;
    private final Item SOIL_REF, GRASS_REF, CLOVER_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Cou1_Floor(Item soil, Item grass, Item clover, Furniture hole, Item ... items) {
            super(items);
            
            this.SOIL_REF = soil;
            this.GRASS_REF = grass;
            this.CLOVER_REF = clover;
            this.HOLE_REF = hole;
            
            this.description = "The ground is a mixture of grass, weeds, and clover.\n"
                             + "It is roughened, as if someone had dug it up recently.";
            this.searchDialog = "You crouch down and scan the ground.";
            this.actDialog = "You have nothing to dig the ground with.";
            this.useDialog = "You dig about a foot-deep hole in the ground. In the hole,\n"
                           + "you uncover something.";
            
            this.addActKeys(GETKEYS);
            this.addActKeys("dig", SHOVEL);
            this.addUseKeys(SHOVEL, TROWEL);
            this.addNameKeys("floor", "ground", "dirt", "earth", 
                             "soil", "grass", "weeds?", "clovers?");
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
        if (key.equals("dig") || key.equals(SHOVEL)) {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL))
                return this.useEvent(null); // Safe. Item is unused in interact here.
            else
                return "You have nothing suitable to dig the ground with.";
        }
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        Inventory i = Player.getInv();
        
        if (! (i.contains(SOIL_REF) && i.contains(GRASS_REF) && 
               i.contains(CLOVER_REF))) 
        {
            Player.getInv().add(SOIL_REF);
            Player.getInv().add(GRASS_REF);
            Player.getInv().add(CLOVER_REF);
            return "You jam your fingers into the ground and grab a fistful of Earth.";
        }
        else
            return "You already have some ground.";
    }
/*----------------------------------------------------------------------------*/
}
