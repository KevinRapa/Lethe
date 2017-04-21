package A_Super;

import A_Main.AudioPlayer;

/**
 * Represents a window that can be opened and closed.'
 * Mainly for decoration. A few windows in the game are significant, however.
 * 
 * @see Vestibule.Vest_Wndw
 * @see Marble_Hall.MhaS_Wndw
 * @author Kevin Rapa
 */
abstract public class Window extends Furniture implements Unmoveable {
    protected boolean isOpen;
    protected String descOpen, descClosed, escapeDialog;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Window () {
        super();
        this.isOpen = false;
        this.escapeDialog = "And fall to your death?";
        this.descOpen = "It's an open stone arched window. In the distance, " +
                        "you see an expanse of sea.";                    
        this.descClosed = "It's a closed stone arched window.";
        this.addActKeys("open|close", "climb|exit|jump|escape");
        this.addNameKeys("window");
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return this.isOpen ? this.descOpen : this.descClosed;
    }
//-----------------------------------------------------------------------------
    public boolean isOpen() {
        return this.isOpen;
    }
//-----------------------------------------------------------------------------
    protected void open() {
        this.isOpen = true;
    }
//-----------------------------------------------------------------------------
    protected void close() {
        this.isOpen = false;
    }    
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("open") || key.equals("close")) {
            if (this.isOpen && key.equals("close")) {
                AudioPlayer.playEffect(26);
                this.close();
                return "You close the window."; 
            }
            else if (! this.isOpen && key.equals("open")) {
                AudioPlayer.playEffect(26);
                this.open();
                return "You open the window."; 
            }
            else 
                return "The window is already " + 
                        (key.equals("open") ? "open!" : "closed!");
        }
        else
            return this.escapeDialog;
    } 
//-----------------------------------------------------------------------------
}
