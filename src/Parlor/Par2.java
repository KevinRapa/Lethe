package Parlor;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Super.Room;
import A_Main.Player;

public class Par2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par2(String name, String ID) {
        super(name, ID);
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
    @Override public String triggeredEvent() {
        String dialog = "You are " + this + ".";
        
        if (! Player.hasVisited("PAR1")) {
            AudioPlayer.playEffect(8);
            GUI.out("After stepping into the room, the door slams shut behind you.\n"
                  + "Startled, you spin around and miss a breath. You are alone.");
            Player.getMapRef()[2][2][5].lock();
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
