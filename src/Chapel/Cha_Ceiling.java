package Chapel;

import A_Super.Ceiling;
/**
 * @author Kevin Rapa
 */
public class Cha_Ceiling extends Ceiling {
    //-------------------------------------------------------------------------
    public Cha_Ceiling () {
        super();

        this.description = "The chapel ceiling is high and arched.";

        this.addNameKeys("(?:high )?(?:arched )?ceiling");
    }
    //------------------------------------------------------------------------- 
}


