package Parlor;

import A_Main.AudioPlayer;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;

public class Par2_Piano extends Furniture implements Openable {
    private final Par1_Orb REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par2_Piano(Furniture orb, Item... items) {
        super(items);
        this.addNameKeys("(?:black )?(?:grand )?piano");
        this.description = "The black grand piano sits solemnly on the loft\n"
                         + "extension. You're surprised anybody here has time\n"
                         + "for music!";
        this.searchDialog = "You look under the piano's cover.";
        this.REF = (Par1_Orb) orb;
        this.addActKeys("play");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {              
        if (! REF.woken()) {
            AudioPlayer.playEffect(53);
            REF.wake();
            return "You sit at the piano and produce a few notes. Suddenly, you\n"
                 + "hear a voice from down below. \"Hey! Who is playing my piano?\"\n"
                 + "The voice is echoey, and have a hunch it's emanating from the\n"
                 + "orb below.";
            
        }
        else {
            AudioPlayer.playEffect(53);
            return "You sit down again and play some more notes. \"Stop playing\n"
                 + "that before you break it!\" The orb yells. \"I'm the only\n"
                 + "experienced musician in this castle!\"";
        }
    }
/*----------------------------------------------------------------------------*/ 
}
