package A_Main;
/**<p>
 * This is a text-based adventure game called <del>Salamaa</del> <ins>Lethe</ins>
 * written as a personal project.
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
 * To play, just run this project. Unless testing, make sure 
 * <code>START_LOCATION</code> under the main method is set to Id.COU4.
 * </p>
 * 
 * @author Kevin Rapa
 * @see <a href="https://github.com/KevinRapa/Lethe.git">GitHub Repository</a>
 */

import java.awt.event.KeyListener;  import java.awt.Color;
import java.awt.Dimension;          import java.awt.Toolkit;
import java.awt.event.KeyEvent;     

import javax.swing.JPanel;          import javax.swing.ImageIcon; 
import javax.swing.JLabel;          import javax.swing.JFrame;  
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.io.*;                   import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Platform; 

import static A_Main.Names.SEP;     import static A_Main.Names.DATA;
import static A_Main.Names.W_DIR;

public class Main {
    private static final String 
            START_LOCATION = Id.COU4, // Default COU4
            SAVE_PATH = DATA + SEP + "save" + SEP + "Game.data",
            TITLE_PATH = W_DIR + SEP + DATA + SEP + "img" + SEP;
    
    private static final JFrame 
            GAME_FRAME = new JFrame("Lethe"),
            TITLE_FRAME = new JFrame("Lethe");
    
    private static final JLabel TITLE_LABEL = new JLabel();
    
    private static final JPanel TITLE_PANEL = new JPanel();

    // <editor-fold defaultstate="collapsed" desc="Static block sets up title screen">
    static {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException ex) 
        {
            System.err.println(ex.getMessage());
        }

        TITLE_PANEL.setPreferredSize(new Dimension(824,478));
        TITLE_PANEL.setBackground(Color.BLACK);
        
        ImageIcon icon = new ImageIcon(TITLE_PATH + "Title.gif");
        
        if (icon.getImage().getWidth(TITLE_LABEL) == -1) {
            // Gif isn't working? Load regular picture.
            icon = new ImageIcon(TITLE_PATH + "AuxTitle.jpg");
            
            if (icon.getImage().getWidth(TITLE_LABEL) != -1) {
                TITLE_LABEL.setIcon(icon);
            }
            else {
                // Regular picture isn't working either? Do plain text.
                TITLE_LABEL.setOpaque(true);
                TITLE_LABEL.setBackground(Color.BLACK);
                TITLE_LABEL.setForeground(Color.WHITE);
                TITLE_LABEL.setFont(TITLE_LABEL.getFont().deriveFont(22.0f));
                TITLE_LABEL.setText(
                    "<html><br><br><br>This is Lethe<br><br>Well, there's "
                  + "SUPPOSED to<br>be a better image here..."
                  + "<br><br><i>Press any key...</i></html>");
            }
        }
        else {
            TITLE_LABEL.setIcon(icon);
        }
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

        // Sets up the title frame.
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
        //**********************************************************************
        int[] startCoords = null;
        
        try (ObjectInputStream gameData = new ObjectInputStream(
                new FileInputStream(new File(W_DIR, SAVE_PATH)))) 
        {
            // Reads game data to load a game.
            System.out.println("Data found. Loading game.");
            RoomGraph.assignCoordinates();
            Player.loadAttributes(gameData.readObject());
        } 
        catch (Exception e) {
            System.err.println(e.getMessage() + "\nCreating new game.");
            RoomGraph.constructRoomGraph(); // Sets up game map.
            
            if (args.length > 0 && (args[0].equals(Id.NULL)
                    || (startCoords = RoomGraph.getCoords(args[0])) == null))
            {
                // If player wants to start in an invalid room.
                System.err.println("Not a valid starting location.");
            }
            
            if (startCoords == null)
                startCoords = RoomGraph.getCoords(START_LOCATION);
            
            Player.setNewAttributes(startCoords); // Sets up character.
            
            startDialog();
        }
        finally {
            Player.mainPrompt(); // START GAME
            endGameProcedure();  // ENDS GAME
        }
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
    } 
//-----------------------------------------------------------------------------
    private static void startDialog() {
        // Short dialog that starts at the beginning of the game.
        AudioPlayer.playTrack(Id.TITL);

        GUI.menOut(Menus.ENTER);
        GUI.descOut("Beneath the starry welkin, you stand, having trekked on "
              + "foot to your destination through the forest. The looming "
              + "stone colossus appears curiously vacant, yet inviting.");
        GUI.promptOut();    

        GUI.descOut("You slowly approach, fighting the humid summer gales, "
              + "until inside the front gateway. A transient thought "
              + "drifts through your mind - what was your business "
              + "here, again? You ponder a moment, but can't quite " +
                "remember.");     
        GUI.promptOut();

        GUI.descOut(Menus.VERSION);     
        GUI.promptOut();

        GUI.clearDialog();
    }
//-----------------------------------------------------------------------------  
    public static void endGameProcedure() {
        AudioPlayer.stopTrack();            // Stops what's playing
        AudioPlayer.disposeKeyPlayers();    // Frees media players
        GAME_FRAME.setVisible(false);       // Makes frame disappear
        GAME_FRAME.dispose();               // Frees the JFrame
        Map.disposeMap();                   // Frees the game map
        Platform.exit();                    // Exits JavaFX
    }
//-----------------------------------------------------------------------------   
    public static void eraseGame() {
        if (new File(W_DIR, SAVE_PATH).delete())
            System.out.println("Data erased.");
        else
            System.err.println("Data to erase not found.");
    }
//-----------------------------------------------------------------------------   
    public static synchronized void saveGame() {
        try (ObjectOutputStream gameData = new ObjectOutputStream(
                new FileOutputStream(new File(W_DIR, SAVE_PATH)))) 
        {
            // Successfully saves the game.
            Player.savePlayerAttributes(gameData); 
            GUI.out("Game saved");
        } 
        catch (FileNotFoundException e) {
            try {
                Files.createDirectory(Paths.get(W_DIR + SEP + DATA + SEP + "save"));
                GUI.out("Save directory not found. Now creating a new one... Try again.");
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