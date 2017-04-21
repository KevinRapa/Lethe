package Crypt;

import A_Main.Id;
import A_Main.Names;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Cry1_Statue extends Statue implements Resetable {
    private boolean hasScythe, eyesGlowing;
    private final Furniture SCYTHE_REF;
    //-------------------------------------------------------------------------
    public Cry1_Statue (Furniture scythe) {
        super();
        
        this.hasScythe = this.eyesGlowing = false;
        
        this.SCYTHE_REF = scythe;
        
        this.useDialog = "You place the scythe into the statue's left hand.";
        this.description = "The tall statue stands in the center of this side "
                         + "of the room. The statue is cloaked with a skull for "
                         + "a head and stares at you. It holds one of its boney hands up as if it were "
                         + "grasping something, though its palm is empty. With the other "
                         + "palm it reaches out openly towards you.";
        
        this.addNameKeys("(?:tall )?(?:stone )?(?:cloaked )?statue", "(?:statue(?:'s)? )?(?:bone?y )?(?:hand|palm)");
        this.addUseKeys(Names.SCYTHE);
        this.addActKeys("shake", "embrace", "greet", "hold", "grasp", 
                        "push", "pull", "move", "turn", "twist");
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        String result;
        
        if (! this.hasScythe)
            result =  this.description;
        else
            result = this.description.replaceFirst(
                    "one of its boney hands up as if it were grasping something, though its palm is empty", 
                    "a scythe in one hand");
        
        if (this.eyesGlowing)
            return result.concat(" It's eyeholes glow with an orange light.");
        else
            return result;
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) { 
        if (key.matches(MOVEPATTERN) || key.matches("touch|feel"))
            return super.interact(key);
        else {
            if (this.hasScythe) {
                this.eyesGlowing = true;
                return "You grasp the statue's right hand and twist. An orange "
                     + "light glows deep in the statue's eyes.";
            }
            else {
                return "You grasp the statue's right hand and twist. Nothing happens.";
            }
        }
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        Player.getInv().remove(item);
        this.hasScythe = true;
        return this.useDialog;
    }
    //-------------------------------------------------------------------------     
    @Override public void reset() {
        if (this.hasScythe) {
            Player.getRoomObj(Id.TORC).addFurniture(SCYTHE_REF);
            this.hasScythe = false;
        }
        this.eyesGlowing = false;
    }
    //-------------------------------------------------------------------------     
    public boolean isSolved() {
        return this.eyesGlowing; 
    }
    //-------------------------------------------------------------------------     
}


