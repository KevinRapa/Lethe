package A_Super;
/**
 * Referenced in case player tries to interact with generic furniture by typing
 * "furniture" or "furnishings"
 * 
 * @author Kevin Rapa
 */
public class GenericFurniture extends Furniture {
    // ========================================================================
    public GenericFurniture (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "There's lots of stuff and many things in the foreign\n"
                         + "room. You pace around, mesmerized by the many things.";
        this.actDialog = "You are going to need to be more specific.";
        this.searchDialog = "You aren't sure what thing to search first.";
        this.useDialog = this.actDialog;

        this.addNameKeys("furniture|furnishings|stuff|things");
        this.addUseKeys(".+");
        this.addActKeys(".+");
    }
    // ========================================================================          
}


