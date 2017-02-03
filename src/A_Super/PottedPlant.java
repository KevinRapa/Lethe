package A_Super;

import static A_Main.NameConstants.BUCKET_OF_WATER;
import static A_Main.NameConstants.LIQUID;
import static A_Main.NameConstants.SOIL;
import static A_Main.NameConstants.WEAPON;
import A_Main.Player;
/**
 * @author Kevin Rapa
 */
abstract public class PottedPlant extends SearchableFurniture 
        implements Gettable {
    private final Item SOIL_REF;
    // ========================================================================
    public PottedPlant (Item soil) {
        super();
        
        this.SOIL_REF = soil;
        
        this.actDialog = "You pour a bit of the water on the plant. You are sure\n"
                       + "it appreciated that.";
        this.searchDialog = "You fan through the soil.";
        this.useDialog = "Pouring that on the plant is definitely not going to\n"
                       + "be good for it, you monster.";

        this.addNameKeys("dirt", SOIL, "(?:potted )?plants?");
        this.addUseKeys(ANYTHING);
        this.addActKeys(GETPATTERN);
        this.addActKeys("water");
        
        this.inv.add(soil); 
        this.inv.add(soil); 
        this.inv.add(soil);
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("water"))
            if (Player.hasItem(BUCKET_OF_WATER))
                return this.actDialog;
            else 
                return "You have nothing to water the plant with.";
        else
            return getIt();
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(BUCKET_OF_WATER))
            return this.actDialog;
        else if (item.getType().equals(LIQUID))
            return this.useDialog;
        else if (item.getType().equals(WEAPON))
            return "Attacking the plant isn't going to solve any of your problems.";
        else if (item.toString().equals(SOIL)) {
            Player.getInv().remove(item);
            return "You return the soil to the plant.";
        }
        else
            return DEFAULT_USE;
    }
    // ========================================================================  
    @Override public String getIt() {
        if (Player.getInv().add(SOIL_REF))
            return "You scoop up some of the dirt.";
        else
            return "You already have some dirt.";
    }
    // ========================================================================  
}


