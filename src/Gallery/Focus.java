package Gallery;

import A_Main.NameConstants;
import A_Super.Item;
/**
 * This item is used in the light machine puzzle.
 * Only foci may be put in light machines.
 * 
 * @see Gallery.Gal_LightMachine
 * @author Kevin Rapa
 */
public class Focus extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/           
    public Focus (String name, String desc) {
        super(name, 50);
        this.type = NameConstants.FOCUS;
        this.description = desc;
    }
/*----------------------------------------------------------------------------*/
}
