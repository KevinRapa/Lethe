package Courtyard;

import A_Main.AudioPlayer;
import A_Main.Inventory;
import static A_Main.Names.*;
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
public class Cou1_Floor extends Cou_Floor {
    private final Furniture HOLE_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Cou1_Floor(Item soil, Item grass, Item clover, Furniture hole, Item ... items) {
            super(soil, grass, clover, items);
            
            this.HOLE_REF = hole;
            
            this.description = "The ground is a mixture of grass, weeds, and clover. "
                             + "It is roughened, as if someone had dug it up recently.";
            
            this.actDialog = "You have nothing to dig the ground with.";
            this.useDialog = "You dig about a foot-deep hole in the ground. In the hole, "
                           + "you uncover something.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (Player.getPos().hasFurniture("hole"))
            return "The ground is a mixture of grass, weeds, and clover, interrupted "
                 + "by the small hole you dug.";
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().equals(HOE))
            return super.useEvent(item);
        else if (Player.getPos().hasFurniture("hole"))
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
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
                Item i = Player.getInv().get(SHOVEL);
                
                if (i.equals(Inventory.NULL_ITEM))
                    i = Player.getInv().get(TROWEL);
                
                return useEvent(i);
            }
            else
                return super.useDialog;
        }
        else
            return super.getIt();
    }
/*----------------------------------------------------------------------------*/
}
