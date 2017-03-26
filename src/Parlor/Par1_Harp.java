package Parlor;

import A_Main.AudioPlayer;
import A_Super.Furniture;
import A_Super.Moveable;
/**
 * Wakes up the orb NPC if played.
 * 
 * @see Parlor.Par1_Orb
 * @author Kevin Rapa
 */
public class Par1_Harp extends Furniture implements Moveable {
    private final Par1_Orb REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par1_Harp(Furniture orb) {
            super();

            this.addNameKeys("harp", "renaissance-era harp");
            this.description = "It's a renaissance-era harp. It looks gold plated, "
                             + "but you're no metallurgist. It sure does look "
                             + "tempting to play though.";
            this.REF = (Par1_Orb)orb;
            this.addActKeys("play", "strum");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {              
        if (! REF.woken()) {
            AudioPlayer.playEffect(54);
            REF.wake();
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
/*----------------------------------------------------------------------------*/ 
}
