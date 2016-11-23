package Parlor;

import Super.Furniture;
import Super.Item;
import Super.Room;

public class Par2_Pno extends Furniture {
    private final Par1_Orb REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par2_Pno(String NAME, Furniture orb, Item ... items) {
            super(NAME, items);
            this.addNameKeys("piano", "grand piano");
            this.description = "The black grand piano sits solemnly on the loft\n"
                             + "extension. You're surprised anybody here has time\n"
                             + "for music!";
            this.searchDialog = "You look under the piano's cover.";
            this.REF = (Par1_Orb) orb;
            this.addActKeys("play");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(Room[][][] map, String key) {              
        String rep;
        
        if (! REF.woken()) {
            rep = "You sit at the piano and produce a few notes. Suddenly, you\n"
                + "hear a voice from down below. \"Hey! Who is playing my piano?\"\n"
                + "The voice is echoey, and have a hunch it's emanating from the\n"
                + "orb below.";
            REF.wake();
        }
        else
            rep = "You sit down again and play some more notes. \"Stop playing\n"
                + "that before you break it!\" The orb yells. \"I'm the only\n"
                + "qualified musician in this castle!\"";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
}
