package Black_Staircase;

import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Bls1_Statue extends Statue {
    //-------------------------------------------------------------------------
    public Bls1_Statue () {
        super();
        
        this.description = "The black statue depicts a malevolent-looking male "
                         + "holding a scepter and a chalice.";

        this.addNameKeys("(?:black )?statue");
    }
    //-------------------------------------------------------------------------     
}


