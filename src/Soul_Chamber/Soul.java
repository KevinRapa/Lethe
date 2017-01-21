package Soul_Chamber;

import A_Main.GUI;
import A_Main.Id;
import A_Main.NameConstants;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Room;
import Lichs_Quarters.Lich_Room;
/**
 * @author Kevin Rapa
 */
public class Soul extends Room {
    private final Room[] LICH_RMS;
    private final Furniture SPHERE;
// ============================================================================    
    public Soul(String name, String ID, Furniture sphere, Room ... lichRms) {
        super(name, ID);
        
        this.LICH_RMS = lichRms;
        this.SPHERE = sphere;
        
        this.description= "You have reached the apex point of the castle; a\n" +
                          "single chamber suspended high above the sea. The\n" +
                          "tall room is arched at the top. Four tall statues\n" +
                          "stand at each corner staring down into a pool of\n" +
                          "aether in the center. A tall stained-glass window\n" +
                          "covers the north wall.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.getID())) {
            GUI.roomOut(STD_RM_OUT);
            GUI.menOut("Press enter...");
            GUI.out("You stand before a pool of glowing aether, the very substance\n"
                  + "which frees the dead of their earthly bodies.");
            GUI.promptOut();
            
            GUI.out("You remove the five phylacteries you have collected and\n"
                  + "stand quietly before the pool.");
            GUI.promptOut();
            
            removePhylacteries();
            GUI.out("A short moment passes, and you cast the five objects into\n"
                  + "the pool. At that moment, the feeling of burden and dread\n"
                  + "leaves you, and you feel comfortably alone. A burst of light\n"
                  + "emerges from the pool and then disperses.");
            GUI.promptOut();
            GUI.toMainMenu();
            
            for (Room r : this.LICH_RMS)
                ((Lich_Room)r).killLich();
            
            Player.getRoomObj(Id.LQU1).addAdjacent(Id.LQU2);
            
            Player.getRoomObj(Id.TOW1).removeFurniture(SPHERE);
            Player.getRoomObj(Id.TOW2).removeFurniture(SPHERE);
            
            // Closes off areas to direct player out and avoid conflictions with night and day.
            Player.getRoomObj(Id.FOYC).removeAdjacent(Id.GAL1);
            Player.getRoomObj(Id.FOY3).removeAdjacent(Id.PAR2);
            Player.getRoomObj(Id.IHA2).removeAdjacent(Id.WOW2);
            Player.getRoomObj(Id.FOY1).removeAdjacent(Id.VEST);
        }
        return STD_RM_OUT;
    }
// ============================================================================
    private void removePhylacteries() {
        Player.getInv().remove(NameConstants.PHYLACTERY);
        Player.printInv();
    }
// ============================================================================    
}
