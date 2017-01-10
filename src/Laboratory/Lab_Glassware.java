package Laboratory;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
abstract public class Lab_Glassware extends Furniture {
    // ========================================================================
    public Lab_Glassware () {
        super();

        this.inv = new Lab_Inventory();
        
        this.searchDialog = "Here's what you've added.";

        this.addUseKeys(".+"); // Anything can be used on this, but it must be of type "ingredient".
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        Player.getInv().give(item, this.inv);
        return "none";
    }
    // ========================================================================    
    // ************************************************************************
    // ========================================================================    
    private class Lab_Inventory extends Inventory {
        // ==========================================
        public Lab_Inventory(Item ... items) {
            super(items);
        }
        // ==========================================
        @Override public boolean add(Item item) {
            if (item.getType().equals("ingredient")) {
                GUI.out("You pour it in.");
                this.CONTENTS.add(item);
                return true;
            }
            GUI.out("That's not an ingredient.");
            return false;
        }
        // ==========================================
        @Override public void give(Item item, Inventory giveToThis) {
            if (item.toString().equals("gray residue")) {
                this.remove(item);
                giveToThis.add(item);
            }
            else
                GUI.out("The ingredients are in solution. You can't take it back out.");
        }
        // ==========================================
    }    
    // ========================================================================     
}


