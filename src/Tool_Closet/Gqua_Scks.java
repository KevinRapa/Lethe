package Tool_Closet;

import Super.Furniture;
import Super.Item;

public class Gqua_Scks extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Scks(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "Three large white cloth sacks sit carelessly tossed\n"
                         + "against the wall.";
        this.searchDialog = "You look into each of the sacks.";
        this.addNameKeys("sack", "sacks");
        this.addActKeys("touch", "poke", "feel");
    }
/*----------------------------------------------------------------------------*/
}
