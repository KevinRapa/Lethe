package Ransacked_Quarters;

import A_Super.NonPlayerCharacter;
/**
 * @author Kevin Rapa
 */
public class Rqua_WomanNPC extends NonPlayerCharacter {
    // ========================================================================
    public Rqua_WomanNPC () {
        super();
        this.searchable = false;
        
        this.description = "The elderly woman sits on the floor in a corner "
                         + "garbed in black robes which cover all her body save "
                         + "her face. She keeps her unsettling glare on you and "
                         + "laughs quietly to herself.";
        this.actDialog = "*A deranged laugh* \"We all forget!!!! Why measure oneself "
                       + "with inpalpable knowledge when we have our wealth???? Eury "
                       + "does not know my secret!!! All his riches can be mine at my "
                       + "pleasure!!!! Hell treats the wealthy comfortably and the wise "
                       + "with contempt!!!!\"";
        this.searchDialog = "Approaching her seems like a dangerous thing to do.";

        this.addNameKeys("(?:elderly )?(?:laughing )?(?:robed )?woman", "her");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (this.firstTime) {
            this.firstTime = false;
            return converse1();
        }
        else
            return converse2();
    }
    // ========================================================================     
    @Override protected String converse1() {
        return actDialog;
    }
    // ========================================================================     
    @Override protected String converse2() {
        return "Hell treats the wealthy comfortably and the wise with contempt!!!\"";
    }
}


