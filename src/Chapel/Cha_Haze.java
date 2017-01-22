package Chapel;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cha_Haze extends Furniture {
    // ========================================================================
    public Cha_Haze () {
        super();
        this.searchable = false;
        
        this.description = "Though the room seems clean, a thin blanket of dust\n"
                         + "coats everything, and an ambient haze floats in\n"
                         + "the calm air.";

        this.addNameKeys("(?:dusty )?haze", "dust");
    }
    // ========================================================================     
}


