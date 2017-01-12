package Caves;
/**
 * Contains a well which is related to story.
 * 
 * @author Kevin Rapa
 */
public class CV34 extends Cave {
// ============================================================================    
    public CV34(String name, String ID) {
        super(ID);
        this.description = "You found your way to an open area... There's something\n"
                         + "in the center. It feels stone and round and is empty\n"
                         + "in the center.";
        this.descLit = descLit.concat("This area is more open and circular than\n"
                                    + "the rest of the cave. A round well stands\n"
                                    + "in the center. Why would this be down here?");
    }
// ============================================================================
}