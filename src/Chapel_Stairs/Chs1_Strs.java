package Chapel_Stairs;

import Super.Staircase;

public class Chs1_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Chs1_Strs (char direction, int height) {
        super(direction, height);
        this.description = "The wide spiral stairs wind many times around the\n"
                         + "tower's wall. A dark red carpet follows them up.";
        this.addNameKeys("circular stairs", "spiral stairs", "circular staircase",
                         "spiral staircase");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.DIR == 'd') {
            rep = "The spiral stairs run a few stories downward to the first\n"
                + "floor landing.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
