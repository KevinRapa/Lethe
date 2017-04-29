package Tower;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.DAMPENING_STAFF;
import static A_Main.Names.GLOWING_SCEPTER;
import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Contains the scepter phylactery- player must have the dampening staff to obtain
 * this.
 * 
 * @author Kevin Rapa
 */
public class Tow1_Pedestal extends SearchableFurniture {
    //-------------------------------------------------------------------------
    public Tow1_Pedestal (Item... items) {
        super();
        
        this.inv = new Pedestal_Inventory(items);
        this.searchable = false;
        
        this.description = "It's a solid gray stone platform with two "
                         + "brass extensions on the top.";
        this.searchDialog = "You try to approach the pedestal, but some sort of repelling force is preventing you.";
        this.useDialog = "You naively wave the staff in an arbitrary pattern. Nothing happens.";

        this.addNameKeys("(?:solid )?(?:gray )?(?:stone )?(?:pedestal|platform)", 
                "(?:silver )?(?:glowing )?(?:object|scepter)", "(?:brass )?extensions?");
        this.addUseKeys(DAMPENING_STAFF);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return this.containsItem(GLOWING_SCEPTER) ?
            this.description.concat(" The extensions support a silver glowing object.") :
            this.description;
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        this.searchable = Player.hasItem(DAMPENING_STAFF);
        
        return this.searchable ? "You approach the pedestal" : this.searchDialog;
    }
    //-------------------------------------------------------------------------    
    // ************************************************************************
    //-------------------------------------------------------------------------  
    private class Pedestal_Inventory extends Inventory {
        public Pedestal_Inventory(Item... items) {
            super(items);
        }
        @Override public boolean add(Item item) {
            if (! item.toString().equals(DAMPENING_STAFF)) 
                GUI.out("You may not want to leave that there, unless you never want it back.");
            
            this.CONTENTS.add(item);
            return true;
        }
    }
    //-------------------------------------------------------------------------    
    // ************************************************************************
    //-------------------------------------------------------------------------
}


