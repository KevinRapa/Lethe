package Library;

import Super.Furniture;
import Super.Item;
        
public class Lib2_ShRck extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_ShRck(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "The shoe rack sits next to the fireplace. A few\n"
                         + "pairs of shoes are stored on it.";
        this.searchDialog = "You browse the shoe collection.";
        this.addNameKeys("shoe rack", "rack", "rack of");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.inv.getInv().isEmpty())
            rep = "The shoe rack sits next to the fireplace. It's empty.";
        
        else if (this.inv.getInv().size() == 1) {
            rep = "The shoe rack sits next to the fireplace. A pair of shoes\n"
                + "are stored on it.";
        }       
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
