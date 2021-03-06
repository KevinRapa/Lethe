package Gallery;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import static A_Main.Names.CRYSTAL_ORB;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import A_Super.MachineColor;
import A_Super.SearchableFurniture;
/**
 * Part of the light puzzle.
 * Player must use the crystal orb on this.
 * 
 * @see Gallery.Gal4_Statue
 * @see Gallery.Gal_LightMachine
 * @author Kevin Rapa
 */
public class Gal2_Statue extends SearchableFurniture {
    private int level;
    private final Furniture REF3;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal2_Statue(Furniture stat) {
        super();
        
        this.inv = new Stat_Inv();
        
        this.REF3 = stat;
        this.level = 0;
        this.description = "The grandiose statue stands in the exact center of "
                         + "the circular room. It portrays a male figure. He "
                         + "poises elegantly, with his right arm extended over "
                         + "his head and left hand held low as if bearing an "
                         + "object, though it's empty.";        
        this.searchDialog = "The statue's hand is empty.";
        this.useDialog = "You set the orb in the statue's palm. ";
        this.addNameKeys("(?:grandiose )?statue", "(?:statue(?:'s)? )?(?:hand|palm)");
        this.addUseKeys(CRYSTAL_ORB);
    }
//-----------------------------------------------------------------------------
    public int getState() {
        return this.level;
    }
//-----------------------------------------------------------------------------
    public String activate(MachineColor color) {
        if (containsItem(CRYSTAL_ORB) && level != 3) {
            
            if ((color == MachineColor.RED && this.level == 0) || 
                (color == MachineColor.PURPLE && this.level == 1) || 
                (color == MachineColor.DARK_PURPLE && this.level == 2)) {
                return this.raise(); 
            }             
            else if (this.level == 0) {
                return "The beam of light shines into the orb with no effect.";
            }
            else if (this.level == 1 || this.level == 2) {
                this.level = 0;
                return "The orb's hum dies and its glow fades.";
            }
        }
        else if (! this.containsItem(CRYSTAL_ORB)) {
            this.level = 0;
            return "The beam of light shines at the statue in the central chamber.";
        }
        
        else if (this.level == 3)
            return "The beam shines at the statue's risen base.";
        
        return "The orb sits comfortably in the statue's palm.";
    }    
//-----------------------------------------------------------------------------
    private String raise() {
        switch (level++) { 
            case 0:
                return "The crystal orb in the statue's palm begins to glow red.";
            case 1: 
                return "The orb starts to hum louder and its glow turns purple.";        
            default:
                this.searchable = false;
                Player.getRoomObj(Id.GAL4).addFurniture(REF3);
                AudioPlayer.playEffect(37);
                return "The orb's glow turns a dark purple before fading into "
                     + "ultraviolet. The statue raises on its platform to the "
                     + "second floor.";
        } 
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (this.containsItem(CRYSTAL_ORB)) {   
            switch (this.level) {
                case 0: 
                    return "The statue now stands holding the glinting crystal orb.";
                case 1:
                    return "The statue stands holding the glowing orb. It hums softly.";          
                case 2:
                    return "The statue stands holding the glowing orb. It's humming quite "
                            + "loudly now.";
                default:
                    return "The statue has risen up to the next floor. Its tall base "
                            + "is all that's left on this level.";
            }
        }
        return this.description;
    }
//-----------------------------------------------------------------------------
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable && this.containsItem(CRYSTAL_ORB)) {
            rep = "The statue stands bearing the crystal orb.";
        }
        else if (! this.searchable) {
            rep = "The statue's palm is now out of reach.";
        }                
        return rep; 
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        Player.getInv().give(item, this.inv);
        return NOTHING;
    }
//-----------------------------------------------------------------------------
    public void addDragonRef(Furniture dragon) {
        ((Stat_Inv)this.inv).DRGN_ID = dragon.getID();
    }
//-----------------------------------------------------------------------------    
    public void reset() {
        if (this.level <= 2)
            this.level = 0;
    }
//-----------------------------------------------------------------------------
/******************************************************************************/    
//-----------------------------------------------------------------------------
    private class Stat_Inv extends Inventory { 
        public int DRGN_ID;  

        public Stat_Inv(Item ... items) {
            super(items);
        }
        //---------------------------------------------------------------------
        @Override public boolean add(Item item) {
            if (item.toString().equals(CRYSTAL_ORB)) {
                Gal1_Dragon drgn = (Gal1_Dragon)Player.getRoomObj(Id.GAL1)
                        .getFurnRef(DRGN_ID);
                
                this.CONTENTS.add(item);
                
                if (drgn.isOn())
                    GUI.out(Gal2_Statue.this.useDialog 
                            + activate(drgn.getBeam()));
                else
                    GUI.out(Gal2_Statue.this.useDialog);
                
                return true;
            }
            else {
                GUI.out("The statue isn't supposed to be holding that.");
                return false;
            }
        }
        //---------------------------------------------------------------------
        @Override public void remove(Item removeThis) {  
            super.remove(removeThis);
            Gal1_Dragon drgn = (Gal1_Dragon)Player.getRoomObj(Id.GAL1)
                        .getFurnRef(DRGN_ID);
            
            if (drgn.isOn())
                GUI.out(activate(drgn.getBeam()));
        }
    }
//-----------------------------------------------------------------------------
/******************************************************************************/    
//-----------------------------------------------------------------------------    
}
