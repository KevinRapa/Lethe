package Oubliette;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Ou62_Spike extends Furniture {
    // ========================================================================
    public Ou62_Spike () {
        super();
        this.searchable = false;
        
        this.description = "The spike is made of iron and is quite sharp.\n"
                         + "It protrudes out the center of the room, though\n"
                         + "it doesn't seem as though one would fall on this\n"
                         + "if pushed into here.";

        this.addNameKeys("(?:sharp )?(?:iron )?spike");
    }
    // ========================================================================    
}


