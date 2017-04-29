package Marble_Hall;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.*;
import A_Super.Door;
import A_Super.Room;
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
 * @see Courtyard.Cou5_Fntn
 * @see Dining_Room.Din1
 * @author Kevin Rapa
 */
public class Mha2_Door extends Door {
    private int numMedallions;
    private boolean angel, soldier, horse;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Mha2_Door (Room din, Direction dir) {
        super(dir);
        this.angel = this.soldier = this.horse = false; // Slots
        this.numMedallions = 1;
        this.addNameKeys("(?:double )?doors", "(?:door )?(?:sockets?|slots?)");
        this.addUseKeys(STONE_DISK, ANGEL_MEDALLION, HORSE_MEDALLION);
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        String rep = "You press the " + item + " into its socket.";
        AudioPlayer.playEffect(43);
        
        switch (item.toString()) {
            case STONE_DISK:
                this.soldier = true; break;
            case ANGEL_MEDALLION:
                this.angel = true;   break;
            case HORSE_MEDALLION:
                this.horse = true;   break;
        }
        
        Player.getInv().remove(item);
        this.numMedallions ++;
        
        if (this.numMedallions == 4) {
            Player.getRoomObj(Id.DIN1).unlock();
            return rep.concat(" With the last medallion in place, the door *clicks* loudly.");
        }      
        return rep;
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {    
        switch (this.numMedallions) {
            case 2: 
            case 3:
                String rep;
                
                if (this.numMedallions == 3)
                    rep = "The doors remain locked. 1 socket remains empty.";
                else
                    rep = "The doors remain locked. " + (4 - numMedallions) + " of the sockets remain empty; ";
                
                if (angel && ! soldier && ! horse)
                    return rep.concat("the sockets with the soldier and horse engravings.");
                
                else if (! angel && soldier && ! horse)
                    return rep.concat("the sockets with the angel and horse engravings.");
                
                else if (! angel && ! soldier && horse)
                    return rep.concat("the sockets with the angel and soldier engravings.");
                
                else if (angel && soldier && ! horse)
                    return rep.concat("the socket with the horse engraving.");
                
                else if (angel && ! soldier && horse)
                    return rep.concat("the socket with the soldier engraving.");
                
                else if (! angel && soldier && horse)
                    return rep.concat("the socket with the angel engraving."); 
                
            case 4:
                return "All of the door's medallions have been returned. The door is now unlocked.";
                
            default:
                return "The double doors here are locked tight. Four round "
                     + "sockets are built into the door's surface. One already "
                     + "contains a gold disk with an engraving of an angel on it. "
                     + "In the other three sockets you make out a second engraving "
                     + "of an angel, an engraving of a soldier, and an engraving "
                     + "of a horse.";
        }
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        if (this.numMedallions != 1)
            return "You can't seem to dig the medallions out by hand.";
        
        return "You can't seem to dig the disk out by hand.";
    } 
//-----------------------------------------------------------------------------
}
