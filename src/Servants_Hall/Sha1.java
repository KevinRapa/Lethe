package Servants_Hall;

import Super.Room;

public class Sha1 extends Room{
    
    public Sha1(String name, String ID) {
        super(name, ID);
        this.description = "You're on the south end of a short dark hallway.\n" +
                           "To your west is a small door with the doorknob\n" +
                           "broken off. Some torches on the wall dimly light the\n" +
                           "hallway. Looking to the north, there's another door\n" +
                           "on the left side further down the hallway.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        
        if (dir == 'a')
            rep = "This door's knob is missing.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String getDescription() {
        String rep = this.description;
        if (! this.hasFurniture("door"))
            rep = "You're on the south end of a short dark hallway.\n" +
                  "To your west is a doorway to the next room over. A\n" +
                  "torch on the wall dimly lights the hallway. Looking\n" +
                  "to the north, there's another door on the left side\n" +
                  "further down the hallway.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/ 
}
