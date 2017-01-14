package Gallery;

import A_Super.Item;
/**
 * This item is used in the light machine puzzle.
 * Only foci may be put in light machines.
 * 
 * @see Gallery.LghtMchn
 * @author Kevin Rapa
 */
public class Focus extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/           
    public Focus (String name, String desc) {
        super(name);
        this.type = "focus";
        this.description = desc;
    }
/*----------------------------------------------------------------------------*/
}
