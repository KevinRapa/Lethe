package Soul_Chamber;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Menus;
import static A_Main.Names.PHYLACTERY;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Room;
import Lichs_Quarters.Lich_Room;
/**
 * @author Kevin Rapa
 */
public class Soul_Pool extends Furniture {
    private final Room[] LICH_RMS;
    private final Furniture SPHERE;
    private int numPhylacteries;
    // ========================================================================
    public Soul_Pool (Furniture sphere, Room ... lichRms) {
        super();
        
        this.LICH_RMS = lichRms;
        this.SPHERE = sphere;
        this.numPhylacteries = 0;
        
        this.description = "The pool of aether swirls with white... stuff, and "
                         + "gently bubbles infrequently. The blue liquid inside "
                         + "is opaque, but can't be more than a couple feet deep.";
        this.actDialog = "You leap into the pool and die. The end. No, not really.";
        this.searchDialog = "You just find a bunch of aether.";

        this.addNameKeys("pool", "pool of aether", "aether pool");
        this.addUseKeys(ANYTHING);
        this.addActKeys("swim");
    }
    // ========================================================================
    @Override public String useEvent(Item item) {
        Player.getInv().remove(item);
        
        if (item.getType().equals(PHYLACTERY)) {
            this.numPhylacteries++;
            
            if (this.numPhylacteries == 5) {
                killLich();
                return NOTHING;
            }
        } 
        
        return "You toss the " + item + " into the glowing pool. The water bubbles "
             + "and a luminenscent gas escapes from the pool's surface.";
    }
    // ========================================================================    
    private void killLich() {    
        GUI.menOut(Menus.ENTER);
        GUI.out("You stand before a pool of glowing aether, the very substance "
              + "which frees the dead of their earthly bodies.");
        GUI.promptOut();

        GUI.out("A short moment passes, and you cast the final phylactery "
              + "the pool. At that moment, the feeling of burden and dread "
              + "leaves you, and you feel comfortably alone. A burst of light "
              + "emerges from the pool and then disperses. The throbbing in your head ceases.");
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
    // ========================================================================
}


