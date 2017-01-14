package Catacombs;
/**
 * The catacombs comprise a maze of similar tunnels.
 * Each catacomb generates its own description, and will be described
 * differently depending on if the player is holding a torch.
 * 
 * @author Kevin Rapa
 */
import A_Main.Player;
import A_Super.Direction;
import A_Super.Floor;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Room;
import A_Super.Wall;
import java.util.ArrayList;
import java.util.Random;

public class Catacomb extends Room {
    protected String descLit;
    protected static final Random GENERATOR = new Random();
    protected static int[] jewelCoords;
// ============================================================================    
    public Catacomb(String ID) {
        super("in the catacombs", ID);
        this.description = "This area is pitch black. Feeling around, you sense\n"
                         + "that you are in a rocky tunnel barely larger than you.\n"
                         + "A low breeze and sporadic droplets of water are all that\n"
                         + "you hear. You suspect you are in a cave of sorts. If\n"
                         + "only you had a light...";
        
        this.descLit = "The torch offers a small radius of light to see. You\n"
                     + "are in a thin rocky tunnel with scattered crevices dug\n"
                     + "into the walls. These are definitely graves. You shudder,\n"
                     + "perhaps from the cold... To your ";
        
        /* 
           Builds the lit description of the room. Here, the constructor figures
           out what is in each direction of the catacombs. The description will
           reflect if there if empty space or a door in any direction.
        */
        
        int X = COORDS[2], Y = COORDS[1]; // X and Y coordinates of this room.

        // List of X and Y coordinates of the adjacent catacomb rooms.
        ArrayList<int[]> adjCatacombCoords = new ArrayList<>();
        
        // The X and Y coordinates of a non-catacomb room adjacent to this.
        int[] adjOtherCoords = null;
        
        // Holds directions to append to descLit.
        ArrayList<String> dirs = new ArrayList<>();
        
        for (String i : this.adjacent) {
            int[] coords = {i.charAt(2) - '0', 
                            i.charAt(3) - '0'};
            
            if (i.matches("CT\\d{2}")) // Is catacomb.
                adjCatacombCoords.add(coords);
            else                       // Isn't catacomb.
                adjOtherCoords = coords;
        }
        
        // Figures out the directions in which there are more catacombs.
        for (int[] j : adjCatacombCoords) {
            if (j[0] == Y - 1)
                dirs.add("north");
            else if (j[0] == Y + 1)
                dirs.add("south");
            else if (j[1] == X - 1)
                dirs.add("west");
            else if (j[1] == X + 1)
                dirs.add("east");
        }

        // Appends the correct directions to descLit.
        switch (dirs.size()) {
            case 1:
                descLit = descLit.concat(dirs.get(0));
                break;
            case 2:
                descLit = descLit.concat(dirs.get(0) + " and " + dirs.get(1));
                break;
            default:
                int i; 
                for (i = 0; i < dirs.size() - 1; i++)
                    descLit = descLit.concat(dirs.get(i) + ", ");
                
                descLit = descLit.concat("and " + dirs.get(i));
        }
        
        descLit = descLit.concat(", the tunnel veers into darkness. ");
        
        // Appends additional information if a non-catacomb room is adjacent.
        // Adds a door to room.
        if (adjOtherCoords != null) {
            if (adjOtherCoords[0] == Y - 1) {
                descLit = descLit.concat("To the north");
                this.addFurniture(new Ct_Dr(Direction.NORTH));
            }
            else if (adjOtherCoords[0] == Y + 1){
                descLit = descLit.concat("To the south");
                this.addFurniture(new Ct_Dr(Direction.SOUTH));
            }
            else if (adjOtherCoords[1] == X - 1) {
                descLit = descLit.concat("To the west");
                this.addFurniture(new Ct_Dr(Direction.WEST));
            }
            else {
                descLit = descLit.concat("To the east");
                this.addFurniture(new Ct_Dr(Direction.EAST));
            }
            
            descLit = descLit.concat(", erected unevenly into the tunnel wall is an ancient door.");
        }
        
        // Puts a crevice furniture objects in here and adds items to it randomly.
        Furniture ctGrv = new Ct_Grv();
        Item[] itemList = {
            new Item("dirt", "It's a damp, cold pile of rocky dirt"),
            new Item("bone", "It's a bone... not much else to say."),
            new Item("rock", "It's a normal hunk of rock that was mixed with the dirt.") 
        };
        
        int numTimes = GENERATOR.nextInt(5) + 3;
        
        for (int start = 1; start <= numTimes; start++) 
            ctGrv.getInv().add(itemList[GENERATOR.nextInt(3)]);

        this.addFurniture(ctGrv, new Floor("It's a damp dirt floor."), new Wall("The walls are wet and rocky."));
    }
// ============================================================================
    @Override public String getDescription() {
        if (Player.hasItem("hand torch"))
            return this.descLit;
        else
            return this.description;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (Player.hasItem("hand torch"))
            return "You are " + this + ".";
        else
            return "???";
    }
// ============================================================================
    public static String addJewelRandomly(Room[][][] map) {
        int x, y;
        Room target;
        
        do {
            x = GENERATOR.nextInt(8) + 1;
            y = GENERATOR.nextInt(6) + 1;
            target = Player.getRoomObj(5, y, x);
        } while (! target.getID().matches("CT\\d{2}"));
        
        target.getFurnishings().get(0).getInv().add(new Item("iridescent jewel", "The polished stone feels warm to the touch,\n"
                                                           + "and is constantly shifting color among red, black, and green."));
        
        return (x + ", " + y + ", " + 6);
    }
// ============================================================================
}