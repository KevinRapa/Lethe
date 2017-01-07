package Tomb;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Tmb3_Cskt extends Tomb_Casket {
    // ========================================================================
    public Tmb3_Cskt (Item... items) {
        super(items);
        this.searchDialog = "You slowly swing open the casket lid. The smell of\n" +
                            "brimstone escapes. Though not unexpected, you are surprised\n" +
                            "to see a preserved, but degenerate body standing limp\n" +
                            "in the casket on several layers of fabric. The body\n" +
                            "is emaciated and wrinkled, but you can still make out\n" +
                            "its features, including the eyes. The body wears black\n" +
                            "robes and a bronze crown on its head. It holds its \n" +
                            "hands cupped at the waist. You look in its hands.";
    }
    // ========================================================================  
}


