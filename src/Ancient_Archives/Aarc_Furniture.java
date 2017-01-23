package Ancient_Archives;

import A_Main.Player;
import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * This type of furniture can't be interacted with if the player doesn't hold 
 * a torch.
 * 
 * @author Kevin Rapa
 */
public class Aarc_Furniture extends SearchableFurniture {
    private final String TOO_DARK = "The room is pitch black. You cannot see a thing.";
    // ========================================================================
    public Aarc_Furniture (Item... items) {
        super(items);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return checkForTorch(this.description);
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return checkForTorch(this.searchDialog);
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        return checkForTorch(this.actDialog);
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        return checkForTorch(this.useDialog);
    }
    // ======================================================================== 
    private String checkForTorch(String dialog) {
        return Player.hasItem(HAND_TORCH) ? dialog : TOO_DARK;
    }
    // ======================================================================== 
}


