package Laboratory;

import A_Main.GUI;
import A_Main.Player;
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
        this.description= 
                "You find yourself in a laboratory filled with many "
                + "alchemical devices. At the far east wall are a " +
                  "line of chemical dispensers. On a counter to the "
                + "north is a confusing alchemical contraption with "
                + "many glass tubes. On the same counter to the left "
                + "is a metal sink next to a large pipe running from floor "
                + "to ceiling. A tall buret sits on a table in the center. "
                + "To the south stands both a shelf filled with chemistry "
                + "tools and a barrel.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you enter this room, you feel overwhelmed at the sight of many unknown instruments of alchemy.");
            
        return STD_RM_OUT;
    }
}