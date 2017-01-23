package Iron_Hall;

import A_Super.Furniture;

public class Iha1_Armor extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1_Armor() {
        super();

        this.description = "It's plate armor holding a polearm. It stands\n"
                         + "gazing out the window.";
        this.actDialog = "You will probably get hurt trying to do that.";
        this.searchDialog = "You find a long polearm, but the gauntlet is\n"
                          + "gripping it too tightly to be pryed open.";
        this.addActKeys("equip", "wear");
        this.addNameKeys("(suit of |plate )?armor", "armor suit", "gauntlet");
    }    
/*----------------------------------------------------------------------------*/
}
