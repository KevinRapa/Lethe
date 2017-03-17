package Tower;

import A_Main.NameConstants;
import A_Super.Item;
/**
 * The fifth phylactery.
 * 
 * @author Kevin Rapa
 */
public class Tow_ScepterPhylactery extends Item {
    // ========================================================================
    public Tow_ScepterPhylactery(String name, int score) {
        super(name, score);
        this.type = NameConstants.PHYLACTERY;
        this.description = "It's a glimmering silver scepter holding a large opal\n"
                         + "at the top. The handle resembles a snake wrapped around\n"
                         + "a stick.";
    }
    // ========================================================================
}
