package Foyer;

import A_Super.Door;
import A_Super.Direction;
/**
 * Open and closeable gate toggled by a button in Foy2.
 * Two of these in the foyer. Only one is ever open at a time.
 * 
 * @see Foyer.Foy2_Lvr
 * @author Mantis Toboggan
 */
public class Foy_Gate extends Door {
    private final String DESCOPEN, SRCHOPEN, DIALOPEN;
    private boolean isOpen;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Foy_Gate (boolean open, Direction dir) {
        super(dir);
        
        this.description = "An arched black iron gate barely taller than you.";
        this.DESCOPEN = "With the gate retracted, there is only an open doorway.";
        
        this.searchDialog = "You aren't sure what you'd search for on a gate.";        
        this.SRCHOPEN = "It's just an empty doorway.";
        
        this.DIALOPEN = "It's just empty space. Maybe you should go through it?";
        this.actDialog = "You try to lift the bars, but they are much too heavy.";
        
        this.isOpen = open;
        
        this.addActKeys("open", "lift");
        this.addNameKeys("gate", dir + " gate");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        return this.isOpen ? this.DESCOPEN : this.description;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getSearchDialog() {
        return this.isOpen ? this.SRCHOPEN : this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    public void swtch() {
        this.isOpen = (! this.isOpen);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        return this.isOpen ? this.DIALOPEN : this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
