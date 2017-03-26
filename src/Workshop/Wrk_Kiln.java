package Workshop;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.*;
import A_Super.Item;
import A_Main.Player;
import A_Super.Liquid;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * Used to create molten glass with dye, sand, and potash.
 * Player must go back to the closet to get sand.
 * 
 * @see Closet.Clos
 * @author Kevin Rapa
 */
public class Wrk_Kiln extends SearchableFurniture implements Openable, Unmoveable {
    private final Item REFGLSSR, REFGLSSB, REFGLSSY;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_Kiln() {
        super();
        
        this.inv = new KilnInventory();
        
        this.REFGLSSR = new Liquid(MOLTEN_RED_GLASS, 
                "It's a crucible of molten red glass. Be careful!", -5);
        this.REFGLSSB = new Liquid(MOLTEN_BLUE_GLASS, 
                "It's a crucible of molten blue glass. Be careful!", -5);
        this.REFGLSSY = new Liquid(MOLTEN_YELLOW_GLASS, 
                "It's a crucible of molten yellow glass. Be careful!", -5);
       
        this.actDialog = "No need to take that. Just add stuff and watch the magic happen.";
        this.searchDialog = "You look in the kiln. It's pretty toasty in there.";
        this.description = "The kiln resembles a ceramic oven. Its intense heat " +
                           "keeps this room roasting hot. Inside is a small ceramic "
                         + "crucible sitting on a metal rack.";
        
        this.addActKeys(GETPATTERN);
        this.addUseKeys(RED_DYE, YELLOW_DYE, BLUE_DYE, SAND, POTASH);
        this.addNameKeys("(?:ceramic )?(?:oven|kiln|crucible)", "(?:metal )?rack");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        // Cannot use Player.getInv().give() here because the molten glass
        // Can be added to player inventory before removing the item.
        // Must remove the item FIRST.
        Player.getInv().remove(item);
        this.inv.add(item);
        
        return NOTHING;
    }
/*----------------------------------------------------------------------------*/
    private String makeGlass() {
        if (this.containsItem(RED_DYE)) 
            Player.getInv().add(REFGLSSR);
        else if (this.containsItem(BLUE_DYE)) 
            Player.getInv().add(REFGLSSB);
        else 
            Player.getInv().add(REFGLSSY);
        
        this.inv.clear();
        
        return " You let the sand and the dye bake for a bit. In no "
             + "time, the mixture has blended into hot molten glass. "
             + "Delicious! You take the hot crucible of liquid glass.";
    }
/*----------------------------------------------------------------------------*/
    private boolean hasDye() {
        return (containsItem(RED_DYE) || containsItem(BLUE_DYE) || containsItem(YELLOW_DYE));
    }
/*----------------------------------------------------------------------------*/
    private boolean check() {
        return hasDye() && containsItem(POTASH) && containsItem(SAND);
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
    private class KilnInventory extends Inventory {  
    // CONSTRUCTOR -------------------------------------------------------------      
        public KilnInventory() {
            super();
        }
    /*------------------------------------------------------------------------*/
        @Override public boolean add(Item item) { 
            String n = item.toString();
            
            if (! (n.equals(RED_DYE) || n.equals(BLUE_DYE) || n.equals(YELLOW_DYE)
                || n.equals(SAND)    || n.equals(POTASH))
                ) 
            {
                if (n.equals(MOLTEN_RED_GLASS) || n.equals(MOLTEN_BLUE_GLASS) || n.equals(MOLTEN_YELLOW_GLASS))
                    GUI.out("Is it... really not hot enough for you??");
                else
                    GUI.out("You're fairly sure the professionals don't put things like that into kilns.");
            }
            else if (this.size() < 3 && (
                (n.equals(RED_DYE)    && ! containsItem(RED_DYE))    ||
                (n.equals(BLUE_DYE)   && ! containsItem(BLUE_DYE))   ||
                (n.equals(YELLOW_DYE) && ! containsItem(YELLOW_DYE)) ||
                (n.equals(SAND)       && ! containsItem(SAND))       ||
                (n.equals(POTASH)     && ! containsItem(POTASH)))
                    )
            {
                String result = "You pour it in.";
                this.CONTENTS.add(item);
                
                if (check())
                    result += makeGlass();
                
                GUI.out(result);
                return true;
            }
            else if (this.size() == 3) 
                GUI.out("The crucible is full to the brim.");
            else 
                GUI.out("The kiln already has that in it.");
            
            return false;
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
}
