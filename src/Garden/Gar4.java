package Garden;

/**
 * @author Kevin Rapa
 */
import A_Main.AudioPlayer;
import A_Super.Room;

public class Gar4 extends Room {
// ============================================================================    
    public Gar4(String name, String ID) {
        super(name, ID);
        this.description= "You're at the southeast quarter of the garden. Before\n" +
                          "you on the south wall is a closed door. Lining the\n" +
                          "west wall is a planter containing nothing but a\n" +
                          "clean bed of soil and a stone plaque on the right\n" +
                          "side. A black sconce above the planter lights the\n" +
                          "area.";
    }
// ============================================================================
    @Override public String getBarrier(char dir) {
        AudioPlayer.playEffect(6);
        
        if (dir == 's')
            return "The door here budges only a little. Something is blocking it\n"
                 + "from the other side.";
        
        return "There is a wall in the way";
    }
// ============================================================================
}