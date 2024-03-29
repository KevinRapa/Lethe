package A_Super;
/**
 * Represents a static window that can't be opened or closed.
 * 
 * @author Kevin Rapa
 */
abstract public class StaticWindow extends Furniture implements Unmoveable {
    protected String escapeDialog;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public StaticWindow() {
        super();
        this.escapeDialog = "And fall to your death?";
        this.actDialog = "This is a plain window. It has no moving parts.";
        this.addActKeys("open|close", "exit|climb|jump|escape");
        this.addNameKeys("(?:barred )?window");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("open") || key.equals("close"))
            return this.actDialog;
        else
            return this.escapeDialog;
    } 
//-----------------------------------------------------------------------------
}

