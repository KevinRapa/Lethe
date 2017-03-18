package Prison;

import A_Super.NonPlayerCharacter;
/**
 * @author Kevin Rapa
 */
public class Pris_Ghost extends NonPlayerCharacter {
    // ========================================================================
    public Pris_Ghost () {
        super();

        this.description = "";
        this.actDialog = "";
        this.searchDialog = "The ghost looks to not have anything interesting.";

        this.addNameKeys("(?:sitting )?(?:ghost|figure|person)");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        return null;
    }
    // ========================================================================     
    @Override protected String converse1() {
        return null;
    }
    // ========================================================================     
    @Override protected String converse2() {
        return null;
    }
    // ========================================================================     
}


