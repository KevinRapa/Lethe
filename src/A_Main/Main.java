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
 * progresses, puzzles get steadily more complex and a story develops.
 * </p> <p>
 * To play, just run this project. Unless testing, make sure <code>start</code>
 * under the main method is set to Id.COU4.
 * You may start from any room in the game, however the default start
 * is in <code>cou4</code>. Find the method <code>setOccupies</code> at the
 * bottom of this class to change this, and refer to the castle array for the
 * room object references.
 * </p>
 * 
 * IDEAS:
 * Add an NPC that just implies player can commit suicide. "The wealthy live comfortably in hell."
 * Have encounter in attic put items in the prison cabinet instead, phylacteries in LQUA
 *
 * Have suicide now put player in Hades. Reference Zork. Have player judged by the
 * amount of loot and determine a score based on that. Hades is a room in the top
 * floor.
 *
 * @author Kevin Rapa
 * @see <a href="https://github.com/KevinRapa/Lethe.git">GitHub Repository</a>
 */
import java.awt.Color;              import javax.swing.JPanel;
import java.awt.Dimension;          import java.awt.Toolkit;
import java.awt.event.KeyEvent;     import java.awt.event.KeyListener; 
import java.io.*;                   import javax.swing.ImageIcon; 
import javax.swing.JFrame;          import javax.swing.JLabel;
import static A_Main.NameConstants.SEP;
import static A_Main.NameConstants.W_DIR;

public class Main {
    private static final String 
            START_LOCATION = Id.COU4, // Default COU4
            FILE_NAME = "Game.data";
    
    public static final JFrame GAME_FRAME = new JFrame("Lethe"),
                               TITLE_FRAME = new JFrame("Lethe");
    
    private static final JLabel TITLE_LABEL = new JLabel();
    
    private static final JPanel TITLE_PANEL = new JPanel();

    // <editor-fold defaultstate="collapsed" desc="Static block sets up title screen">
    static {
        TITLE_LABEL.setIcon(new ImageIcon("img" + SEP + "Title.jpg"));

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
// ============================================================================
    /**
     * Loads a game if there is one or starts a new game.
     * @param args Unused.
     */
    public static void main(String[] args) {
        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="MAKE THE FRAME">
        //**********************************************************************
        GUI panel = new GUI(); // Make false if window is too large.
                
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
        TITLE_FRAME.setVisible(true);
        
        TITLE_LABEL.setFocusable(true);
        
        //**********************************************************************
        // </editor-fold>
        //**********************************************************************
        
        
        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="READ IN SAVE FILE OR START NEW GAME">
        //
        // Rudimentary save system using serialization. Saves files in the same
        // location as Main.jar
        //**********************************************************************
        Help.constructHelp();
        boolean eraseTrue;
        
        try (ObjectInputStream gameData = 
                new ObjectInputStream(
                new FileInputStream(
                new File(W_DIR, FILE_NAME)))
            ) 
        {
            System.out.println("Data found. Loading game.");
            RoomGraph.assignCoordinates();
            Player.loadAttributes(gameData.readObject());
            eraseTrue = Player.mainPrompt(); // START GAME
        } 
        catch (java.lang.ClassNotFoundException | 
               java.io.IOException | 
               ClassCastException e) 
        {
            System.out.println(e.getMessage() + 
                    "\nData missing. Creating new game.");
            
            RoomGraph.constructRoomGraph();
            Player.setNewAttributes(RoomGraph.getCoords(START_LOCATION));
            eraseTrue = Player.startDialog(); // START GAME
        }
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************

        // End the game
        if (eraseTrue)
            new File(W_DIR, FILE_NAME).delete();
        
        exitGame();
    } 
// ============================================================================   
    public static void exitGame() {
        AudioPlayer.stopTrack();
        AudioPlayer.disposeKeyPlayers();
        GAME_FRAME.dispose();
        Map.disposeMap();
        System.exit(0);
    }
// ============================================================================   
    public static synchronized void saveGame() {
        
        try (ObjectOutputStream gameData = 
                new ObjectOutputStream(
                new FileOutputStream(
                new File(W_DIR, FILE_NAME)))
            ) 
        {
            Player.savePlayerAttributes(gameData); 
        } 
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }
// ============================================================================     
}
