package A_Super;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Main.Player;
/**
 * Potted plants give special items when watered.
 * 
 * @author Kevin Rapa
 */
abstract public class PottedPlant extends SearchableFurniture
        implements Gettable, Moveable {
    protected final Item SOIL_REF, GIFT;
    protected boolean watered;
    //-------------------------------------------------------------------------
    public PottedPlant (Item soil, Item gift) {
        super();
        
        this.watered = false;
        this.GIFT = gift; // When watered for the first time, this is given to the player.
        this.SOIL_REF = soil;
        
        this.actDialog = "You pour a bit of the water on the plant. "
                + "The plant trembles some and a bit of life springs back to it. ";
        this.searchDialog = "You fan through the soil.";
        this.useDialog = "Pouring that on the plant is definitely not going to "
                       + "be good for it, you monster.";

        this.addNameKeys("dirt", SOIL, "(?:potted )?plants?");
        this.addUseKeys(ANYTHING);
        this.addActKeys(GETPATTERN, "water", "dig");
        
        this.inv.add(soil); 
        this.inv.add(soil); 
        this.inv.add(soil);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("water")) {
            if (Player.hasItem(BUCKET_OF_WATER)) {
                if (watered) 
                    return this.actDialog;
                else {
                    this.inv.add(GIFT);
                    this.watered = true;
                    return this.actDialog.concat("A small object rises from the soil and now rests on top.");
                }
            }
            else 
                return "You have nothing to water the plant with.";
        }
        else if (key.equals("dig")) {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
                AudioPlayer.playEffect(34);
                return "Digging in the plant reveals nothing unusual.";
            }
            else
                return "You have nothing sufficient to dig with, and your "
                     + "stocky hands are terrible for digging.";
        }
        else
            return getIt();
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(BUCKET_OF_WATER))
            return this.interact("water");
        else if (item.getType().equals(LIQUID))
            return this.useDialog;
        else if (item.getType().equals(WEAPON))
            return "Attacking the plant isn't going to solve any of your problems.";
        else if (item.toString().equals(SHOVEL) || item.toString().equals(TROWEL)) {
            AudioPlayer.playEffect(34);
            return "Digging in the plant reveals nothing unusual.";
        }
        else if (item.toString().equals(SOIL)) {
            Player.getInv().remove(item);
            return "You return the soil to the plant.";
        }
        else
            return DEFAULT_USE;
    }
    //-------------------------------------------------------------------------  
    @Override public String getIt() {
        if (Player.getInv().add(SOIL_REF))
            return "You scoop up some of the dirt.";
        else
            return "You already have some dirt.";
    }
    //-------------------------------------------------------------------------  
}


