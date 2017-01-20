package Ancient_Tomb;

import static A_Main.NameConstants.*;
import A_Super.Furniture;
import A_Main.Player;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Ant_Casket extends Furniture implements Openable {
    private int numKeys;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Ant_Casket (Item ... items) {
        super(items);
        this.searchable = false;
        this.searchDialog = "You can't seem to push the lid off. It's sealed with an archaic lock system.";
        this.description = "The casket lies horizontal in the center of the room.\n"
                         + "It's unlike the rest of the caskets; made of stone, and\n"
                         + "covered by a thick lid. There are three keyholes lined\n"
                         + "up vertically in the center of the lid.";
        this.numKeys = 0;
        this.addNameKeys("(?:stone )?(?:casket|coffin)");
        this.addUseKeys(KEY_OF_ANCESTRY, KEY_OF_INTELLECT, KEY_OF_CONTINUITY);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = "You insert the key into one of its holes and turn it.";

        Player.getInv().remove(item);
        this.numKeys++;
        
        if (this.numKeys == 3) {
            this.searchable = true;
            return rep.concat(" With the last key inserted, the casket lid *clicks* loudly.\n"
                            + "You push the lid with all your might, and it slides off to the side.\n"
                            + "To your surprise, there is nothing inside except for a leaf of parchment.");
        } 
        else
            return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {    
        switch (this.numKeys) {
            case 1: 
                return "The lid is locked. One of the keyholes remain empty.";
            case 2:
                return "The lid remains locked tightly. 1 keyhole remains empty.";
            case 3:
                return "All of the keys have been inserted into the coffin keyholes.";
            default: // 0
                return this.description;
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (this.searchable)
            return this.searchDialog;
        else
            return "You look inside the coffin.";
    } 
/*----------------------------------------------------------------------------*/
}


