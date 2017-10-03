package Parlor;

import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Hides a brass plate for the observatory puzzle.
 * 
 * @see Observatory.Obs1_Statues
 * @see Observatory.Obs1_Slots
 * @author Kevin Rapa
 */
public class Par1_Cushion extends SearchableFurniture {
    private final Item PLATE_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1_Cushion(Item plate) {
        super(plate);
        
        this.PLATE_REF = plate;
        this.description = "It's a lavender tasseled cushion for sitting on.";
        this.searchDialog = "You lift the cushion.";
        this.actDialog = "What a comfortable cushion! Well, the cushion is nice, "
                       + "feels hard underneath though... Could just be the floor.";
        this.addNameKeys("(?:lavender )?(?:tasseled )?(?:cushion|pillow)");
        this.addActKeys(SITPATTERN, MOVEPATTERN, "lift");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.matches(SITPATTERN)) {
            return this.actDialog;
        }
        else {
            if (this.inv.contains(PLATE_REF.toString())) {
                if (Player.getInv().isFull()) {
                    return "You lift the cushion and discover a clean, shiny "
                         + "plate underneath. Unfortunately, you realize that "
                         + "your inventory is full and thus cannot take the item. "
                         + "You set the cushion back down.";
                }
                else {
                    this.inv.give(PLATE_REF, Player.getInv());
                    return "You lift the cushion and discover a clean, shiny "
                         + "plate underneath. You gleefuly take it and set the "
                         + "cushion back down.";
                }
            }
            else {
                return "You lift the pillow to fluff it up a bit and then set "
                     + "it back down.";
            }
        }
    }
//-----------------------------------------------------------------------------    
}