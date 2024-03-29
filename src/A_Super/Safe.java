package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Menus;
import static A_Main.Names.WEAPON;
/**
 * A combination safe that can be unlocked by entering the right combination.
 * Player may interact with or search this for an open attempt.
 * @author Kevin Rapa
 */
abstract public class Safe extends SearchableFurniture implements Openable, Moveable {
    protected final int COMBO;
    protected final int[] DIALS; 
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Safe (int combo, Item... items) {
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
        this.addActKeys("use|spin|twist", "smash|break");
        this.addNameKeys("(?:combination )?safe", "strongbox");
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        if (! this.searchable) {
            GUI.out("The safe has a combination lock.");
            this.openSub();
        }
        if (this.searchable)
            return "The safe is unlocked!";
            
        return this.searchDialog;
    }
//-----------------------------------------------------------------------------
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
        } while (! action.isEmpty());
    }
//-----------------------------------------------------------------------------
    private boolean turnDial(int i) {
        AudioPlayer.playEffect(10);
        if (this.DIALS[i] == 9)
            DIALS[i] = 0;
        else
            DIALS[i]++;
        
        return this.check();
    }
//-----------------------------------------------------------------------------
    private boolean check() {
        int currentCombo = 0;
        
        currentCombo += (DIALS[0] * 100) + (DIALS[1] * 10) + (DIALS[2] * 1);
                  
        return currentCombo == this.COMBO;
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {              
        if (key.equals("break") || key.equals("smash"))
            return "You would like to do that, wouldn't you?";
        
        else if (! this.searchable) {
            GUI.out("The safe has a combination lock.");
            this.openSub();
            
            if (this.searchable)
                return "The safe is unlocked!";
        }
        else
            return "The safe is already open. You may search it.";
        
        return this.actDialog;
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        return (item.getType().equals(WEAPON)) ? useDialog : DEFAULT_USE;
    }
//----------------------------------------------------------------------------- 
    @Override public String moveIt() {
        return "It budges only a small amount before you're out of breath. This is much too heavy.";
    }
//-----------------------------------------------------------------------------
}
