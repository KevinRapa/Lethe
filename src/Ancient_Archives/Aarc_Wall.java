package Ancient_Archives;
/**
 * @author Kevin Rapa
 */
public class Aarc_Wall extends Aarc_Furniture {
    // ========================================================================
    public Aarc_Wall () {
        super();
        this.searchable = false;
        
        this.description = "The cobblestone walls are wet and covered in algae\n"
                         + "a third the way up.";

        this.addNameKeys("(?:cobblestone )?walls?");
    }
    // ========================================================================    
}


