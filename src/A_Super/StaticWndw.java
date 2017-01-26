package A_Super;
/**
 * Represents a static window that can't be opened or closed.
 * 
 * @author Kevin Rapa
 */
abstract public class StaticWndw extends Furniture {
    protected String escapeDialog;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public StaticWndw() {
        super();
        this.escapeDialog = "And fall to your death?";
        this.actDialog = "This is a plain window. It has no moving parts.";
        this.addActKeys("open", "close", "exit", "climb", "jump");
        this.addNameKeys("window", "barred window");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches("open|close"))
            return this.actDialog;
        else
            return this.escapeDialog;
    } 
/*----------------------------------------------------------------------------*/
}

