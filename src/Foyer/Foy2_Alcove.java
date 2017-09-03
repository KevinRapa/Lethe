package Foyer;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * Contains a statue hiding a button which switches gates in the foyer.
 * 
 * @see Foyer.Foy2_Lvr
 * @see Foyer.Foy_Gt
 * @see Foyer.Foy2_Stat
 * @author Kevin Rapa
 */
public class Foy2_Alcove extends Furniture{
    private final int STAT_ID;
//-----------------------------------------------------------------------------
    public Foy2_Alcove(Furniture foy2Stat) {
        super();
        this.STAT_ID = foy2Stat.getID();
        
        this.description = "A shallow domed alcove carved into the wall. "
                         + "A statue has been displayed inside of it.";
        this.searchDialog = "The large statue makes searching difficult. You "
                          + "can't seem to find anything.";
        
        this.addNameKeys("(?:shallow )?(?:domed )?alcove");
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {
        Foy2_Stat stat = (Foy2_Stat)Player.getRoomObj(Id.FOY2).getFurnRef(STAT_ID);
        
        return (! stat.moved()) ? this.description :         
           "A shallow domed alcove carved into the wall. Behind "
         + "the displaced statue is a small black button.";
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        Foy2_Stat stat = (Foy2_Stat)Player.getRoomObj(Id.FOY2).getFurnRef(STAT_ID);
        
        return (! stat.moved()) ? this.searchDialog :
            "With the statue moved, you see a small black button in the back.";
    }
//-----------------------------------------------------------------------------
}
