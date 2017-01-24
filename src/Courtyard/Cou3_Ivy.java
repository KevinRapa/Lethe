package Courtyard;

import A_Main.Player;

/**
 * @author Kevin Rapa
 */
public class Cou3_Ivy extends Courtyard_Growth {
    // ========================================================================       
    public Cou3_Ivy() {
        super();

        this.description = "European ivy grows rampantly over everything.";
        this.searchDialog = "It's just plain old Hedera helix.";
        this.cutDialog = "It's no use cutting it. It will just grow back.";
        this.actDialog = "It's no use ripping this off; it will just grow back.";
        this.addActKeys("climb");
        this.addNameKeys("(?:european )?ivy", "hedera helix");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches("grab|touch|hold"))
            return this.actDialog;
        else if (key.equals("climb"))
            return "You are too heavy. This will never support you!";
        else if (Player.hasItemResembling("axe|sword|scythe"))
            return this.cutDialog;
        else
            return "You have nothing to cut it up with.";
    }
    // ========================================================================   
}
