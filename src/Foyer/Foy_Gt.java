package Foyer;

import A_Super.Door;

public class Foy_Gt extends Door{
    private final String DESCOPEN, SRCHOPEN, DIALOPEN;
    private boolean isOpen;
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Foy_Gt (boolean open) {
        super();
        
        this.description = "An arched black iron gate barely taller than you.";
        this.DESCOPEN = "With the gate retracted, there is only an open doorway.";
        
        this.searchDialog = "You aren't sure what you'd search for on a gate.";        
        this.SRCHOPEN = "It's just an empty doorway.";
        
        this.DIALOPEN = "It's just empty space. Maybe you should go through it?";
        this.actDialog = "You try to lift the bars, but they are much too heavy.";
        
        this.isOpen = open;
        
        this.addActKeys("open", "lift");
        this.addNameKeys("gate");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        String rep = this.isOpen ? this.DESCOPEN : this.description;

        return rep;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getSearchDialog() {
        String rep = this.isOpen ? this.SRCHOPEN : this.searchDialog;
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public void swtch() {
        this.isOpen = (! this.isOpen);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.isOpen ? this.DIALOPEN : this.actDialog;
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
