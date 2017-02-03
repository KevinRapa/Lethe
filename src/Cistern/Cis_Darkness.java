package Cistern;

import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Cis_Darkness extends Furniture implements Gettable {
    // ========================================================================
    public Cis_Darkness () {
        super();

        this.description = "The darkness hides the true size of the room, though\n" +
                           "you suppose it could be as big as 100 feet across and\n" +
                           "50 feet high, perhaps more. The darkness combined with\n" +
                           "the turgid air gives you claustrophobia.";

        this.useDialog = "The darkness swallows up the torch light, keeping visibility low.";
        
        this.addActKeys(GETPATTERN);
        this.addUseKeys(HAND_TORCH);
        this.addNameKeys("darkness", "dark void", "void", "blackness", "ceiling");
    }
    // ======================================================================== 
    @Override public String interact(String key) {
        return getIt();
    }
    // ======================================================================== 
}


