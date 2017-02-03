package Prison;

import A_Main.GUI;
import A_Main.Id;
import static A_Main.Patterns.WORD;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Openable;
import java.util.HashMap;
/**
 * These can be searched to discover the solution to the Sew2 valve puzzle.
 * 
 * @see Tunnels.Sew2_Valves
 * @author Kevin Rapa
 */
public class Pris_Cells extends Furniture implements Openable{
    private final HashMap<String, Integer> MAP = new HashMap<>();
    // ========================================================================
    public Pris_Cells () {
        super();
        
        MAP.put("one", 1);   MAP.put("two", 2);   MAP.put("three", 3);
        MAP.put("four", 4);  MAP.put("five", 5);  MAP.put("six", 6);
        
        this.description = this.searchDialog = null;
        
        this.addNameKeys("(?:gated )?(?:prison )?cells?");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        GUI.out("There are 6 cells in this room. Each one is labeled with\n"
              + "a number. Inspect which one?");
        
        String ans = GUI.askChoice("\n<#> Inspect", "[1-6]|one|two|three|four|five|six");
        
        if (WORD.matcher(ans).matches())
            return ((Pris)Player.getRoomObj(Id.PRIS))
                    .getCellDescription(MAP.get(ans));
        else
            return ((Pris)Player.getRoomObj(Id.PRIS))
                    .getCellDescription(Integer.parseInt(ans));
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================       
}


