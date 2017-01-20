package West_Outer_Wall;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Wow3_NorthDoor extends Furniture {
    // ========================================================================
    public Wow3_NorthDoor () {
        super();
        this.searchable = false;
        
        this.description = "The door is hopelessly blocked by the large shelf.";
        this.actDialog = this.description;

        this.addNameKeys("north door");
        this.addActKeys("open", "use");
    }
    // ========================================================================  
}


