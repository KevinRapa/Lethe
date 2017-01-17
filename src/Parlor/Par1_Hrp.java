package Parlor;

import A_Super.Furniture;

public class Par1_Hrp extends Furniture {
    private final Par1_Orb REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par1_Hrp(Furniture orb) {
            super();
            this.searchable = false;
            this.addNameKeys("harp", "renaissance-era harp");
            this.description = "It's a renaissance-era harp. It looks gold plated,\n"
                             + "but you're no metallurgist. It sure does look\n"
                             + "tempting to play though.";
            this.REF = (Par1_Orb)orb;
            this.addActKeys("play", "strum");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {              
        if (! REF.woken()) {
            REF.wake();
            return "You slouch next to the harp and give it a jarring strum. Suddenly, you\n"
                 + "hear a nearby voice. \"Hey! Stop playing that, you'll break something!\"\n"
                 + "The voice is echoey, and you have a hunch it's emanating from the orb.";
        }
        else
            return "You sit down again and play some more notes. \"Stop playing\n"
                 + "that before you break it!\" The orb yells. \"I'm the only\n"
                 + "experienced musician in this castle!\"";
    }
/*----------------------------------------------------------------------------*/ 
}
