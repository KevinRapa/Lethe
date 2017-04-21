package Observatory;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Holds a ruby, one item needed in the Jade Hall puzzle.
 * 
 * @author Kevin Rapa
 */
public class Obs3_Chandelier extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Obs3_Chandelier(String NAME, Item ... items) {
        super(items);
        this.searchable = false;
        this.description = "The curved brass chandelier hangs high up from a "
                         + "chain extending through a hole in the ceiling. "
                         + "Secured in its center is a red jewel encompassed "
                         + "by the chandelier's many candles.";
        this.searchDialog = "The chandelier is too high up.";
        this.actDialog = "You would most certainly fall to your death...";
        
        this.addActKeys("swing", "hang");
        this.addNameKeys("(?:curved )?(?:brass )?(?:chandelier|light)");
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (this.searchable) 
            return "The brass chandelier's chain, having extended from " +
                   "the ceiling, suspends the chandelier now level with the " +
                   "observatory's top floor. It's just within reach.";
        else
            return this.description;
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        if (this.searchable)
            return "The chandelier is just within reach.";
        else
            return this.searchDialog;
    }
//-----------------------------------------------------------------------------
    public void lower() {
        this.searchable = true;
    }
//-----------------------------------------------------------------------------
}
