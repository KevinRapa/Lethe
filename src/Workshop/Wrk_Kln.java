package Workshop;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Wrk_Kln extends Furniture {
    private final Item REFGLSSR, REFGLSSB, REFGLSSY;
    private boolean hasSand, hasRedDye, hasBlueDye, hasYllwDye, hasPotash;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_Kln() {
        super();
        
        this.REFGLSSR = new Item("molten red glass", "It's a crucible of molten red glass. Be careful!");
        this.REFGLSSB = new Item("molten blue glass", "It's a crucible of molten blue glass. Be careful!");
        this.REFGLSSY = new Item("molten yellow glass", "It's a crucible of molten yellow glass. Be careful!");
        
        this.searchable = false;
        
        hasSand = hasPotash = hasRedDye = hasBlueDye = hasYllwDye = false;
       
        this.description = "The kiln resembles a ceramic oven. Its intense heat\n" +
                           "keeps this room roasting hot.";
        
        this.addUseKeys("(red dye", "yellow dye", "blue dye", "sand", "potash");
        this.addNameKeys("kiln", "(?:ceramic )?oven");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = null;
        String name = item.toString();
        
        Player.getInv().remove(item);
        
        if (name.matches("potash") && ! this.hasPotash) {
            this.hasPotash = true;
            rep = "You pour the potash into the crucible.";  
        }    
        else if (name.matches("sand") && ! this.hasSand) {
            this.hasSand = true;
            rep = "You pour the sand into the crucible.";
        }
        else if ((name.matches("\\w+ dye")) && ! hasDye()) {
            if (name.matches("red dye")) {
                this.hasRedDye = true;
            }
            else if (name.matches("blue dye")) {
                this.hasBlueDye = true;
            }
            else if (name.matches("yellow dye")) {
                this.hasYllwDye = true;
            }   
            rep = "You pour the " + name + " into the crucible.";
        }
        else if ((name.matches("sand") && this.hasSand) ||
                 (name.matches("potash") && this.hasPotash) ) 
            rep = "The kiln already has " + name + " in it!";
        
        else if ((name.matches("(?:red|blue|yellow) dye")) && hasDye())
            rep = "The kiln already has dye in it!";
        
        
        if (hasDye() && this.hasSand && this.hasPotash)
            rep += this.makeGlass();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String makeGlass() {
        String color;
        
        if (this.hasRedDye) {
            Player.getInv().add(REFGLSSR);
            this.hasRedDye = false;
            color = "red";
        }
        else if (this.hasBlueDye) {
            Player.getInv().add(REFGLSSB);
            this.hasBlueDye = false;
            color = "blue";
        }
        else {
            Player.getInv().add(REFGLSSY);
            this.hasYllwDye = false;
            color = "yellow";
        }
        this.hasSand = false;
        this.hasPotash = false;
        
        return "You let the sand and the " + color + " dye bake for a bit. In no\n"
             + "time, the mixture has blended into hot molten " + color + " glass.\n"
             + "Delicious! You take the hot crucible of " + color + " glass.";
    }
/*----------------------------------------------------------------------------*/
    private boolean hasDye() {
        return this.hasBlueDye || hasRedDye || hasYllwDye;
    }
/*----------------------------------------------------------------------------*/
}
