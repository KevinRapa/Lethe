package Ancient_Tomb;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Ant_Casket extends SearchableFurniture implements Openable {
    private int numKeys;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Ant_Casket (Item ... items) {
        super(items);
        this.searchable = false;
        this.searchDialog = "You can't seem to push the lid off. It's sealed with an archaic lock system.";
        this.actDialog = "It's very impolite to hit coffins!";
        this.description = "The casket lies horizontal in the center of the room.\n"
                         + "It's unlike the rest of the caskets; made of stone, and\n"
                         + "covered by a thick lid. There are three keyholes lined\n"
                         + "up vertically in the center of the lid.";
        this.numKeys = 0;
        
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:stone )?(?:casket|coffin)", "keyholes?", "holes?", "lid");
        this.addUseKeys(KEY_OF_ANCESTRY, KEY_OF_INTELLECT, KEY_OF_CONTINUITY);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String result = "You insert the key into one of its holes and turn it.";
        AudioPlayer.playEffect(51);
        Player.getInv().remove(item);
        this.numKeys++;
        
        if (this.numKeys == 3) {
            this.searchable = true;
            
            AudioPlayer.playEffect(50);
            return result.concat(" With the last key inserted, you feel the lid jolt a bit.\n"
                            + "You push the lid with all your might, and it slides off to the side.\n"
                            + "To your surprise, there is nothing inside except for a leaf of parchment.");
        } 
        else
            return result;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {    
        switch (this.numKeys) {
            case 1: 
                return "The lid is locked. Two of the keyholes remain empty.";
            case 2:
                return "The lid remains locked tightly. One keyhole remains empty.";
            case 3:
                return "All of the keys have been inserted into the coffin keyholes.";
            default: // 0
                return this.description;
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (this.searchable)
            return "You look inside the coffin.";
        else
            return this.searchDialog;
    } 
/*----------------------------------------------------------------------------*/
}


