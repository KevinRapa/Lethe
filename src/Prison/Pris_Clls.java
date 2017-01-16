package Prison;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Openable;
import java.util.HashMap;
/**
 * @author Kevin Rapa
 */
public class Pris_Clls extends Furniture implements Openable{
    private final HashMap<String, Integer> MAP = new HashMap<>();
    // ========================================================================
    public Pris_Clls () {
        super();
        this.searchable = false;
        
        MAP.put("one", 1);   MAP.put("two", 2);   MAP.put("three", 3);
        MAP.put("four", 4);  MAP.put("five", 5);  MAP.put("six", 6);
        
        this.description = this.searchDialog = null;
        
        this.addNameKeys("(?:gated )?(?:prison )?cells?");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        GUI.out("There are 6 cells in this room. Each one is labeled with\n"
              + "a number. Inspect which one?");
        GUI.menOut("\n<#> Inspect");
        String ans = GUI.promptOut();
        
        while (! ans.matches("[1-6]|one|two|three|four|five|six")) {
            GUI.menOut("\nThat's not a valid choice.\n<#> Inspect");
            ans = GUI.promptOut();
        }
        
        if (ans.matches("[a-z]+"))
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


