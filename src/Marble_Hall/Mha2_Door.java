package Marble_Hall;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.*;
import A_Super.Door;
import A_Super.Direction;
import A_Main.Player;
import A_Super.Item;
/**
 * Leads to the dining room- player must locate 3 medallions and use them
 * on this door in order to unlock the room.
 * 
 * <ul>
 * <li>Angel medallion, in right angel statue in marble hall.</li>
 * <li>Horse medallion, inside the horse statue in the library</li>
 * <li>Soldier medallion, in the courtyard 5 fountain with the soldier statue</li>
 * </ul>
 * 
 * @see Marble_Hall.Mha2_RightStatue
 * @see Library.Lib3_Statue
 * @see Courtyard.Cou5_Fountain
 * @see Dining_Room.Din1
 * @author Kevin Rapa
 */
public class Mha2_Door extends Door {
    private byte 
        numEmpty, 
        angSolHrs; // Each bit represents a medallion. '1' means it was returned. 
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Mha2_Door (Direction dir) {
        super(dir);
        
        this.angSolHrs = 0;
        this.numEmpty = 3;
        
        this.description = 
                "The double doors here are locked tight. Four round "
                 + "sockets are built into the door's surface. One already "
                 + "contains a gold disk with an engraving of an angel on it. "
                 + "In the other three sockets you make out a second engraving "
                 + "of an angel, an engraving of a soldier, and an engraving "
                 + "of a horse.";
        
        this.addNameKeys("(?:double )?doors", "(?:door )?(?:sockets?|slots?)");
        this.addUseKeys(STONE_DISK, ANGEL_MEDALLION, HORSE_MEDALLION);
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        String name = item.toString(), res;
        
        if (name.equals(STONE_DISK) || name.equals(ANGEL_MEDALLION) 
                || name.equals(HORSE_MEDALLION)) 
        {
            res = "You press the " + name + " into its socket.";
            AudioPlayer.playEffect(43);

            switch (name) {
                case STONE_DISK:
                    angSolHrs |= 0b010; break;
                case ANGEL_MEDALLION:
                    angSolHrs |= 0b100; break;
                case HORSE_MEDALLION:
                    angSolHrs |= 0b001; break;
            }

            Player.getInv().remove(item);
            this.numEmpty--;

            if (this.numEmpty == 0) {
                Player.getRoomObj(Id.DIN1).setLocked(false);
                return res + " With the last medallion in place, the door *clicks* loudly.";
            }      
            
            return res;
        }
        else if (name.equals(CROWBAR))
            return "The medallion is wedged in tightly and can't be pried out.";
        else
            return super.useEvent(item);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {    
        String res = "The doors remain locked. ";
        
        switch (this.numEmpty) {
            case 1: 
                switch (angSolHrs) {
                    case 0b110:
                        return res + "The socket with the horse engraving remains empty.";
                    case 0b101:
                        return res + "The socket with the soldier engraving remains empty.";
                    case 0b011:
                        return res + "The socket with the angel engraving remains empty.";
                }
            case 2:
                switch (angSolHrs) {
                    case 0b100:
                        return res + "The sockets with the soldier and horse engravings remain empty.";
                    case 0b010:
                        return res + "The sockets with the angel and horse engravings remain empty.";
                    case 0b001:
                        return res + "The sockets with the angel and soldier engravings remain empty.";
                }  
            case 0:
                return "All of the door's medallions have been returned. The door is unlocked.";
            default:
                return this.description;
        }
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        return (this.numEmpty == 3) ?
             "You can't seem to dig the disk out by hand." :
             "You can't seem to dig the medallions out by hand.";
    } 
//-----------------------------------------------------------------------------
}
