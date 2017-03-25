package Torture_Chamber;

import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Torc_Wheel extends SearchableFurniture implements Unmoveable {
    // ========================================================================
    public Torc_Wheel () {
        super();
        
        this.description = "The large wooden wheel is about 6 feet in diameter.\n"
                         + "The wheel has many small nicks and gashes on its\n"
                         + "surface, and many pegs stick out towards you around its\n"
                         + "edge. It is suspended from a stand and looks\n"
                         + "rotatable.";
        this.actDialog = "You give the wheel a spin. It squeaks as it turns and\n"
                       + "quiets down slowly as the wheel comes to a halt.";
        this.searchDialog = "You look behind the wheel.";

        this.addNameKeys("(?:large )?(?:vertical )?(?:wooden )?wheel", "pegs?");
        this.addActKeys("rotate", "spin", "turn");
    }
    // ========================================================================      
}


