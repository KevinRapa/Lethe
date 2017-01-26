package Chapel;

import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Cha_Haze extends Furniture implements Gettable {
    // ========================================================================
    public Cha_Haze () {
        super();
        
        this.description = "Though the room seems clean, a thin blanket of dust\n"
                         + "coats everything, and an ambient haze floats in\n"
                         + "the calm air.";
        this.actDialog = this.useDialog = "You aren't a maid!";
        
        this.addUseKeys("mop");
        this.addActKeys("clean", "sweep");
        this.addActKeys(GETKEYS);
        this.addNameKeys("(?:dusty )?haze", "dust");
    }
    // ========================================================================     
    @Override public String interact(String key) {
        if (key.equals("clean") || key.equals("sweep"))
            return this.actDialog;
        else
            return this.getIt();
    }
    // ========================================================================     
}


