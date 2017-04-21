package Cellar;

import A_Main.AudioPlayer;
import A_Main.Names;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cel5_Grate extends Furniture implements Gettable {
    private final Furniture CEL5_LDDR;
    private boolean moved;
    //-------------------------------------------------------------------------
    public Cel5_Grate (Furniture cel5Lddr) {
        super();
        
        this.moved = false;
        this.CEL5_LDDR = cel5Lddr;
        
        this.description = 
                "The thick grate is about two and a half feet across "
              + "and covers what you can only assume to be the top rung "
              + "of a ladder. The grate looks just light enough to lift, "
              + "however the grate is locked down with a padlock.";
        this.actDialog = "You can almost lift it, but a rogue padlock is sabotaging your attempt.";
        this.searchDialog = "All that is of interest is a padlock and the metal rung below the grate.";
        this.useDialog = "A sharp vibration propels through your body from the "
                       + "impact. Quite an impulse and futile decision.";

        this.addNameKeys("(?:thick )?(?:metal )?grate");
        this.addUseKeys(ANYTHING);
        this.addActKeys(MOVEPATTERN, GETPATTERN, "open");
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        if (! moved) {
            return Player.getPos().hasFurniture("padlock") ? 
                    this.description.replaceFirst(",.+", ".") :
                    this.description;
        }
        else
            return "The metal grate has been moved out of the way.";
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        return Player.getPos().hasFurniture("padlock") ?
                this.searchDialog : NOTHING_HERE;
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        return Player.getPos().hasFurniture("padlock") ? 
                actDialog : getIt();
    }
    //-------------------------------------------------------------------------   
    @Override public String getIt() {
        moved = ! moved;
        AudioPlayer.playEffect(48);
        
        if (moved) {
            Player.getPos().addFurniture(CEL5_LDDR);
            return "You pull the grate out of the way, yielding entrance into the hole.";
        }
        else {
            Player.getPos().removeFurniture(CEL5_LDDR);
            return "The player confusingly decides to place the grate back over the hole.";
        }
    }
    //-------------------------------------------------------------------------   
    @Override public String useEvent(Item item) {
        if (item.getType().equals(Names.WEAPON)) {
            AudioPlayer.playEffect(35);
            return this.useDialog;
        }
        else
            return DEFAULT_USE;
    }
    //-------------------------------------------------------------------------     
}


