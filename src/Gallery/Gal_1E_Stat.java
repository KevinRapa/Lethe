package Gallery;

import A_Main.GUI;
import A_Main.Inventory;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Gal_1E_Stat extends Furniture {
    private int level;
    private final Gal_2E_Stat REF3;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_1E_Stat(Furniture stat) {
        super();
        this.REF3 = (Gal_2E_Stat)stat;
        this.level = 0;
        this.description = "The grandiose statue stands in the exact center of\n"
                         + "the circular room. It portrays a male figure. He\n"
                         + "poises elegantly, with his right arm extended over\n"
                         + "his head and left hand held low as if bearing an\n"
                         + "object, though it's empty.";        
        this.searchDialog = "The statue's hand is empty";
        this.addNameKeys("statue");
        this.addUseKeys("crystal orb");
        this.inv = new Stat_Inv();
    }
/*----------------------------------------------------------------------------*/
    public int getState() {
        return this.level;
    }
/*----------------------------------------------------------------------------*/
    public String activate(char color, boolean isOn) {
        String rep = "The orb sits comfortably in the statue's palm.";
        
        if (doesThisHaveIt("crystal orb") && isOn && level != 3) {
            
            if ((color == 'r' && this.level == 0) || 
                (color == 'p' && this.level == 1) || 
                (color == 'P' && this.level == 2)) {
                rep = this.raise(); 
            }             
            else if (this.level == 0) {
                rep = "The beam of light shines into the orb with no effect.";
            }
            else if (this.level == 1 || this.level == 2) {
                rep = "The orb's hum dies and its glow fades.";
                this.level = 0;
            }
        }
        else if (! this.doesThisHaveIt("crystal orb") && isOn)
            rep = " The beam of light shines at the statue in the central chamber.";
        
        else if (this.level == 3 && isOn)
            rep = " The beam shines at the statue's risen base.";
        
        return rep;
    }    
/*----------------------------------------------------------------------------*/
    private String raise() {
        String rep;
        
        switch (level++) { 
            case 0:
                rep = "The crystal orb in the statue's palm begins to glow red.";
                break;
            case 1: 
                rep = "The orb starts to hum louder and its glow turns purple.";
                break;         
           default:
                this.searchable = false;
                Player.getRoomRef("GAL4").addFurniture(REF3);
                rep = "The orb's glow turns a dark purple before fading into\n"
                    + "ultraviolet. The statue raises on its platform to the\n"
                    + "second floor.";
        }
      return rep;  
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.doesThisHaveIt("crystal orb")) {   
            switch (this.level) {
                case 0: 
                    return "The statue now stands holding the glinting crystal orb.";
                case 1:
                    return "The statue stands holding the glowing orb. It hums softly.";          
                case 2:
                    return "The statue stands holding the glowing orb. It's humming quite\n"
                            + "loudly now.";
                default:
                    return "The statue has risen up to the next floor. Its tall base\n"
                            + "is all that's left on this level.";
            }
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable && this.doesThisHaveIt("crystal orb")) {
            rep = "The statue stands bearing the crystal orb.";
        }
        else if (! this.searchable) {
            rep = "The statue's palm is now out of reach.";
        }                
        return rep; 
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.useDialog = "You set the orb into the statue's palm.";
        Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    public void addDragonRef(Furniture dragon) {
        ((Stat_Inv)this.inv).GAL1_DRGN = (Gal1_Drgn)dragon;
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/
    private class Stat_Inv extends Inventory { 
        public Gal1_Drgn GAL1_DRGN;  

        public Stat_Inv(Item ... items) {
            super(items);
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) {
            this.CONT.add(item);
            
            if (item.toString().matches("crystal orb"))
                GUI.out(activate(GAL1_DRGN.getBeam(), GAL1_DRGN.isOn()));

            return true;
        }
        /*--------------------------------------------------------------------*/
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/    
}
