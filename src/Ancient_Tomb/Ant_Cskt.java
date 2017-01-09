package Ancient_Tomb;

import A_Super.Furniture;
import A_Main.Player;
import A_Super.Item;
import A_Super.Container;

public class Ant_Cskt extends Furniture implements Container {
    private int numKeys;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Ant_Cskt (Item ... items) {
        super(items);
        this.searchable = false;
        this.searchDialog = "You can't seem to push the lid off. It's sealed with an archaic lock system.";
        this.description = "The casket lays horizontal in the center of the room.\n"
                         + "It's unlike the rest in the room; made of stone, and\n"
                         + "thick lid rests on top. There are three keyholes lined\n"
                         + "up vertically in the center of the lid.";
        this.numKeys = 0;
        this.addNameKeys("(?:stone )?casket|coffin");
        this.addUseKeys("key of ancestry", "key of intellect", "key of continuity");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = "You insert the key into one of its holes and turn it.";

        Player.getInv().remove(item);
        this.numKeys++;
        
        if (this.numKeys == 3) {
            this.searchable = true;
            return rep.concat("\nWith the last key inserted, the casket lid *clicks* loudly.\n"
                            + "You push the lid with all your might, and it slides off to the side.\n"
                            + "To your surprise, there is nothing inside except for a leaf of parchment.");
        }      
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {    
        switch (this.numKeys) {
            case 1: 
                return "The lid remain locked. One of the keyholes remain empty.";
            case 2:
                return "The lid remains locked tightly. 1 keyhole remains empty.";
            case 3:
                return "All of the keys have been inserted into the coffin keyholes.";
            default:
                return this.description;
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (this.searchable)
            return this.searchDialog;
        
        return "You look inside the coffin.";
    } 
/*----------------------------------------------------------------------------*/
}


