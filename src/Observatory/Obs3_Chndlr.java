package Observatory;

import Super.Furniture;
import Super.Item;

public class Obs3_Chndlr extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Obs3_Chndlr(String NAME, Item ... items) {
        super(items);
        this.searchable = false;
        this.description = "The curved brass chandelier hangs high up from a\n"
                         + "chain extending through a hole in the ceiling.\n"
                         + "Secured in its center is a red jewel encompassed\n"
                         + "by the chandelier's many candles.";
        this.searchDialog = "The chandelier is too high up.";
        this.addNameKeys("chandelier", "chandeleir");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.searchable) 
            rep = "The brass chandelier's chain, having extended from\n" +
                  "the ceiling, puts the chandelier now level with the\n" +
                  "observatory's top floor. It's just within reach.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable)
            rep = "The chandelier is just within reach.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public void lower() {
        this.searchable = true;
    }
/*----------------------------------------------------------------------------*/
}
