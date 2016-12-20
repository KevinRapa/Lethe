package Iron_Hall;

import Super.Furniture;
import Super.Item;
import Super.Room;

public class Iha2_Hnd extends Furniture{
    private final Iha2_Armr REF;
    private char state;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha2_Hnd(Furniture wow2Armr, Item... items) {
        super(items);
        this.searchable = false;
        this.REF = (Iha2_Armr) wow2Armr;
        this.state = 'c';
        this.description = "The gauntlet is gripping the polearm awkwardly, as\n"
                         + "if it's been pryed open and closed repeatedly.";
        this.addActKeys("pry", "open");
        this.addNameKeys("gauntlet", "hand");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep;
        
        if (this.state == 'c' && REF.doesThisHaveIt("polearm"))
            rep = "You put your eyes withing an inch of the gauntlet. You can\n"
                + "definitely confirm there is a polearm here.";
        else if (this.state == 'o' && REF.doesThisHaveIt("polearm"))
            rep = "The gauntlet is open. Maybe you should take the polearm?";
        else
            rep = "You find just an empty gauntlet.";
        
        return rep; 
    }
//*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description; //This shouldn't be printed.
        if (this.state == 'o' && REF.doesThisHaveIt("polearm"))
            rep = "The gauntlet is open. Maybe you should search the armor...";
        else if (this.state == 'o' && ! REF.doesThisHaveIt("polearm"))
            rep = "Just an empty steel gauntlet.";
        
        return rep; 
    }
//*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        
        if (this.state == 'c') {
            interactDialog = "You manage to pry the gauntlet open.";
            this.state = 'o';
            REF.makeSearchable();
        }
        else
            interactDialog = "The gauntlet is already open.";

        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
}
