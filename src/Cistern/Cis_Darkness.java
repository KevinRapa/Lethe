package Cistern;

import static A_Main.Names.HAND_TORCH;
import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Cis_Darkness extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public Cis_Darkness () {
        super();

        this.description = "The darkness hides the true size of the room, though " +
                           "you suppose it could be as big as 100 feet across and " +
                           "50 feet high, perhaps more. Claustrophobia sets in as "
                         + "the darkness and turgid air envelop you.";

        this.useDialog = "The darkness swallows up the torch light, keeping visibility low.";
        
        this.addActKeys(GETPATTERN);
        this.addUseKeys(HAND_TORCH);
        this.addNameKeys("darkness|dark void|void|blackness|ceiling");
    }
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        return getIt();
    }
    //------------------------------------------------------------------------- 
}


