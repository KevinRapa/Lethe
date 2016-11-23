package West_Outer_Wall;

import Super.Furniture;

public class Wow2_Armr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Armr(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a suit of armor with its gauntlets pryed open.";
        this.searchDialog = "It's not holding anything anymore.";
        this.interactDialog = "You will probably get hurt trying to do that.";
        this.addNameKeys("armor", "armor suit", "suit of armor", "plate armor");
        this.addActKeys("wear", "equip");
    }    
/*----------------------------------------------------------------------------*/
}