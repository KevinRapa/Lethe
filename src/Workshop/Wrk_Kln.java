package Workshop;

import Super.Furniture;
import Super.Item;
import Main.Inventory;

public class Wrk_Kln extends Furniture {
    private final Inventory REFPLYR;
    private final Item REFGLSSR, REFGLSSB, REFGLSSY;
    private boolean hasSand, hasDye, hasRedDye, hasBlueDye, hasYllwDye, hasPotash;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_Kln(Inventory plyrInv, Item glssR, Item glssY, Item glssB) {
        super();
        this.REFPLYR = plyrInv;
        this.REFGLSSR = glssR; this.REFGLSSB = glssB; this.REFGLSSY = glssY;
        
        this.searchable = false;
        
        this.hasSand = false; this.hasPotash = false; this.hasDye = false;
        this.hasRedDye = false; this.hasBlueDye = false; this.hasYllwDye = false;
        
        this.description = "The kiln resembles a ceramic oven. Its intense heat\n" +
                           "keeps this room roasting hot.";
        
        this.addUseKeys("red dye", "yellow dye", "blue dye", "sand", "potash");
        this.addNameKeys("kiln", "oven", "ceramic oven");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = null;
        
        this.REFPLYR.remove(item);
        
        if (item.toString().matches("potash") && ! this.hasPotash) {
            this.hasPotash = true;
            rep = "You pour the potash into the crucible.";  
        }        
        else if (item.toString().matches("sand") && ! this.hasSand) {
            this.hasSand = true;
            rep = "You pour the sand into the crucible.";
        }
        else if ((item.toString().matches("(?:red|blue|yellow) dye")) && ! this.hasDye) {
            this.hasDye = true;
            
            if (item.toString().matches("red dye")) {
                this.hasRedDye = true;
            }
            else if (item.toString().matches("blue dye")) {
                this.hasBlueDye = true;
            }
            else if (item.toString().matches("yellow dye")) {
                this.hasYllwDye = true;
            }   
            rep = "You pour the " + item + " into the crucible.";
        }
        else if ((item.toString().matches("sand") && this.hasSand) ||
                 (item.toString().matches("potash") && this.hasPotash) ) 
            rep = "The kiln already has " + item + " in it!";
        
        else if ((item.toString().matches("(?:red|blue|yellow) dye")) && this.hasDye)
            rep = "The kiln already has dye in it!";
        
        
        if (this.hasDye && this.hasSand && this.hasPotash)
                rep += this.makeGlass();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String makeGlass() {
        String color = null;
        
        if (this.hasRedDye) {
            this.REFPLYR.add(REFGLSSR);
            this.hasRedDye = false;
            color = "red";
        }
        else if (this.hasBlueDye) {
            this.REFPLYR.add(REFGLSSB);
            this.hasBlueDye = false;
            color = "blue";
        }
        else if (this.hasYllwDye) {
            this.REFPLYR.add(REFGLSSY);
            this.hasYllwDye = false;
            color = "yellow";
        }
        this.hasSand = false;
        this.hasDye = false;
        this.hasPotash = false;
        
        return "You let the sand and the " + color + " dye bake for a bit. In no\n"
             + "time, the mixture has blended into hot molten " + color + " glass.\n"
             + "Delicious! You take the hot crucible of " + color + " glass.";
    }
/*----------------------------------------------------------------------------*/
}
