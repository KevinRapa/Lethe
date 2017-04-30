package Gallery;

import A_Super.Furniture;
import A_Main.Player;
import A_Super.Weapon;
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

        this.description = "The black katana looks exceptionally sharp.";
        this.actDialog = "You take the katana off its display.";
        
        this.addActKeys(GETPATTERN, "wield");
        this.addNameKeys("(?:black )?(?:katana|sword)");
    }
//----------------------------------------------------------------------------- 
    @Override public String interact(String key) { 
        
        if (Player.getInv().add(
            new Weapon("katana", "An expensive-looking icon of Japanese culture with not a detail spared. "
                    + "The long, slender blade gently curves to a braided handle.", 80))
           ) 
        {
            Player.getPos().removeFurniture(this);
            return this.actDialog;
        }
        else
            return NOTHING;
    }
//-----------------------------------------------------------------------------    
    
}