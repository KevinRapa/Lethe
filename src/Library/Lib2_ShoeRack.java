package Library;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
        
public class Lib2_ShoeRack extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_ShoeRack(Item... items) {
        super(items);
        this.description = "It's a two-level low shoe rack.";
        this.searchDialog = "You browse the shoe collection.";
        this.addNameKeys("shoe rack", "rack", "rack of shoes");
    }
//-----------------------------------------------------------------------------
}
