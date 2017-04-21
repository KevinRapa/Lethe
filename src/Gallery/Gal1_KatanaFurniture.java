package Gallery;

import A_Main.Id;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
/**
 * A sword which can be taken off the wall.
 * When this is taken, this removes itself from the room and adds itself to
 * the player's inventory. Can be used to cut the rope in Gal3.
 * 
 * @see Gallery.Gal3_Rope
 * @author Kevin Rapa
 */
public class Gal1_KatanaFurniture extends Furniture { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_KatanaFurniture() {
        super();
        this.searchable = false;
        this.description = "The black katana looks exceptionally sharp.";
        this.actDialog = "You take the katana off its display.";
        this.addActKeys(GETPATTERN);
        this.addActKeys("wield");
        this.addNameKeys("(?:black )?(?:katana|sword)");
    }
//----------------------------------------------------------------------------- 
    @Override public String interact(String key) { 
        
        if (Player.getInv().add(
            new Item("katana", "An expensive-looking icon of Japanese culture with not a detail spared. "
                    + "The long, slender blade gently curves to a braided handle.", 80))
           ) 
        {
            Player.getRoomObj(Id.GAL1).removeFurniture(this);
            return this.actDialog;
        }
        else
            return NOTHING;
    }
//-----------------------------------------------------------------------------    
    
}