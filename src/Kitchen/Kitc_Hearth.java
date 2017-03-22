package Kitchen;

import static A_Main.Names.HAND_TORCH;
import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;

public class Kitc_Hearth extends SearchableFurniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Hearth(Item ... items) {
        super(items);
  
        this.description = "The hearth is a simple square pit lined with mortared cobblestone.";
        this.searchDialog = "You look inside the pit.";
        this.actDialog = "You really could use a steak or ham right now.";
        this.useDialog = "You try lighting the wood, but they are too rotted and\n"
                       + "moist from the coastal air to light.";
        
        this.addNameKeys("(?:unlit )?hearth", "(?:square )?pit");
        this.addActKeys("cook");
        this.addUseKeys(HAND_TORCH);
    }
/*----------------------------------------------------------------------------*/
}

