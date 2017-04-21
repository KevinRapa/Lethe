package Secret_Stairs;

import A_Super.Balcony;
/**
 * @author Kevin Rapa
 */
public class Sst_Landing extends Balcony {
    //-------------------------------------------------------------------------
    public Sst_Landing () {
        super();

        this.description = "The stairs lead up to the small landing. It's held up "
                         + "only by several old wood planks and looks just big "
                         + "enough to stand on.";

        this.addNameKeys("(?:small )?(?:landing|balcony)");
    }
    //------------------------------------------------------------------------- 
}


