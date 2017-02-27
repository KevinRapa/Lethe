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
 * @author Kevin Rapa
 * @see <a href="https://github.com/KevinRapa/Lethe.git">GitHub Repository</a>
 */

import java.awt.Dimension; import java.awt.Toolkit;     import java.io.*; 
import javax.swing.JFrame;

public class Main {
    public static final JFrame GAME_FRAME = new JFrame("Lethe");
    
    private static final String 
            WD = System.getProperty("user.dir"),
            START_LOCATION = Id.COU4, // Default COU4
            FILE_NAME = "Game.data";
// ============================================================================
    /**
     * Loads a game if there is one or starts a new game, quits when player is
     * done.
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
        GAME_FRAME.pack();
        GAME_FRAME.setVisible(true);
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
        int exitChoice;
        
        try (ObjectInputStream gameData = new ObjectInputStream(
                                          new FileInputStream(
                                          new File(WD, FILE_NAME)));
            ) 
        {
            System.out.println("Data found. Loading game.");
            RoomReferences.constructCoorinateReferences();
            Player.loadAttributes(gameData.readObject());
            exitChoice = Player.mainPrompt(); // START GAME
        } 
        catch (java.lang.ClassNotFoundException | 
               java.io.IOException | 
               ClassCastException e) 
        {
            System.out.println(e.getMessage() + "\nData missing. Creating new game.");
            RoomReferences.constructRoomReferences();
            Player.setNewAttributes(RoomReferences.getCoords(START_LOCATION));
            exitChoice = Player.startDialog(); // START GAME
        }
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
        
        
        //**********************************************************************
        // <editor-fold defaultstate="collapsed" desc="EXIT GAME">
        //**********************************************************************
        AudioPlayer.stopTrack();
        GAME_FRAME.dispose();
        switch(exitChoice) {
            case 1:
                // Saves the game.
                try (ObjectOutputStream gameData = new ObjectOutputStream(
                                                   new FileOutputStream(
                                                   new File(WD, FILE_NAME)));
                    ) 
                {
                    Player.savePlayerAttributes(gameData);  
                } 
                catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                // Reset the game.
                if ((new File(WD, FILE_NAME)).delete())
                    System.out.println("Files deleted.");
                else
                    System.out.println("Files to delete not found.");
                break;
            default:
        }
        //**********************************************************************
        // </editor-fold>  
        //**********************************************************************
    } 
// ============================================================================    
}