package Rotunda;

import A_Main.AudioPlayer;
import A_Main.Player;
import A_Super.Room;

public class Rotu extends Room{
    private String state;

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu(String name, String ID) {
        super(name, ID);
        description = "You are in a symmetrical dome-shaped chamber. Everything\n" +
                      "is ornate and carved from polished rock. A fountain in the \n" +
                      "center serves as a focus. At each diagonal below a spherical\n" +
                      "sconce is a glaring statue projecting from the wall. Various\n" +
                      "potted plants decorate the room. Looking straight up, there's\n" +
                      "a hole in the ceiling giving view to the sky. Only a single\n" +
                      "other door on the opposite side is apparent. At the perpendicular\n" +
                      "ends are peculiar arched frames carved into the wall. Your\n" +
                      "only complaint is that this room smells quite awful.";
        this.state = "EW";
    }
/*----------------------------------------------------------------------------*/
    public void rotate() {
        AudioPlayer.playEffect(18);
        
        if (this.state.matches("EW")) {
            this.addAdjacent("STUD");
            this.addAdjacent("IHA1"); 
            this.removeAdjacent("FOYW");
            this.removeAdjacent("LOOK");
            Player.getMapRef()[3][3][4].removeAdjacent("ROTU");
            this.state = "NS";
        }
        else if (this.state.matches("NS")) {
            this.addAdjacent("FOYW");
            this.addAdjacent("LOOK"); 
            this.removeAdjacent("STUD");
            this.removeAdjacent("IHA1");
            Player.getMapRef()[3][3][4].addAdjacent("ROTU");
            this.state = "EW"; 
        }    
    }
/*----------------------------------------------------------------------------*/        
    public String getState() {
        return this.state;
    }
/*----------------------------------------------------------------------------*/   
}
