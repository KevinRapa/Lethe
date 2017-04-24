package Catacombs;

import A_Main.Player;
import static A_Main.Names.HAND_TORCH;
import static A_Main.Names.ROCK;
import A_Super.Direction;
import A_Super.Floor;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Room;
import java.util.ArrayList;
import java.util.Random;
/**
 * The catacombs comprise a maze of similar tunnels.
 * Each catacomb generates its own description, and will be described
 * differently depending on if the player is holding a torch.
 * 
 * @author Kevin Rapa
 */
public class Catacomb extends Room {
    protected String descLit;

    private static final Item[] ITEM_LIST = {
        new Item("dirt", "It's a damp, cold pile of rocky dirt", -50), 
        new Item("bone", "It's a bone... not much else to say.", -50), 
        new Item(ROCK, "It's a normal hunk of rock that was mixed with the dirt.", -50)
    };
    
    protected static final Random GENERATOR = new Random();
    protected static int[] jewelCoords;
//-----------------------------------------------------------------------------    
    public Catacomb(String ID, Furniture wall, Furniture ceiling) {
        super("Catacombs", ID);

        StringBuilder builder = new StringBuilder(300);
        
        builder.append("The torch offers a small radius of light to see. You ")
               .append("are in a thin rocky tunnel with scattered crevices dug ")
               .append("into the walls. These are definitely graves. You shudder, ")
               .append("perhaps from the cold...                              ")
               .append("                                       To your ");
        
        /* 
           Builds the lit description of the room. Here, the constructor figures
           out what is in each direction of the catacombs. The description will
           reflect if there if empty space or a door in any direction.
        */
        int X = COORDS[2], Y = COORDS[1]; // X and Y coordinates of this room.

        // List of X and Y coordinates of the adjacent catacomb rooms.
        ArrayList<int[]> adjCatacombCoords = new ArrayList<>(3);
        
        // The X and Y coordinates of a non-catacomb room adjacent to this.
        int[] adjOtherCoords = null;
        
        // Holds directions to append to descLit.
        ArrayList<String> dirs = new ArrayList<>(4);

        for (String i : this.adjacent) {
            int[] coords = {i.charAt(2) - '0', 
                            i.charAt(3) - '0'};

            if (i.matches("CT\\d{2}")) // Is a catacomb tunnel.
                adjCatacombCoords.add(coords);
            else                       // Is a side room.
                adjOtherCoords = coords;
        }

        // Figures out the directions in which there are more catacombs.
        for (int[] j : adjCatacombCoords) {
            if (j[0] == Y - 1)
                dirs.add("NORTH");
            else if (j[0] == Y + 1)
                dirs.add("SOUTH");
            else if (j[1] == X - 1)
                dirs.add("WEST");
            else if (j[1] == X + 1)
                dirs.add("EAST");
        }

        // Appends the correct directions to descLit.
        switch (dirs.size()) {
            case 1:
                builder.append(dirs.get(0));
                break;
            case 2:
                builder.append(dirs.get(0)).append(" and ").append(dirs.get(1));
                break;
            default:
                int i; 
                for (i = 0; i < dirs.size() - 1; i++)
                    builder.append(dirs.get(i)).append(", ");

                builder.append("and ").append(dirs.get(i));
        }
        
        builder.append(", the tunnel veers into darkness. ");
        
        // Appends additional information if a non-catacomb room is adjacent.
        // Adds a door to room.
        Furniture door = null;
        
        if (adjOtherCoords != null) {
            if (adjOtherCoords[0] == Y - 1) {
                builder.append("To the NORTH");
                door = new Ct_Door(Direction.NORTH);
            }
            else if (adjOtherCoords[0] == Y + 1){
                builder.append("To the SOUTH");
                door = new Ct_Door(Direction.SOUTH);
            }
            else if (adjOtherCoords[1] == X - 1) {
                builder.append("To the WEST");
                door = new Ct_Door(Direction.WEST);
            }
            else {
                builder.append("To the EAST");
                door = new Ct_Door(Direction.EAST);
            }
            
            builder.append(", erected unevenly into the tunnel wall is an ancient door.");
        }

        this.descLit = builder.toString();
        
        // Puts a crevice furniture objects in here and adds items to it randomly.
        Furniture catGrv = new Ct_Grave();
        Furniture catF = new Floor("It's a damp, rocky, dirty floor.");
        
        int numTimes = GENERATOR.nextInt(5) + 3;
        
        for (int start = 1; start <= numTimes; start++) 
            catGrv.getInv().add(ITEM_LIST[GENERATOR.nextInt(3)]);

        // Important that catGrv is FIRST ITEM ADDED, iridescent jewel needs to be added to it.
        this.addFurniture(catGrv, catF, wall, ceiling);
        
        if (door != null)
            this.addFurniture(door);
        
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return Player.hasItem(HAND_TORCH) ? 
                this.descLit : super.getDescription();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        return Player.hasItem(HAND_TORCH) ? STD_RM_OUT : "???";
    }
//-----------------------------------------------------------------------------
}