package A_Super;

public class Window extends Furniture {
    protected boolean isOpen;
    protected String descOpen, descClosed;

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Window () {
        super();
        this.searchable = false;
        this.isOpen = false;
        this.descOpen = "It's an open stone arched window. In the distance,\n" +
                        "you see an expanse of sea.";                    
        this.descClosed = "It's a closed stone arched window.";
        this.addActKeys("open", "close");
        this.addNameKeys("window");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.isOpen)
            this.description = this.descOpen;
        else
            this.description = this.descClosed;
        
        return this.description; 
    }
/*----------------------------------------------------------------------------*/
    public boolean isOpen() {
        return this.isOpen;
    }
/*----------------------------------------------------------------------------*/
    protected void open() {
        this.isOpen = true;
    }
/*----------------------------------------------------------------------------*/
    protected void close() {
        this.isOpen = false;
    }    
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {

            if (this.isOpen && key.matches("close")) {
                this.close();
                actDialog = "You close the window."; 
            }
            else if (! this.isOpen && key.matches("open")) {
                this.open();
                actDialog = "You open the window."; 
            }
            else 
                this.actDialog = "The window is already " + (key.matches("open") ? "open" : "closed") + "!";
    
        return actDialog;
    } 
/*----------------------------------------------------------------------------*/
}
