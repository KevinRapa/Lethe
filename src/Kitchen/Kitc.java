package Kitchen;

import A_Main.AudioPlayer;
import A_Super.Room;

public class Kitc extends Room{
    private boolean isLit;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc(String name, String ID) {
        super(name, ID);
        this.isLit = false;
        this.description = "You have found the castle kitchen. This room's musty\n" +
                           "odor grows stronger near a pantry on the room's north \n" +
                           "end. A hearth for cooking sits in the room's center \n" +
                           "with pots hanging over it.  Aside the windows on the \n" +
                           "east wall is a shelf of wine and a couple open barrels. \n" +
                           "A counter extends along the west wall. Mounted on the \n" +
                           "south wall is the rack mentioned earlier by the \n" +
                           "apparition.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        if ((dir == 'n' || dir == 'e' || dir == 's') && ! this.isLit)
            return "It's too dark to see anything, and you don't want\n"
                 + "to trip and fall.";
        else {
            AudioPlayer.playEffect(6);
            return "There is a wall in the way.";
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! this.isLit) {
            rep = "This room is pitch black and fetid. All that's visible is an\n" +
                  "empty mounted holder on the wall next to you and a thin\n" +
                  "slitted window on the east end of the room.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public void swtch() {
        this.isLit = ! this.isLit;
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        String dialog = "You are " + this + ".";
        
        if (! this.isLit)
            dialog = "You are in a pitch black room.";
        
        return dialog;
    }
/*----------------------------------------------------------------------------*/
}
