package Iron_Hall;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.NameConstants.POLEARM;
import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;

public class Iha2_Armor extends SearchableFurniture implements Gettable, Moveable {
    private final Item PLRM_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha2_Armor(Item plrm) {
        super();

        this.PLRM_REF = plrm;
        this.searchable = false;
        this.inv = new Armor_Inventory(plrm);
        this.description = "It's a suit of armor holding a polearm. Its gauntlet\n"
                         + "is wrapped around it, but awkwardly as if the gauntlet\n"
                         + "had been pryed opened and then closed repeatedly.";
        this.searchDialog = "The suit of armor is holding a polearm, but its\n"
                          + "gauntlet is wrapped around it awkwardly.";
        this.actDialog = "You will probably get hurt trying to do that.";
        
        this.addActKeys("equip|wear", "pry|open", GETPATTERN);
        this.addNameKeys("(?:suit (?:of )?|plate )?armor", POLEARM, 
                "(?:armor )?suit|gauntlet|hand");
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
        if (key.equals("equip") || key.equals("wear"))
            return this.actDialog;
        
        else if (key.equals("pry") || key.equals("open")) {
            if (! this.searchable) {
                this.searchable = true;
                return "You manage to pry the gauntlet open.";
            }
            else
                return "The gauntlet is already open.";
        }
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        if (! this.containsItem(POLEARM))
            return "The suit of armor isn't holding a polearm anymore.";
        
        else if (this.searchable) {
            if (this.inv.give(PLRM_REF, Player.getInv()))
                return "You slide the weapon from the suit's gauntlet.";
            else
                return null;
        }
        else
            return this.searchDialog;
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
            if (this.size() == 0 && item.toString().equals(POLEARM)) {
                this.CONTENTS.add(item);
                ((Iha2)Player.getPos()).addPolearm();
                return true; // Only polearms may be added to this.
            }
            
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item removeThis) {  
            // Item must be a polearm.
            this.CONTENTS.remove(removeThis);
            ((Iha2)Player.getPos()).removePolearm();
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
}
