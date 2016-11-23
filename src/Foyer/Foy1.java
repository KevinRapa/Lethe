package Foyer;

import Super.Room;

public class Foy1 extends Room{
    private final Room REF; 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy1(String name, String ID, Room want) {
        super(name, ID);
        this.REF = want;       
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        description = "The huge dim foyer is sparsely furnished and strangely\n"
                    + "clean. Despite the openness, you feel claustrophobic. A\n"
                    + "red carpet is neatly layed out in the center. The room's\n"
                    + "white marble wall and orange tile floor are polished. To\n"
                    + "your west, " + this.descMode() + "\n"
                    + "To your east, a heavy wooden door leads somewhere else.\n"
                    + "A long wood table sits in the room's center under a huge\n"
                    + "chandelier. You can see that this room extends further\n"
                    + "north to a curved staircase at the other end.";
        
        return description;
    }   
/*----------------------------------------------------------------------------*/
    private String descMode() {       
        String mode = this.REF.isThisLocked() ? "a closed gate blocks your way into another room." : 
                                                "an opened gate leads into another room.";                                            
        return mode;
    }    
/*----------------------------------------------------------------------------*/
}

