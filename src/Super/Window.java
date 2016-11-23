package Super;

public class Window extends Furniture {
    protected boolean isOpen;
    protected String descOpen, descClosed;

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Window (String NAME) {
        super(NAME);
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
    @Override public String interact(Room[][][] map, String key) {

            if (this.isOpen) {
               this.close();
               interactDialog = "You close the window."; }
            else {
                this.open();
                interactDialog = "You open the window."; }
    
        return interactDialog;
    } 
/*----------------------------------------------------------------------------*/
    @Override public boolean keyMatches(String key) {
        boolean matches = false;
        
        if ((key.matches("open") && ! this.isOpen) || 
            (key.matches("close") && this.isOpen))
            matches = true;
        
        return matches;
    }
/*----------------------------------------------------------------------------*/
}
