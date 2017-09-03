package Parlor;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Moveable;
/**
 * Wakes up the orb NPC if played.
 * 
 * @see Parlor.Par1_Orb
 * @author Kevin Rapa
 */
public class Par1_Harp extends Furniture implements Moveable {
    private final int ORB_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par1_Harp(Furniture orb) {
            super();

            this.addNameKeys("harp", "renaissance-era harp");
            this.description = "It's a renaissance-era harp. It looks gold plated, "
                             + "but you're no metallurgist. It sure does look "
                             + "tempting to play though.";
            this.ORB_ID = orb.getID();
            this.addActKeys("play", "strum");
    }
//----------------------------------------------------------------------------- 
    @Override public String interact(String key) {       
        Par1_Orb o = (Par1_Orb)Player.getRoomObj(Id.PAR1).getFurnRef(ORB_ID);
        
        if (! o.woken()) {
            AudioPlayer.playEffect(54);
            o.wake();
            return "You slouch next to the harp and give it a jarring strum. Suddenly, you "
                 + "hear a nearby voice. \"Hey! Stop playing that, you'll break something!\" "
                 + "The voice is echoey, and you have a hunch it's emanating from the orb.";
        }
        else {
            AudioPlayer.playEffect(54);
            return "You sit down again and play some more notes. \"Stop playing "
                 + "that before you break it!\" The orb yells. \"I'm the only "
                 + "experienced musician in this castle!\"";
        }
    }
//----------------------------------------------------------------------------- 
}
