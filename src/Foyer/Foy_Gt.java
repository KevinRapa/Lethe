package Foyer;

import Super.Door;
import Super.Room;

public class Foy_Gt extends Door{
    private final String descOpen;
    private final String srchDialOpen;
    private final String dialOpen;
    private boolean isOpen;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Foy_Gt (String NAME, boolean open) {
        super(NAME);
        
        this.description = "An arched black iron gate barely taller than you.";
        this.descOpen = "With the gate retracted, there is only an open doorway.";
        
        this.searchDialog = "You aren't sure what you'd search for on a gate.";        
        this.srchDialOpen = "It's just an empty doorway.";
        
        this.dialOpen = "It's just empty space. Maybe you should go through it?";
        this.interactDialog = "You try to lift the bars, but they are much too heavy.";
        
        this.isOpen = open;
        
        this.addActKeys("open", "lift");
        this.addNameKeys("gate");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        String rep = this.isOpen ? this.descOpen : this.description;

        return rep;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getSearchDialog() {
        String rep = this.isOpen ? this.srchDialOpen : this.searchDialog;
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public void swtch() {
        this.isOpen = (! this.isOpen);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        String rep = this.isOpen ? this.dialOpen : this.interactDialog;
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
