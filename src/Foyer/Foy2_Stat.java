package Foyer;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Statue;
/**
 * Player must move this to discover lever.
 * 
 * @see Foyer.Foy2_Lvr
 * @author Kevin Rapa
 */
public class Foy2_Stat extends Statue {
    private boolean moved;
    private final Furniture REF; 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Stat(Furniture foy2Lvr) {
        super();
        this.moved = false;
        this.REF = foy2Lvr;
        this.description = "A white marble statue. It depicts a woman holding\n"
                         + "a vessel of water on her shoulder. At its base,\n"
                         + "there appears to be some skid markings on the floor.";
        this.searchDialog = "The statue appears to hide nothing, although there\n"
                          + "streaks on the floor beginning at the statue's base.";
        this.addActKeys("push", "pull", "move", "slide");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches("(?:push|pull|move|slide)")) {
            if (! this.moved) {
                Player.getRoomObj(Id.FOY2).addFurniture(REF);
                this.moved = true;
                return "You push the statue and manage to displace it a bit.\n"
                     + "In the alcove, behind the statue, you discover a lever."; 
            }
            else
                return "You have moved the statue as far as you can.";
        }
        return actDialog;
    }
/*----------------------------------------------------------------------------*/
    public boolean moved() {
        return this.moved;
    }
/*----------------------------------------------------------------------------*/
}
