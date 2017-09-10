package Garden;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.SHOVEL;
import static A_Main.Names.SOIL;
import static A_Main.Names.TROWEL;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Gar4_Planter extends SearchableFurniture implements Unmoveable {
    private final int PLQ_ID;
    private final Item PLT_REF;
    //-------------------------------------------------------------------------
    public Gar4_Planter (Furniture plaque, Item plate, Item... items) {
        super(items);
        this.PLQ_ID = plaque.getID();
        this.PLT_REF = plate;
        this.description = "This planter contains no plants, just a bed of soil.";
        this.actDialog = "You dig around the plaque, but find nothing in the soil.";
        this.searchDialog = "The soil's surface is bare and hides nothing.";
        this.useDialog = this.actDialog;

        this.addNameKeys("planter", "(?:bed of )?(?:soil|dirt)", "bed|dirt", SOIL);
        this.addUseKeys(SHOVEL, TROWEL);
        this.addActKeys(GETPATTERN);
        this.addActKeys("dig", "plant", "garden", "shovel");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {      
        if (key.equals("garden") || key.equals("plant")) {
           return "You aren't a gardener!";
        }
        else {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
                Gar4_Plaque p = (Gar4_Plaque)Player.getRoomObj(Id.GAL4).getFurnRef(PLQ_ID);
                
                if (p.isMoved()) {
                    if (inv.contains(PLT_REF)) {
                        if(inv.give(PLT_REF, Player.getInv())) {
                            AudioPlayer.playEffect(34);
                            return "You dig under where the plaque was to find a shiny plate!";
                        }
                        else {
                            return "You find a shiny plate under the dirt, but you are carrying too much stuff!";
                        }
                    }
                    else {
                        return "You have already dug under the plaque";
                    }
                }
                else {
                    AudioPlayer.playEffect(34);
                    return this.actDialog;
                }
            }
            else {
                return "You have nothing to dig with, and your stocky hands are terrible for digging.";
            }
        }
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        return this.interact("dig");
    }
    //-------------------------------------------------------------------------     
    @Override public String getSearchDialog() {
        Gar4_Plaque p = (Gar4_Plaque)Player.getRoomObj(Id.GAR4).getFurnRef(PLQ_ID);
        this.searchable = p.isMoved();
        return searchable ? "You look in the planter" : this.searchDialog;
    }
    //-------------------------------------------------------------------------     
}


