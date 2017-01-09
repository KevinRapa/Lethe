package Caves;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Dummy_Furniture extends Furniture {

    // ========================================================================
    public Dummy_Furniture (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "a5 ojkvjkljelzx sf093knf k4kgjg094ng nvkjrhniog9 9ug\n"
                         + "fe 0e08 fjkSEJKO f0ej HEWBK9 jfe90 kfjnks FLeosj selg\n"
                         + "wnmf 9f pg e9kf ;smn kfejp0fuesi3 ,n kk34p uofej9 yhfhbe.";
        
        this.addNameKeys(".+");
        this.addUseKeys(".+");
        this.addActKeys(".+");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return Cave.distortDescription(1, this.description);
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        return this.getDescription();
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        return this.getDescription();
    }
    // ========================================================================     
}


