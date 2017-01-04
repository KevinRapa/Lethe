package Rotunda;

import A_Main.AudioPlayer;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;
import A_Super.Furniture;

public class Rotu extends Room {
    private char state;
    private final Furniture NDOOR, SDOOR, EDOOR, WDOOR; 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu(String name, String ID) {
        super(name, ID);
        
        this.NDOOR = new Rotu_Dr(Direction.NORTH);
        this.SDOOR = new Rotu_Dr(Direction.SOUTH);
        this.EDOOR = new Rotu_Dr(Direction.EAST);
        this.WDOOR = new Rotu_Dr(Direction.NORTH);
        
        this.addFurniture(WDOOR, EDOOR);
        
        description = "You are in a symmetrical dome-shaped chamber. Everything\n" +
                      "is ornate and carved from polished rock. A fountain in the \n" +
                      "center serves as a focus. At each diagonal below a spherical\n" +
                      "sconce is a glaring statue projecting from the wall. Various\n" +
                      "potted plants decorate the room. Looking straight up, there's\n" +
                      "a hole in the ceiling giving view to the sky. Only a single\n" +
                      "other door on the opposite side is apparent. At the perpendicular\n" +
                      "ends are peculiar arched frames carved into the wall. Your\n" +
                      "only complaint is that this room smells quite awful.";
        this.state = 'e';
    }
/*----------------------------------------------------------------------------*/
    public void rotate() {
        AudioPlayer.playEffect(18);
        
        if (this.state == 'e') {
            this.addAdjacent("STUD");
            this.addAdjacent("IHA1"); 
            this.removeAdjacent("FOYW");
            this.removeAdjacent("LOOK");
            
            this.removeFurniture(EDOOR);
            this.removeFurniture(WDOOR);
            this.addFurniture(NDOOR);
            this.addFurniture(SDOOR);
            Player.getRoomRef("FOYW").removeAdjacent("ROTU");
            this.state = 'n';
        }
        else if (this.state == 'n') {
            this.addAdjacent("FOYW");
            this.addAdjacent("LOOK"); 
            this.removeAdjacent("STUD");
            this.removeAdjacent("IHA1");
            
            this.removeFurniture(NDOOR);
            this.removeFurniture(SDOOR);
            this.addFurniture(EDOOR);
            this.addFurniture(WDOOR);
            Player.getRoomRef("FOYW").addAdjacent("ROTU");
            this.state = 'e'; 
        }    
    }
/*----------------------------------------------------------------------------*/        
    public char getState() {
        return this.state;
    }
/*----------------------------------------------------------------------------*/   
}
