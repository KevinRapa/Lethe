package A_Main;
/**<p>
 * This is a text-based adventure game called <del>Salamaa</del> <ins>Lethe</ins>
 * being written as a personal project.
 * </p> <p>
 * All super classes are in package A_Super. Packages are organized by room.
 * A room class is named by its ID and is four characters long (i.e. Cou4, Torc).
 * </p> <p>
 * You control an unnamed character who is exploring a castle after having 
 * wandered through the woods to it without any apparent reason. As the game
 * progresses, puzzles get steadily more complex and a story develops. As a
 * secondary objective, the player may collect loot and add it to a loot sack
 * found in the foyer.
 * </p> <p>
 * To play, just run this project. Unless testing, make sure <code>start</code>
 * under the main method is set to Id.COU4.
 * You may start from any room in the game, however the default start
 * is in <code>Id.COU4</code>. Find the method <code>setOccupies</code> at the
 * bottom of this class to change this, and refer to the castle array for the
 * room object references.
 * </p>
 * 
 * @author Kevin Rapa
 * @see <a href="https://github.com/KevinRapa/Lethe.git">GitHub Repository</a>
 */
import java.awt.Color;              import javax.swing.JPanel;
import java.awt.Dimension;          import java.awt.Toolkit;
import java.awt.event.KeyEvent;     import java.awt.event.KeyListener; 
import java.io.*;                   import javax.swing.ImageIcon; 
import javax.swing.JFrame;          import javax.swing.JLabel;
import javafx.application.Platform; import java.nio.file.Files;
import java.nio.file.Paths;

import static A_Main.Names.SEP;     import static A_Main.Names.W_DIR;

public class Main {
    private static final String 
            START_LOCATION = Id.COU4, // Default COU4
            FILE_NAME =  "data" + SEP + "save" + SEP + "Game.data";
    
    private static final JFrame 
            GAME_FRAME = new JFrame("Lethe"),
            TITLE_FRAME = new JFrame("Lethe");
    
    private static final JLabel TITLE_LABEL = new JLabel();
    
    private static final JPanel TITLE_PANEL = new JPanel();

    // <editor-fold defaultstate="collapsed" desc="Static block sets up title screen">
    static {
        TITLE_LABEL.setIcon(new ImageIcon(
                W_DIR + SEP + "data" + SEP + "img" + SEP + "Title.jpg")
        );
        TITLE_LABEL.addKeyListener(new KeyListener() {
            // To progress to game frame from title frame with "Press any key"
            @Override public void keyTyped(KeyEvent e) {}
            @Override public void keyReleased(KeyEvent e) {}
            @Override public void keyPressed(KeyEvent e) {
                GAME_FRAME.setVisible(true);
                TITLE_FRAME.setVisible(false);
                TITLE_FRAME.dispose();
                GUI.giveFocus();
            }  
        });
        TITLE_PANEL.setBackground(Color.BLACK);
        TITLE_PANEL.add(TITLE_LABEL);
    }
    // </editor-fold>
//-----------------------------------------------------------------------------
    /**
     * Loads a game if there is one or starts a new game.
     * @param args Optional room id. Will start player in that area.
     */
    public static void main(String[] args) {
        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="MAKE THE FRAME">
        //**********************************************************************
        GUI panel = new GUI();
                
        GAME_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        GAME_FRAME.setLocation(width > 1000 ? (width - 1000)/2 : 0, 100);
        
        GAME_FRAME.getContentPane().add(panel);
        GAME_FRAME.setResizable(false);
        GAME_FRAME.toBack();
        GAME_FRAME.pack();

        TITLE_FRAME.getContentPane().add(TITLE_PANEL);
        TITLE_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TITLE_FRAME.setLocation(width > 1000 ? (width - 1000)/2 : 0, 100);
        TITLE_FRAME.pack();
        TITLE_FRAME.setResizable(false);
        TITLE_FRAME.setVisible(true);
        
        TITLE_LABEL.setFocusable(true);
        //**********************************************************************
        // </editor-fold>
        //**********************************************************************
        
        
        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="READ IN SAVE FILE OR START NEW GAME">
        //
        // Rudimentary save system using serialization.
        //**********************************************************************
        boolean isNewGame = false;
        String start = args.length > 0 ? args[0] : null;
        int[] test = null;
        
        try (ObjectInputStream gameData = new ObjectInputStream(
                new FileInputStream(new File(W_DIR, FILE_NAME)))) 
        {
            System.out.println("Data found. Loading game.");
            RoomGraph.assignCoordinates();
            Player.loadAttributes(gameData.readObject());
        } 
        catch (Exception e) {
            System.err.println(e.getMessage() + "\nCreating new game.");
            RoomGraph.constructRoomGraph();
            
            if (start != null && (start.equals(Id.NULL) || start.equals(Id.GAL7) 
                        || (test = RoomGraph.getCoords(start)) == null))
                    System.err.println("Not a valid starting location.");
                
            Player.setNewAttributes(
                    RoomGraph.getCoords(test == null ? START_LOCATION : start)
            );
            
            isNewGame = true;
        }
        finally {
            boolean eraseTrue = Player.startDialog(isNewGame); // START GAME
            
            if (eraseTrue)
                eraseGame();
                
            endGameProcedure();
        }
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
    } 
//-----------------------------------------------------------------------------  
    public static void endGameProcedure() {
        AudioPlayer.stopTrack();
        AudioPlayer.disposeKeyPlayers();
        GAME_FRAME.setVisible(false);
        GAME_FRAME.dispose();
        Map.disposeMap();
        Platform.exit();
    }
//-----------------------------------------------------------------------------   
    public static void eraseGame() {
        if (new File(W_DIR, FILE_NAME).delete())
            System.out.println("Data erased.");
        else
            System.err.println("Data to erase not found.");
    }
//-----------------------------------------------------------------------------   
    public static synchronized void saveGame() {
        try (ObjectOutputStream gameData = new ObjectOutputStream(
                new FileOutputStream(new File(W_DIR, FILE_NAME)))) 
        {
            Player.savePlayerAttributes(gameData); 
            GUI.out("Game saved");
        } 
        catch (FileNotFoundException e) {
            try {
                Files.createDirectory(Paths.get(W_DIR + SEP + "data" + SEP + "save"));
                GUI.out("Save directory not found. Creating a new one. Try again.");
            } catch (IOException ex) {
                GUI.out("Couldn't EVEN remake the directory. "
                    + "This is all I got for you -> " + e.getMessage());
                System.err.println(ex.getMessage());
            }
        }
        catch (IOException e) {
            GUI.out("Hmph... Something went wrong in saving... "
                    + "This is all I got for you -> " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }
//-----------------------------------------------------------------------------
    /**
     * Returns a 'random enough' number for various purposes.
     * Generally used as an index number.
     * @param max Number will be from 0 to max - 1.
     * @return random number.
     */
    public static int getRandomUnder(int max) {
        return Math.abs((int)System.currentTimeMillis()) % max;
    }
//-----------------------------------------------------------------------------     
}