package West_Outer_Wall;

import A_Super.Furniture;

public class Wow2_Armr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Armr() {
        super();
        this.searchable = false;
        this.description = "It's a suit of armor with its gauntlets pryed open.";
        this.searchDialog = "It's not holding anything anymore.";
        this.actDialog = "You will probably get hurt trying to do that.";
        this.addNameKeys("(suit of |plate )?armor", "armor suit");
        this.addActKeys("wear", "equip");
    }    
/*----------------------------------------------------------------------------*/
}