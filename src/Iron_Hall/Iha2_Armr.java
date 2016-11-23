package Iron_Hall;

import Super.Furniture;
import Super.Item;

public class Iha2_Armr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha2_Armr(String NAME, Item ... items) {
        super(NAME, items);
        this.searchable = false;
        this.description = "It's a suit of armor holding a polearm. Its gauntlet\n"
                         + "is wrapped around it, but awkwardly as if the gauntlet\n"
                         + "had been pryed opened and then closed repeatedly.";
        this.searchDialog = "The suit of armor is holding a polearm, but its\n"
                          + "gauntlet is wrapped around it awkwardly.";
        this.interactDialog = "You will probably get hurt trying to do that.";
        this.addActKeys("equip", "wear");
        this.addNameKeys("armor", "suit of armor", "armor suit", "plate armor");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! this.doesThisHaveIt("polearm"))
            rep = "It's a suit of armor. It's gauntlets are empty.";
        
        return rep; 
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable)
            rep = "You look in the suit of armor's gauntlet.";

        return rep; 
    }
/*----------------------------------------------------------------------------*/
    public void makeSearchable() {
        this.searchable = true;
    }
/*----------------------------------------------------------------------------*/
}
