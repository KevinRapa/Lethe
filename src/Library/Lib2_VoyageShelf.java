package Library;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.SearchableFurniture;

import static A_Main.Names.BIBLE;
import static A_Main.Names.DANTES_INFERNO;
import static A_Main.Names.ILIAD;
import static A_Main.Names.ODYSSEY;
import static A_Main.Names.PARADISE_LOST;
import A_Super.Room;
        
public class Lib2_VoyageShelf extends SearchableFurniture {
    private final Furniture WARFARE, CREATION, PERDITION, BANISHMENT;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_VoyageShelf(Furniture wrfr, Furniture crtn, Furniture prdtn, 
            Furniture bnshmnt, Item... items) 
    {
        super(items);
        
        this.WARFARE = wrfr;
        this.CREATION = crtn;
        this.PERDITION = prdtn;
        this.BANISHMENT = bnshmnt;
        
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Voyage\". At its base on the right, you notice\n"
                         + "consistent arched scratches on the floor.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("voyage", "(?:west|left) (?:(?:book)?shelf|one)");
        this.addActKeys(MOVEPATTERN);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        Room lib2 = Player.getRoomObj(Id.LIB2);
        
        if (this.containsItem(ODYSSEY)  
            && WARFARE.containsItem(ILIAD) 
            && CREATION.containsItem(BIBLE)    
            && PERDITION.containsItem(DANTES_INFERNO) 
            && BANISHMENT.containsItem(PARADISE_LOST) 
            && ! lib2.isAdjacent(Id.LIB1)) 
        {
            lib2.addAdjacent(Id.LIB1);
            AudioPlayer.playEffect(41);       
            return "You push against the shelf. To your wonder, the shelf slowly\n"
                 + "swivels clockwise on its center axis, revealing a hidden room.";
        }
        else
            return this.actDialog;          
    }
/*----------------------------------------------------------------------------*/   
}
