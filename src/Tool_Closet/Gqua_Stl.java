package Tool_Closet;

import Super.Furniture;

public class Gqua_Stl extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Stl(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a puny three-legged stool.";
        this.searchDialog = "There's nothing here.";
        this.interactDialog = "You sit in the tiny stool. It makes you feel even more\n"
                    + "insecure about your weight.";
        this.addNameKeys("stool");
        this.addActKeys("sit");
    }
}
