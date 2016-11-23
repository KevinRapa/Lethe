package Marble_Hall;

import Super.Furniture;
import Super.Room;
import Core.Inventory;
import Super.Item;

public class MhaM_Dr extends Furniture {
    private int numMedallions;
    private boolean angel, soldier, horse;
    private final Room REF;
    private final Inventory REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public MhaM_Dr (String NAME, Room din, Inventory inv) {
        super(NAME);
        this.REF = din;
        this.REF2 = inv;
        this.searchable = false;
        this.angel = false; this.soldier = false; this.horse = false; // Slots
        this.numMedallions = 1;
        this.interactDialog = "It seems as thought one does not simply open this door.";
        this.addNameKeys("door", "doors", "double doors");
        this.addActKeys("open", "use");
        this.addUseKeys("stone disk", "angel medallion", "horse medallion");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = "You press the " + item + " into its socket.";
        
        if (item.toString().matches("stone disk"))
            this.soldier = true;
        else if (item.toString().matches("angel medallion"))
            this.angel = true;
        else if (item.toString().matches("horse medallion"))
            this.horse = true;
        
        REF2.remove(item);
        this.numMedallions ++;
        
        if (this.numMedallions == 4) {
            REF.unlock();
            rep += "\nWith the last medallion in place, the door *clicks* loudly.";
        }      
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {    
        String rep = "The double doors here are locked tight. Four round\n"
                   + "sockets on are built into the door's surface. One already\n"
                   + "contains a gold disk with an engraving of an angel on it.\n"
                   + "In the other three sockets you make out a second engraving\n"
                   + "of an angel, an engraving of a soldier, and an engraving\n"
                   + "of a horse.";
        
        if (this.numMedallions != 1 && this.numMedallions != 4) {
            rep = "The doors remain locked. " + (4 - this.numMedallions) + " of the sockets remain empty;";
            
            if (this.numMedallions == 3) {
                rep = "The doors remain locked. 1 socket remains empty.";
            }
            if (this.angel && ! this.soldier && ! this.horse) {
                rep += "\nthe sockets with the soldier and horse engravings.";
            }
            else if (! this.angel && this.soldier && ! this.horse) {
                rep += "\nthe sockets with the angel and horse engravings.";
            }
            else if (! this.angel && ! this.soldier && this.horse) {
                rep += "\nthe sockets with the angel and soldier engravings.";
            }
            else if (this.angel && this.soldier && ! this.horse) {
                rep += "\nThe socket with the horse engraving.\n"
                     + "remain empty."; 
            }
            else if (this.angel && ! this.soldier && this.horse) {
                rep += "\nThe socket with the soldier engraving."; 
            }
            else if (! this.angel && this.soldier && this.horse) {
                rep += "\nThe socket with the angel engraving."; 
            }
        }     
        else if (this.numMedallions == 4) {
            rep = "All of the door's medallions have been returned. The door is\n"
                + "now unlocked."; 
        }
      
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = "You can't seem to dig the disk out by hand.";
        
        if (this.numMedallions != 1)
            rep = "You can't seem to dig the medallions out by hand.";
        
        return rep;
    } 
/*----------------------------------------------------------------------------*/
}
