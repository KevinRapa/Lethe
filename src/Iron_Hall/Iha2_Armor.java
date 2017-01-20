package Iron_Hall;

import A_Main.Id;
import A_Main.Inventory;
import static A_Main.NameConstants.POLEARM;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;

public class Iha2_Armor extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha2_Armor(Item... items) {
        super();
        this.searchable = false;
        this.inv = new Armor_Inventory(items);
        this.description = "It's a suit of armor holding a polearm. Its gauntlet\n"
                         + "is wrapped around it, but awkwardly as if the gauntlet\n"
                         + "had been pryed opened and then closed repeatedly.";
        this.searchDialog = "The suit of armor is holding a polearm, but its\n"
                          + "gauntlet is wrapped around it awkwardly.";
        this.actDialog = "You will probably get hurt trying to do that.";
        this.addActKeys("equip", "wear", "pry", "open");
        this.addNameKeys("(suit of |plate )?armor", "armor suit", "gauntlet");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        return this.containsItem(POLEARM) ? 
                this.description : "It's a suit of armor. It's gauntlets are empty.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        return this.searchable ? 
                "You look in the armor's gauntlet." : this.searchDialog; 
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches("wear|equip"))
            return this.actDialog;
        
        else if (! searchable) {
            this.searchable = true;
            return "You manage to pry the gauntlet open.";
        }
        else
            return "The gauntlet is already open.";
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
    private class Armor_Inventory extends Inventory {
        public Armor_Inventory(Item ... items) {
            super(items);
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) {
            this.CONTENTS.add(item);
            
            if (item.toString().equals(POLEARM))
                ((Iha2)Player.getRoomObj(Id.IHA2)).addPolearm();
                
            return true; // Some inventories have restrictions.
        }
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item removeThis) {      
            this.CONTENTS.remove(removeThis);
            
            if (removeThis.toString().equals(POLEARM))
                ((Iha2)Player.getRoomObj(Id.IHA2)).removePolearm();
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
}
