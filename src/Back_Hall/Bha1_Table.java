package Back_Hall;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;

public class Bha1_Table extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1_Table(Item ... items) {
        super(items);
        
        this.description = "A petite drawered end table.";
        this.searchDialog = "You slide open the drawer and look inside.";
        this.actDialog = "Jostling the table a little, you find its\n" +
                         "craftsmanship impressive. The carvings on it are\n" + 
                         "equally as such.";
        
        this.addNameKeys("(?:drawered )?(?:end )?table");
        this.addActKeys("move", "kick");
    }
/*----------------------------------------------------------------------------*/    
}
