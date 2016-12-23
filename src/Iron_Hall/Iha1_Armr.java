package Iron_Hall;

import A_Super.Furniture;

public class Iha1_Armr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1_Armr() {
        super();
        this.searchable = false;
        this.description = "It's plate armor holding a polearm. It stands\n"
                         + "gazing out the window.";
        this.searchDialog = "You find a long polearm, but the gauntlet is\n"
                          + "gripping it too tightly to be pryed open.";
        this.addActKeys("equip", "wear");
        this.addNameKeys("(suit of |plate )?armor", "armor suit", "gauntlet");
    }    
//*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        actDialog = "You will probably get hurt trying to do that.";
        return actDialog;
    }
/*----------------------------------------------------------------------------*/
}
