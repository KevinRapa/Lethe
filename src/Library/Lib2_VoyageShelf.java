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
    private final int WARFARE, CREATION, PERDITION, BANISHMENT;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_VoyageShelf(Furniture wrfr, Furniture crtn, Furniture prdtn, 
            Furniture bnshmnt, Item... items) 
    {
        super(items);
        
        this.WARFARE = wrfr.getID();
        this.CREATION = crtn.getID();
        this.PERDITION = prdtn.getID();
        this.BANISHMENT = bnshmnt.getID();
        
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.description = "The tall bookshelf bears a plaque on the top reading "
                         + "\"Voyage\". At its base on the right, you notice "
                         + "consistent arched scratches on the floor.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("voyage", "(?:west|left) (?:(?:book)?shelf|one)");
        this.addActKeys(MOVEPATTERN);
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) { 
        Room lib2 = Player.getRoomObj(Id.LIB2);
        Furniture wrfr = Player.getRoomObj(Id.LIB2).getFurnRef(WARFARE);
        Furniture crtn = Player.getRoomObj(Id.LIB3).getFurnRef(CREATION);
        Furniture perd = Player.getRoomObj(Id.LIB4).getFurnRef(PERDITION);
        Furniture bnsh = Player.getRoomObj(Id.LIB5).getFurnRef(BANISHMENT);
        
        if (this.containsItem(ODYSSEY) && wrfr.containsItem(ILIAD) 
                && crtn.containsItem(BIBLE) && perd.containsItem(DANTES_INFERNO) 
                && bnsh.containsItem(PARADISE_LOST) && ! lib2.isAdjacent(Id.LIB1)) 
        {
            lib2.addAdjacent(Id.LIB1);
            AudioPlayer.playEffect(41);       
            return "You push against the shelf. To your wonder, the shelf slowly "
                 + "swivels clockwise on its center axis, revealing a hidden room.";
        }
        else
            return this.actDialog;          
    }
//-----------------------------------------------------------------------------   
}
