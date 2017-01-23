package Parlor;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Hides a brass plate for the observatory puzzle.
 * 
 * @see Observatory.Obs1_Statues
 * @see Observatory.Obs1_Slots
 * @author Mantis Toboggan
 */
public class Par1_Cushion extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1_Cushion(Item ... items) {
        super(items);
        this.description = "It's a lavender tasseled cushion for sitting on.";
        this.searchDialog = "You lift the cushion.";
        this.actDialog = "Now is not the time for that!";
        this.addNameKeys("(?:lavender )?(?:tasseled )?cushion");
        this.addActKeys("sit", "relax");
    }
/*----------------------------------------------------------------------------*/
}