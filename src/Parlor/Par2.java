package Parlor;

import Main.AudioPlayer;
import Main.GUI;
import Super.Room;
import Main.Player;

public class Par2 extends Room{
    private final Player REF;
    private final Room REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par2(String name, String ID, Player plyr, Room foy3) {
        super(name, ID);
        this.REF = plyr;
        this.REF2 = foy3;
        description= "You stand on a second-floor loft bowing over a parlor.\n"
                   + "A thin flight of steps leads down to the first level.\n"
                   + "The room is cast in a warm glow from a hanging bowl of fire\n"
                   + "helped by a burning fireplace below. This room resembles\n"
                   + "the old west wing, with sandstone walls\n"
                   + "and floors. The\n"
                   + "loft is mostly bare save a piano sitting on an extension\n"
                   + "of the balcony. A couple barred windows to the north on\n"
                   + "opposite sides of a bookshelf give view outside. To the\n"
                   + "west, another door leads further into the castle depths.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! this.isAdjacent("JHA1"))
            rep += " Though, there is something odd about this door.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent(Room[][][] map) {
        String dialog = "You are " + this + ".";
        
        if (! REF.hasVisited("PAR1")) {
            AudioPlayer.playEffect(8);
            GUI.out("After stepping into the room, the door slams shut behind you.\n"
                  + "Startled, you spin around and miss a breath. You are alone.");
            REF2.lock();
        }    
        return dialog;
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        
        if (dir == 's')
            rep = "There's nothing but a railing and open space over the lower\n"
                + "level parlor.";
                
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
}
