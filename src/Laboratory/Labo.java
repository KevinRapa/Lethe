package Laboratory;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;
/**
 * Player must successfully create a phase door potion to progress in the game.
 * The puzzle involves measuring and distilling various ingredient Items.
 * 
 * 1. Use florence flask on distiller
 * 2. Connect hose to gas pipe and turn it on
 * 3. Open condensing tube
 * 3.5. Put bromine into barrel, let it chill for 30 seconds.
 * 4. Titrate and add exactly these 5 ingredients (Use dispensers and burette):
 *     chilled H2O, 30mL
 *     chilled bromine, 10mL
 *     vinegar, 5mL
 *     aether, 20mL
 *     wine, 15mL
 *     carbonic acid, 35mL
 * 5. Use beaker on condenser
 * 6. Use striker on the bunsen burner
 * 7. Take the beaker.
 *
 * @see Laboratory.Labo_BurnerBook
 * @see Laboratory.Labo_BookGlassware
 * @see Laboratory.Labo_CoatNote
 * @see Laboratory.Labo_DispenserNote
 * @see Laboratory.Ingredient
 * @see Laboratory.Labo_Dispensers
 * @see Laboratory.Labo_Distiller
 * @see Laboratory.Labo_Condenser
 * @see Laboratory.Labo_DryIce
 * @author Kevin Rapa
 */
public class Labo extends Room {
//-----------------------------------------------------------------------------    
    public Labo(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you enter this room, you feel overwhelmed at the sight "
                    + "of many unknown instruments of alchemy.");
            
        return NAME;
    }
}