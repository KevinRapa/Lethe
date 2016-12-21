package Back_Hall;

import Super.Furniture;
import Super.Item;

public class Bha1_Tbl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1_Tbl(Item ... items) {
        super(items);
        this.description = "A petite drawered end table. A potted plant sits\n"
                         + "on top.";
        this.searchDialog = "You slide open the drawer and look inside.";
        this.interactDialog = "Jostling the table a little, you find its\n" +
                              "craftsmanship impressive. The carvings on it are\n" + 
                              "equally such.";
        this.addNameKeys("drawered end table", "end table");
        this.addActKeys("move", "kick");
    }
/*----------------------------------------------------------------------------*/    
}
