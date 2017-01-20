package Observatory;

import A_Super.Furniture;
import A_Super.Item;
/**
 * Holds a ruby, one item needed in the Jade Hall puzzle.
 * 
 * @author Kevin Rapa
 */
public class Obs3_Chandelier extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Obs3_Chandelier(String NAME, Item ... items) {
        super(items);
        this.searchable = false;
        this.description = "The curved brass chandelier hangs high up from a\n"
                         + "chain extending through a hole in the ceiling.\n"
                         + "Secured in its center is a red jewel encompassed\n"
                         + "by the chandelier's many candles.";
        this.searchDialog = "The chandelier is too high up.";
        this.addNameKeys("(?:curved )?(?:brass )?chandelier");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.searchable) 
            return "The brass chandelier's chain, having extended from\n" +
                   "the ceiling, suspends the chandelier now level with the\n" +
                   "observatory's top floor. It's just within reach.";
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (this.searchable)
            return "The chandelier is just within reach.";
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    public void lower() {
        this.searchable = true;
    }
/*----------------------------------------------------------------------------*/
}
