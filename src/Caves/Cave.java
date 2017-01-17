package Caves;

import A_Main.Player;
import A_Super.Floor;
import A_Super.Room;
import A_Super.Wall;

import static A_Main.AudioPlayer.S;
import static A_Main.AudioPlayer.WD;
import static A_Main.NameConstants.HAND_TORCH;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.abs;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static java.lang.Math.round;
import static java.lang.Math.abs;
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
    protected static final File DISTORTION = new File(WD, "ambience" + S + "caveDistortion.wav");
    protected Clip clip;
// ============================================================================    
    public Cave(String ID) {
        super("in a cave network", ID);
        int X = COORDS[2], Y = COORDS[1]; // X and Y coordinates of this room.

        this.DISTANCE = (int)round(sqrt(  // Calculates DISTANCE from MS65.
                pow(abs(6 - X), 2) +      // Pythagorean theorem
                        pow(abs(6 - Y), 2)));
        
        switch (DISTANCE) {
            case 7: case 6: case 5:
                descLit = "You feel inexlicably dizzy.";
                description = "You feel inexlicably dizzy.";
                break;
            case 4:
                descLit = "You can feel the dizzyness intensifying.";
                description = "You can feel the dizzyness intensifying.";
                break;
            case 3:
                descLit = "Your head begins to hurt, and the dizzyness intensifies.";
                description = "Your head begins to hurt, and the dizzyness intensifies.";
                break;
            case 2:
                descLit = "You feel delirious, and your senses begin to numb.";
                description = "You feel delirious, and your senses begin to numb.";
                break;
            case 1:
                descLit = "You start slipping into an acute dementia, and you can barely orient yourself.";
                description = "You start slipping into an acute dementia, and you can barely orient yourself.";
                break;
        }
        
        this.description = description.concat(" This area is pitch black just like the level above.\n"
                         + "It's uncomfortably cold, and you hear nothing but\n"
                         + "drops of water and an unsettling echo deep within\n"
                         + "the tunnels. You feel inexplicably dizzy.");
        
        this.descLit = descLit.concat(" The torch lights a short way ahead. This area is much\n"
                     + "like above, though the walls and floor are plain rock.\n"
                     + "You can hear an unsettling noise deep within the tunnels. To the ");
        
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
        ArrayList<String> dirs = new ArrayList<>();
        
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
            }
            else if (adjOtherCoords[0] == Y + 1){
                descLit = descLit.concat("To the south");
            }
            else if (adjOtherCoords[1] == X - 1) {
                descLit = descLit.concat("To the west");
            }
            else {
                descLit = descLit.concat("To the east");
            }
            
            descLit = descLit.concat(", erected unevenly into the tunnel wall is an ancient door.");
        }

        this.addFurniture(new Floor("The floor is cold hard rock and uninteresting."),
                          new Wall("The wall is damp, plain rock."));
    }
// ============================================================================
    @Override public String getDescription() {
        if (Player.hasItem(HAND_TORCH))
            return distortDescription(DISTANCE, descLit);
        else
            return distortDescription(DISTANCE, description);
    }
// ============================================================================
    @Override public String triggeredEvent() {
        try {
            if (Player.getLastVisited().matches("CV\\d{2}")) // Stop clip from previous room.
                ((Cave)Player.getRoomObj(Player.getLastVisited())).stopClip();
            
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(DISTORTION));
            ((FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN)).setValue(-((float)Math.pow(DISTANCE, 2)));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (LineUnavailableException | 
                 UnsupportedAudioFileException | 
                 IOException ex) 
        {
            System.out.println(ex.getMessage());
        }

        
        
        if (Player.hasItem(HAND_TORCH))
            return distortDescription(DISTANCE, STD_RM_OUT);
        else
            return "???";
    }
// ============================================================================
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
        
        for (int d = 42; d > degree*7; d--) {
            int i = GENERATOR.nextInt(length),
                j = GENERATOR.nextInt(length);
            swapChars(charArray, i, j); 
            charArray[GENERATOR.nextInt(length)] += 20; // Shifts character up the unicode set.
        }
        
        for (int d = 42; d > degree*7; d--) {
            
        }
        return new String(charArray);
    }
// ============================================================================
    protected static void swapChars(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
// ============================================================================
    public void stopClip() {
        this.clip.stop();
    }
// ============================================================================
}