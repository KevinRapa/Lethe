package Workshop;

import static A_Main.NameConstants.*;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Wrk_Kln extends Furniture {
    private final Item REFGLSSR, REFGLSSB, REFGLSSY;
    private boolean hasSand, hasRedDye, hasBlueDye, hasYllwDye, hasPotash;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_Kln() {
        super();
        
        this.REFGLSSR = new Item(MOLTEN_RED_GLASS, "It's a crucible of molten red glass. Be careful!");
        this.REFGLSSB = new Item(MOLTEN_BLUE_GLASS, "It's a crucible of molten blue glass. Be careful!");
        this.REFGLSSY = new Item(MOLTEN_YELLOW_GLASS, "It's a crucible of molten yellow glass. Be careful!");
        
        this.searchable = false;
        
        hasSand = hasPotash = hasRedDye = hasBlueDye = hasYllwDye = false;
       
        this.description = "The kiln resembles a ceramic oven. Its intense heat\n" +
                           "keeps this room roasting hot.";
        
        this.addUseKeys(RED_DYE, YELLOW_DYE, BLUE_DYE, SAND, POTASH);
        this.addNameKeys("kiln", "(?:ceramic )?oven");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = null;
        String name = item.toString();
        
        if (name.equals(POTASH) && ! this.hasPotash) {
            Player.getInv().remove(item);
            this.hasPotash = true;
            rep = "You pour the potash into the crucible.";  
        }    
        else if (name.equals(SAND) && ! this.hasSand) {
            Player.getInv().remove(item);
            this.hasSand = true;
            rep = "You pour the sand into the crucible.";
        }
        else if ((name.matches("\\w+ dye")) && ! hasDye()) {
            Player.getInv().remove(item);
            
            switch (name) {
                case RED_DYE:
                    this.hasRedDye = true; break;
                case BLUE_DYE:
                    this.hasBlueDye = true; break;
                case YELLOW_DYE:
                    this.hasYllwDye = true; break;
            }
            rep = "You pour the " + name + " into the crucible.";
        }
        else if ((name.equals(SAND) && this.hasSand) ||
                 (name.equals(POTASH) && this.hasPotash) ) 
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
