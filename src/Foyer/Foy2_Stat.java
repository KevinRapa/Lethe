package Foyer;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Statue;
/**
 * Player must move this to discover a button.
 * 
 * @see Foyer.Foy2_Lvr
 * @author Kevin Rapa
 */
public class Foy2_Stat extends Statue {
    private boolean moved;
    private final Furniture LVR_REF; 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Stat(Furniture foy2Lvr) {
        super();
        this.moved = false;
        this.LVR_REF = foy2Lvr;
        this.description = "A white marble statue. It depicts a woman holding "
                         + "a vessel of water on her shoulder. At its base, "
                         + "there appears to be some skid markings on the floor.";
        this.searchDialog = "The statue appears to hide nothing, although there "
                          + "streaks on the floor beginning at the statue's base.";
        this.addNameKeys("(?:skid )?markings");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(MOVEPATTERN)) {
            if (! this.moved) {
                Player.getPos().addFurniture(LVR_REF);
                AudioPlayer.playEffect(41);
                this.moved = true;
                return "You push the statue and manage to displace it a bit. "
                     + "In the alcove, behind the statue, you discover a small black button."; 
            }
            else
                return "You have moved the statue as far as you can.";
        }
        else
            return super.interact(key);
    }
/*----------------------------------------------------------------------------*/
    public boolean moved() {
        return this.moved;
    }
/*----------------------------------------------------------------------------*/
}
