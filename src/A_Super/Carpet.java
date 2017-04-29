package A_Super;

import static A_Main.Names.*;

/**
 * @author Kevin Rapa
 */
abstract public class Carpet extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public Carpet () {
        super();
        
        this.actDialog = "You take some valuable time to admire the carpet. Yes, "
                       + "what a wonderfully woven piece of artwork. It really "
                +        "would be a shame to get this dirty. What a fantastic rug.";
        this.useDialog = "That would most certainly ruin it.";
        this.searchDialog = "There's nothing interesting under the carpet.";

        this.addUseKeys(ACETONE, ASH, SOIL, "sand|.+ dye", ".+ (?:wine|vinegar)");
        this.addActKeys(MOVEPATTERN, GETPATTERN, "admire", "lift|raise", "roll");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN) || key.equals("lift") || key.equals("raise"))
            return this.searchDialog;
        else if (key.equals("roll"))
            return "You're really not intending to take that with you, right?";
        else if (key.equals("admire"))
            return this.actDialog;
        else
            return getIt("A foolish attempt is made. Carpets are much heavier than they look.");
    }
    //-------------------------------------------------------------------------       
}


