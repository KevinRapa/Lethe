package A_Super;

import A_Main.Player;
import static A_Main.NameConstants.BUCKET_OF_WATER;
/**
 * Represents a fireplace with lit and unlit states.
 * 
 * The bucket of water may be used on a fireplace to extinguish it.
 * 
 * @see Library.Lib2_Frplc
 * @see Vestibule.Vest_Frplc
 * @author Kevin Rapa
 */
public class Fireplace extends Furniture {
    protected boolean isLit;
    protected String searchDialogLit, searchDialogUnlit; 
    protected String descLit, descUnlit;
    protected final Item BCKT_REF; // Empty bucket item reference to give to player.
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Fireplace(boolean isLit, Item bckt) {       
        super();
        this.searchable = false;
        this.isLit = isLit;
        this.BCKT_REF = bckt;
        this.searchDialogLit = "Ouch! That's hot!";
        this.useDialog = "You douse the flames with the water.";
        this.addActKeys("warm", "use", "relax");
        this.addNameKeys("fireplace", "hearth");
        this.addUseKeys(BUCKET_OF_WATER);
    }    
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {        
        return this.isLit() ? this.searchDialogLit : this.searchDialogUnlit;
    }
/*----------------------------------------------------------------------------*/     
    @Override public String getDescription() {
        return this.isLit() ? this.descLit : this.descUnlit;
    }   
/*----------------------------------------------------------------------------*/
    public boolean isLit() {
        return this.isLit;
    }
/*----------------------------------------------------------------------------*/
    public void extinguish() {
        this.isLit = false;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {  
        return this.isLit() ? 
                "You warm your hands for a second, but you are still cold." :
                "There's not much you can do to an unlit fireplace."; 
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item water) {
        String rep = this.useDialog;
        
        if (! this.isLit) 
            rep = "You toss the water on, although there was never a fire to\n"
                + "begin with. It's good that you get paid to chop, not think.";
        else 
            this.extinguish(); 
        
        Player.getInv().remove(water);
        Player.getInv().add(BCKT_REF);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
