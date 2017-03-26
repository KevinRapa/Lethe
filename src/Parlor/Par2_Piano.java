package Parlor;

import static A_Main.Names.STEEL_WIRE;
import A_Main.AudioPlayer;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * Wakes up the orb NPC if played.
 * 
 * @see Parlor.Par1_Orb
 * @author Kevin Rapa
 */
public class Par2_Piano extends SearchableFurniture 
        implements Openable, Unmoveable 
{
    private final Par1_Orb REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par2_Piano(Furniture orb, Item... items) {
        super(items);
        
        this.description = "The black grand piano sits solemnly on the loft "
                         + "extension. You're surprised anybody here has time "
                         + "for music!";
        
        this.useDialog = "You have little knowledge of musical instruments, much less in instrument repair."; 
        this.searchDialog = "You look under the piano's cover.";
        this.REF = (Par1_Orb) orb;
        
        this.addNameKeys("(?:black )?(?:grand )?piano", "(?:piano )?keys?");
        this.addUseKeys(STEEL_WIRE);
        this.addActKeys("play", "press");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {              
        if (! REF.woken()) {
            AudioPlayer.playEffect(53);
            REF.wake();
            return "You sit at the piano and produce a few notes. Suddenly, you "
                 + "hear a voice from down below. \"Hey! Who is playing my piano?\" "
                 + "The voice is echoey, and you have a hunch it's emanating from the "
                 + "orb below.";
            
        }
        else {
            AudioPlayer.playEffect(53);
            return "You sit down again and play some more notes. \"Stop playing "
                 + "that before you break it!\" The orb yells. \"I'm the only "
                 + "experienced musician in this castle!\"";
        }
    }
/*----------------------------------------------------------------------------*/ 
}
