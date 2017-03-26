package West_Antechamber;

import A_Super.Button;
import A_Super.Furniture;
import Foyer.Foy2_Button;
/**
 * @author Kevin Rapa
 */
public class Want_Button extends Button {
    private final Foy2_Button FOY2_LEVER_REF;
    // ========================================================================
    public Want_Button (Furniture foy2Lever) {
        super();
        
        this.FOY2_LEVER_REF = (Foy2_Button)foy2Lever;
        
        this.description = "There's a small black button on the wall next to "
                         + "the gate.";
        this.addNameKeys("(?:small )?(?:black )?button");
    }
    // ========================================================================     
    @Override protected String event(String key) {
        return this.FOY2_LEVER_REF.event(null);
    }
    // ========================================================================  
}


