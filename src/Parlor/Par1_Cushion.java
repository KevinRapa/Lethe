package Parlor;

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
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1_Cushion(Item ... items) {
        super(items);
        this.description = "It's a lavender tasseled cushion for sitting on.";
        this.searchDialog = "You lift the cushion.";
        this.actDialog = "What a comfortable cushion! Well, the cushion is nice, "
                       + "feels hard underneath though... Could just be the floor.";
        this.addNameKeys("(?:lavender )?(?:tasseled )?cushion");
        this.addActKeys(SITPATTERN, MOVEPATTERN, "lift");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(SITPATTERN))
            return this.actDialog;
        else {
            if (this.containsItem("brass plate, \"Mars\""))
                return "You lift up the cushion and affirm that there is in fact "
                     + "a hard, shiny brass plate underneath. You place the cushion back "
                     + "down.";
            else
                return "You lift the cushion and then put it back down again. Seems "
                     + "productive.";
        }
    }
/*----------------------------------------------------------------------------*/    
}