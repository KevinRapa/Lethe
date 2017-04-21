package Caves;

import A_Main.Player; 
import A_Super.Floor; 
import A_Super.Room;
import static A_Main.Names.HAND_TORCH;
import A_Super.Furniture;
import static java.lang.Math.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.*;
import static A_Main.Names.SEP;
import static A_Main.Names.W_DIR;
/**
 * The caves comprise a maze of similar tunnels.
 * The caves will generate their own descriptions and will distort their own
 * descriptions to a degree determined by its distance from room MS66. The
 * reason for this is story-based.
 * 
 * @see Caves.Deep_Chamber
 * @author Kevin Rapa
 */
public class Cave extends Room {
    protected String descLit;
    protected final int DISTANCE; // Distance this room is from MS65
    protected static final Random GENERATOR = new Random();
    
    protected static final File DISTORTION = new File(W_DIR, 
            "data" + SEP + "ambience" + SEP + "caveDistortion.wav");
    
    protected static Clip clip;
//-----------------------------------------------------------------------------    
    public Cave(String ID, Furniture wall, Furniture ceiling) {
        super("Cave network", ID);
        int X = COORDS[2], Y = COORDS[1]; // X and Y coordinates of this room.

        this.DISTANCE = (int)round(sqrt(  // Calculates DISTANCE from MS65.
                pow(abs(5 - X), 2) +      // Pythagorean theorem
                        pow(abs(6 - Y), 2)));
        StringBuilder descB = new StringBuilder(240),
                      descL = new StringBuilder(300);
        
        switch (DISTANCE) {
            case 7: case 6: case 5:
                descL.append("You feel inexplicably dizzy.");
                break;
            case 4:
                descL.append("You can feel the dizzyness intensifying.");
                break;
            case 3:
                descL.append("Your head begins to hurt, and the dizzyness intensifies.");
                break;
            case 2:
                descL.append("You feel delirious, and your senses begin to numb.");
                break;
            default:
                descL.append("You start slipping into an acute dementia, and you can barely orient yourself.");
        }
        
        descB.append(descL.toString());
        
        descB.append(" This area is pitch black just like the level above. "
                   + "It's uncomfortably cold, and you hear nothing but "
                   + "drops of water and an awful racket deep within "
                   + "the tunnels.");
        
        descL.append(" The torch lights a short way ahead. This area is much "
                 + "like above, though the walls and floor are plain rock. "
                 + "You can hear an awful noise deep within the tunnels. "
                 + "                                         To the ");
        
        /* 
           Builds the lit description of the room. Here, the constructor figures
           out what is in each direction of the caves. The description will
           reflect if there if empty space or a door in any direction.
        */
        
        // List of X and Y coordinates of the adjacent cave rooms.
        ArrayList<int[]> adjCaveCoords = new ArrayList<>();
        
        // The X and Y coordinates of a non-cave room adjacent to this.
        int[] adjOtherCoords = null;
        
        // Holds directions to append to descLit.
        ArrayList<String> dirs = new ArrayList<>(4);
        
        for (String i : this.adjacent) {
            int[] coords = {i.charAt(2) - '0', 
                            i.charAt(3) - '0'};
            
            if (i.matches("CV\\d{2}")) // Is cave.
                adjCaveCoords.add(coords);
            else                       // Isn't cave.
                adjOtherCoords = coords;
        }
        
        // Figures out the directions in which there are more catacombs.
        for (int[] j : adjCaveCoords) {
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
                descL.append(dirs.get(0));
                break;
            case 2:
                descL.append(dirs.get(0)).append(" and ").append(dirs.get(1));
                break;
            default:
                int i; 
                for (i = 0; i < dirs.size() - 1; i++)
                    descL.append(dirs.get(i)).append(", ");
                
                descL.append("and ").append(dirs.get(i));
        }
        
        descL.append(", the tunnel veers into darkness. ");
        
        // Appends additional information if a non-catacomb room is adjacent.
        // Adds a door to room.
        if (adjOtherCoords != null && adjOtherCoords[0] != 5) {
            if (adjOtherCoords[0] == Y - 1)
                descL.append("To the north");
            else if (adjOtherCoords[0] == Y + 1)
                descL.append("To the south");
            else if (adjOtherCoords[1] == X - 1)
                descL.append("To the west");
            else 
                descL.append("To the east");

            descL.append(", erected unevenly into the tunnel wall is an ancient door.");
        }

        this.descLit = descL.toString();
        this.description = descB.toString();
        
        this.addFurniture(new Floor("The floor is cold hard rock and uninteresting."), wall, ceiling);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (!Player.hasItem(HAND_TORCH))
            return distortDescription(DISTANCE, descLit);
        else
            return distortDescription(DISTANCE, description);
    }
//-----------------------------------------------------------------------------
    /**
     * Plays hellish music at volume respective to player's distance from MS65.
     * @return distorted room name.
     */
    @Override public String triggeredEvent() {
        try {
            if (clip != null)
                stopClip();
            
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(DISTORTION));
            
            ((FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN))
                    .setValue(-((float)Math.pow(DISTANCE, 2)));
            
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | 
                    IOException ex) 
        {
            System.out.println(ex.getMessage());
        }

        return Player.hasItem(HAND_TORCH) ? 
                distortDescription(DISTANCE, STD_RM_OUT) : "???";
    }
//-----------------------------------------------------------------------------
    /**
     * Scrambles the string to a degree based on DISTANCE.
     * @param degree the degree to which distort the description.
     * @param desc A string to distort.
     * @return a scrambled string.
     */
    public static String distortDescription(int degree, String desc) {
        char[] charArray = desc.toCharArray();
        int length = charArray.length;
        
        if (degree == 7) return desc; // Degree 7 will not distort at all.
        
        for (int d = 42; d > degree*7; d -= 2) {
            int i = GENERATOR.nextInt(length),
                j = GENERATOR.nextInt(length);
            swapChars(charArray, i, j); 
            charArray[GENERATOR.nextInt(length)] += 20; // Shifts character up the unicode set.
        }

        return new String(charArray);
    }
//-----------------------------------------------------------------------------
    protected static void swapChars(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
//-----------------------------------------------------------------------------
    public static void stopClip() {
        if (clip != null)
            clip.stop();
    }
//-----------------------------------------------------------------------------
}
