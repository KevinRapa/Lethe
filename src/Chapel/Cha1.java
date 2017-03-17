package Chapel;

import A_Super.Room;
/**
 * Where the player obtains holy water to make the mandragora.
 * Connects to Chs3 and Cha2
 * 
 * @see Chapel.Cha2
 * @see Chapel_Stairs.Chs3
 * @author Kevin Rapa
 */
public class Cha1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cha1(String name, String ID) {
        super(name, ID);
        description= 
                "You are on the north end of a dark, musty chapel extending to the south. A dusty\n"
               + "haze clogs the air. Moonlight shines in through the stained\n"
               + "glass windows above and pierces the haze faintly. This room\n"
               + "seems fairly clean, though long abandoned. The walls are entirely\n"
               + "wood and ornately carved. Rows of pews line\n"
               + "either side of the room. Lit candelabras stand in each\n"
               + "northern corner. A small cylix on an end-table to your west\n"
               + "bears clear water. A long carpet runs between the pews to\n"
               + "the far southern side of the chamber.";
    }
/*----------------------------------------------------------------------------*/
}
