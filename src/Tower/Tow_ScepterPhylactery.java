package Tower;

import A_Main.Names;
import A_Super.Item;
/**
 * The fifth phylactery.
 * 
 * @author Kevin Rapa
 */
public class Tow_ScepterPhylactery extends Item {
    //-------------------------------------------------------------------------
    public Tow_ScepterPhylactery(String name, int score) {
        super(name, score);
        this.type = Names.PHYLACTERY;
        this.description = "It's a glimmering silver scepter holding a large opal "
                         + "at the top. The handle resembles a snake wrapped around "
                         + "a stick.";
    }
    //-------------------------------------------------------------------------
}
