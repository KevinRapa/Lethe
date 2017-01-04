package Iron_Hall;

import A_Super.Furniture;
import A_Super.Item;

public class Iha2_Armr extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha2_Armr(Item... items) {
        super(items);
        this.searchable = false;
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
        return this.doesThisHaveIt("polearm") ? 
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
}
