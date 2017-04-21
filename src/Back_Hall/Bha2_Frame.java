package Back_Hall;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Contains a note and key to assist in the finding of the brass plates needed
 * to solve the observatory puzzle.
 * 
 * @see Back_Hall.Bha_Note
 * @see Observatory.Obs1_Slots
 * @author Kevin Rapa
 */
public class Bha2_Frame extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha2_Frame(Item... items) {
        super(items);
        
        this.description = "The picture frame is charred but still intact.";
        this.searchDialog = "You flip it over and look inside the frame.";
        
        this.addNameKeys("(?:charred )?(?:picture )?frame");
    }
//-----------------------------------------------------------------------------
}