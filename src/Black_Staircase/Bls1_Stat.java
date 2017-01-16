package Black_Staircase;

import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Bls1_Stat extends Statue {
    // ========================================================================
    public Bls1_Stat () {
        super();
        
        this.description = "The black statue depicts a malevolent-looking male\n"
                         + "holding a scepter and a chalice.";

        this.addNameKeys("(?:black )?statue");
    }
    // ========================================================================     
}


