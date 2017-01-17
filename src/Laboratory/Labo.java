package Laboratory;

import A_Super.Room;
/**
 * Player must successfully create a phase door potion to progress in the game.
 * The puzzle involves measuring and distilling various ingredient Items.
 * Player must have a lab coat in order to use the lab equipment!
 * 
 * 1. Use florence flask on distiller
 * 2. Connect hose to gas pipe and turn it on
 * 3. Open condensing tube
 * 3.5. Put bromine into barrel, let it chill for 30 seconds.
 * 4. Titrate and add exactly these 5 ingredients (Use dispensers and burette):
 *     chilled bromine, 10mL
 *     vinegar, 5mL
 *     aether, 20mL
 *     wine, 15mL
 *     carbonic acid, 35mL
 * 5. Use beaker on condenser
 * 6. Use striker on the bunsen burner
 * 7. Take the beaker.
 *
 * @see Laboratory.Labo_BrnrBk
 * @see Laboratory.Labo_BkGlsswr
 * @see Laboratory.Labo_CoatNt
 * @see Laboratory.Labo_DspnsrNt
 * @see Laboratory.Ingredient
 * @see Laboratory.Labo_Dspensrs
 * @see Laboratory.Labo_Dstllr
 * @see Laboratory.Labo_Cndsr
 * @see Laboratory.Labo_DryIce
 * @author Kevin Rapa
 */
public class Labo extends Room {
// ============================================================================    
    public Labo(String name, String ID) {
        super(name, ID);
        this.description= "You find yourself in a laboratory hidden\n" +
                          "behind the attic in which many alchemical devices are\n" +
                          "around the room. At the far east wall are a\n" +
                          "line of opaque dispensers, probably filled with liquid.\n" +
                          "On a counter to the north is a complicated alchemical\n" +
                          "contraption with many glass tubes. On the same counter\n" +
                          "to the left is a metal sink. In the center of the room\n" +
                          "is a tall burette standing on a table. To the south\n" +
                          "is a shelf filled with various chemistry tools, and to\n" +
                          "the right of it is a barrel. In the corner next to the\n" +
                          "contraption is a pipe running up the height of the room.";
    }
// ============================================================================
}