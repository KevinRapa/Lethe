package Super;

import Main.Player;

public class Fireplace extends Furniture {
    protected boolean isLit;
    protected String searchDialogLit, searchDialogUnlit; 
    protected String descLit, descUnlit;
    protected final Item REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Fireplace(boolean isLit, Item bckt) {       
        super();
        this.searchable = false;
        this.isLit = isLit;
        this.REF = bckt;
        this.searchDialogLit = "Ouch! That's hot!";
        this.useDialog = "You douse the flames with the water.";
        this.addActKeys("warm", "use", "relax");
        this.addNameKeys("fireplace", "hearth");
        this.addUseKeys("bucket of water");
    }    
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {        
        // Dialog depends on if the fireplace is lit or not.
        if (this.isLit)
            this.searchDialog = this.searchDialogLit;
        else
            this.searchDialog = this.searchDialogUnlit;
        
        return searchDialog; 
    }
/*----------------------------------------------------------------------------*/     
    @Override public String getDescription() {
        // Description depends on if the fireplace is lit or not.
        if (this.isLit)
            this.description = this.descLit;
        else
            this.description = this.descUnlit;
        
        return this.description; 
    }   
/*----------------------------------------------------------------------------*/
    public boolean isLit() {
        return this.isLit;
    }
/*----------------------------------------------------------------------------*/    
    public void light() {
        this.isLit = true;
    }
/*----------------------------------------------------------------------------*/
    public void extinguish() {
        this.isLit = false;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {  
        if (this.isLit) 
            this.interactDialog = "You warm your hands for a second, but you are still cold."; 
        else
            this.interactDialog = "There's not much you can do to an unlit fireplace.";
      
        return this.interactDialog;  
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (! this.isLit) 
            rep = "You toss the water on, although there was never a fire to\n"
                + "begin with. It's good that you get paid to chop, not think.";
        else 
            this.extinguish(); 
        
        Player.getINV().remove(item);
        Player.getINV().add(REF);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
