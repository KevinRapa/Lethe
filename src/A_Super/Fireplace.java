package A_Super;

import A_Main.AudioPlayer;
import A_Main.Player;
import static A_Main.Names.BUCKET_OF_WATER;
/**
 * Represents a fireplace with lit and unlit states.
 * 
 * The bucket of water may be used on a fireplace to extinguish it.
 * 
 * @see Library.Lib2_Frplc
 * @see Vestibule.Vest_Frplc
 * @author Kevin Rapa
 */
abstract public class Fireplace extends Furniture implements Gettable, Unmoveable {
    protected boolean isLit;
    protected String searchDialogLit, searchDialogUnlit; 
    protected String descLit, descUnlit;
    protected final Item BCKT_REF; // Empty bucket item reference to give to player.
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Fireplace(Item bckt) {       
        super();
        
        this.isLit = true;
        this.BCKT_REF = bckt;
        
        this.searchDialogLit = "Ouch!";
        this.descUnlit = "It's a smoldering, unlit fireplace.";
        this.useDialog = "You douse the flames with the water.";
        
        this.addActKeys("warm", "douse|extinguish", "use", GETPATTERN, "relax");
        this.addNameKeys("fireplace", "hearth", "fire|flames?");
        this.addUseKeys(BUCKET_OF_WATER);
    }    
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {  
        if (isLit) {
            AudioPlayer.playEffect(39, 0.3);
            return this.searchDialogLit;
        }
        else
            return this.searchDialogUnlit;
    }
//-----------------------------------------------------------------------------     
    @Override public String getDescription() {
        return this.isLit() ? this.descLit : this.descUnlit;
    }   
//-----------------------------------------------------------------------------
    public boolean isLit() {
        return this.isLit;
    }
//-----------------------------------------------------------------------------
    public void extinguish() {
        AudioPlayer.playEffect(39, 0.3);
        this.isLit = false;
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {  
        if (key.equals("extinguish") || key.equals("douse")) {
            if (Player.hasItem(BUCKET_OF_WATER)) {
                Item bucket = Player.getInv().get(BUCKET_OF_WATER);
                return this.useEvent(bucket);
            }
            else
                return "You have nothing to douse the flames with.";
        }
        else if (key.matches(GETPATTERN))
            return this.getIt();
        else
            return this.isLit() ? 
                    "You warm your hands for a second, but you are still cold." :
                    "There's not much you can do to an unlit fireplace."; 
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item water) {
        String rep = this.useDialog;
        
        if (! this.isLit) 
            rep = "You toss the water on, although there was never a fire to begin with.";
        else 
            this.extinguish(); 
        
        Player.getInv().remove(water);
        Player.getInv().add(BCKT_REF);
        
        return rep;
    }
//-----------------------------------------------------------------------------
}
