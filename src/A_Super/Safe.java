package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Menus;
import static A_Main.NameConstants.WEAPON;
import A_Main.Player;
/**
 * A combination safe that can be unlocked by entering the right combination.
 * Player may interact with or search this for an open attempt.
 * @author Kevin Rapa
 */
abstract public class Safe extends SearchableFurniture implements Openable {
    protected final String COMBO;
    protected final int[] DIALS; 
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Safe (String combo, Item... items) {
        super(items);
        this.COMBO = combo;
        this.DIALS = new int[3];
        this.DIALS[0] = (int)(Math.random() * 10.0);
        this.DIALS[1] = (int)(Math.random() * 10.0);
        this.DIALS[2] = (int)(Math.random() * 10.0);
        this.actDialog = "The safe is still locked.";
        this.useDialog = "They didn't design safes to break open that easily.";
        this.searchDialog = this.actDialog;
        this.searchable = false;
        this.addUseKeys(ANYTHING);
        this.addActKeys("use", "spin", "twist", "smash", "break");
        this.addNameKeys("(?:combination )?safe", "strongbox");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (! this.searchable) {
            GUI.out("The safe is locked.");
            this.openSub();
        }
        if (this.searchable)
            return "The safe is unlocked!";
            
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    private void openSub() {
        boolean successful;
        String action;
        
        GUI.menOut(Menus.SAFE_MENU);
        do {
            GUI.out("\t  [" + DIALS[0] + "][" + DIALS[1] + "][" + DIALS[2] + "]");      

            action = GUI.promptOut();
            
            if (action.matches("[123]")) {
                successful = this.turnDial(Integer.parseInt(action) - 1);
                
                if (successful) {
                    this.searchable = true;
                    AudioPlayer.playEffect(43);
                    GUI.menOut("You here a click."); 
                }
                else {
                    this.searchable = false;
                    GUI.menOut(Menus.SAFE_MENU);
                }
            } 
        } while (Player.isNonEmptyString(action));
    }
/*----------------------------------------------------------------------------*/
    private boolean turnDial(int i) {
        AudioPlayer.playEffect(10);
        if (this.DIALS[i] == 9)
            DIALS[i] = 0;
        else
            DIALS[i]++;
        
        return this.check();
    }
/*----------------------------------------------------------------------------*/
    private boolean check() {
        String currentCombo = NOTHING;
        
        for (int dial : this.DIALS)
            currentCombo = currentCombo.concat(Integer.toString(dial));
                  
        return currentCombo.matches(this.COMBO);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {              
        if (key.matches("smash|break"))
            return "Now you WOULD like to do that, wouldn't you?";
        
        else if (! this.searchable) {
            GUI.out("The safe has a combination lock.");
            this.openSub();
            
            if (this.searchable)
                return "The safe is unlocked!";
        }
        else
            return "The safe is already open. Perhaps you\n"
                 + "should search it.";
        
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return useDialog;
        else
            return DEFAULT_USE;
    }
/*----------------------------------------------------------------------------*/ 
}
