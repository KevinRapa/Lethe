package Prison;

import A_Main.GUI;
import A_Main.Id;
import static A_Main.Names.NL;
import static A_Main.Patterns.ONE_TO_SIX;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Openable;
import A_Super.Unmoveable;
/**
 * These can be searched to discover the solution to the Sew2 valve puzzle.
 * 
 * @see Tunnels.Sew2_Valves
 * @author Kevin Rapa
 */
public class Pris_Cells extends Furniture implements Openable, Unmoveable {
    // ========================================================================
    public Pris_Cells () {
        super();
        
        this.addNameKeys("(?:gated )?(?:prison )?cells?");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        GUI.out("There are 6 cells in this room. Each one is labeled with "
              + "a number. Inspect which one?");
        
        String ans = GUI.askChoice(NL + "<#> Inspect", ONE_TO_SIX);
        
        return ((Pris)Player.getRoomObj(Id.PRIS))
                .getCellDescription(Integer.parseInt(ans));
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================       
}


