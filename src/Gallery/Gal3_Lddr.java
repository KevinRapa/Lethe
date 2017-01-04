package Gallery;

import A_Main.AudioPlayer;
import A_Main.Player;
import A_Super.Staircase;
import A_Main.GUI;
import A_Super.Direction;

public class Gal3_Lddr extends Staircase {
    private boolean lowered;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Lddr(Direction direction, int height) {
        super(direction, height);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder is suspended above the ground in the\n"
                         + "hatch, too high to grab hold of.";
        this.lowered = false;
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder");
    }
/*----------------------------------------------------------------------------*/     
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.lowered) {
            rep = "With the rope cut, the ladder now gives way to the\n"
                + "gallery loft.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public void lower() {
        this.lowered = true;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        String rep;
        
        if (this.lowered) {
            // Sets the room that the player is in.
            int[] c = Player.getPos().getCoords(); // coordinates of player location.
            int Z = c[0]; int Y = c[1]; int X = c[2]; //Individual ZYX coordinates.
                
            playEffect();
            Player.setOccupies(Z + DIR.Z, Y, X); // moves the player's Z coordinate.
        
            rep = "You climb the ladder.";       
           
            GUI.roomOut(Player.getPos().triggeredEvent());
        }
        else
            rep = "The ladder is too high up to climb.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(16);
    }
}
