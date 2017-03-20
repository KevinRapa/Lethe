package Courtyard;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Room;
/**
 * First room entered by the player. 
 * Only room from which the inside of the castle may be accessed.
 * @author Kevin Rapa
 */
public class Cou3 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3(String name, String ID) {
        super(name, ID);
        description= 
                "You're in the center of an overgrown courtyard, just in\n" +
                 "front of the main gate. You are surrounded on all sides\n" +
                 "by the fortress-like castle wall. Before you climbs a\n" +
                 "great set of crumbling steps to the castle's entrance.\n" +
                 "There is a fork in the path leading left and right, wrapping\n" +
                 "around to the sides of the steps. Ivy grows rampantly\n" +
                 "on and over everything and ravens dart through the air\n"
               + "every now and then.";
        
        this.addFurniture(new Cou_Fork());
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID)) {
            AudioPlayer.playEffect(7);
            GUI.out("As you walk into the front courtyard, the huge gates\n"
                + "slowly swing shut behind you.");
        }               
        return STD_RM_OUT;
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
    public class Cou_Fork extends Furniture {
        private final Item FORK;
        // ====================================================================
        public Cou_Fork () {
            super();
            
            this.FORK = new Item("golden fork", "The magnificent fork of gold "
                    + "has been carved with the finest attention to detail. "
                    + "A large pearl is set into the end of the handle, and many "
                    + "small scapolite gems descorate the rest of it.", 500);

            this.actDialog = "A clever decision by the player is rewarded with a "
                    + "breathtaking treasure of artisanal mastery.";
            this.description = "The fork in the path leads to both the left "
                    + "and right halves of the courtyard.";

            this.addNameKeys("fork");
            this.addActKeys(GETPATTERN);
        }
        // ====================================================================   
        @Override public String interact(String key) {  
            if (Player.getInv().add(FORK)) {
                Player.getPos().removeFurniture(this);
                return this.actDialog;
            }
            else
                return NOTHING;
        }
        // ====================================================================      
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
}

