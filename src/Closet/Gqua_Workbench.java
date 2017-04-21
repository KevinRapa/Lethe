package Closet;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * Contains a screw, for constructing the red lens.
 * 
 * @see Closet.Scrw
 * @see Gallery.LghtMchn
 * @author Kevin Rapa
 */        
public class Gqua_Workbench extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Workbench(Item... items) {
        super(items);
        this.description = "It's a poplar table with stuff on it.";
        this.searchDialog = "You look through its various drawers and nooks.";
        this.actDialog = "The workbench stands firmly in place, letting off only a thick-sounding *thud*.";
        
        this.addNameKeys("(?:poplar |wood(?:en)? )?(?:table|workbench)");
        this.addActKeys(JOSTLEPATTERN);
    }
//-----------------------------------------------------------------------------
}