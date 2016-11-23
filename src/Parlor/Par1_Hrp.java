package Parlor;

import Super.Furniture;
import Super.Room;

public class Par1_Hrp extends Furniture {
    private final Par1_Orb REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par1_Hrp(String NAME, Furniture orb) {
            super(NAME);
            this.searchable = false;
            this.addNameKeys("harp");
            this.description = "It's a renaissance-era harp. It looks gold plated,\n"
                             + "but you're no metallurgist. It sure does look\n"
                             + "tempting to play though.";
            this.searchDialog = "You look under the piano's cover.";
            this.REF = (Par1_Orb) orb;
            this.addActKeys("play", "strum");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(Room[][][] map, String key) {              
        String rep;
        
        if (! REF.woken()) {
            rep = "You slouch next to the harp and give it a jarring strum. Suddenly, you\n"
                + "hear a nearby voice. \"Hey! Stop playing that, you'll break something!\"\n"
                + "The voice is echoey, and have a hunch it's emanating from the orb.";
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
