package A_Main;

import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
/******************************************************************************
 * This class is responsible for the game interface.
 * All graphical components are set up here.
 * Any text useful to the player is collected here and displayed.
 * Any input from the player is processed here.
 * @author Kevin Rapa
 ******************************************************************************/
public class GUI extends JPanel {
    
    // Click noises when player types.
    private enum Click {
        // =======================================
        NONE(0), SOFT(21), CLICK(22), VINTAGE(23);
    
        private final int soundEffectId;
        // =======================================
        Click(int key) {
            this.soundEffectId = key;
        }
        // =======================================
        public int getEffectId() {
            return soundEffectId;
        }
        // =======================================
    }
    
    // <editor-fold desc="COMPONENTS AND ATTRIBUTES"> =========================
    private boolean big = true;
    private static int key = Click.SOFT.getEffectId();
    
    private final static JTextArea MEN = new JTextArea(), DESC = new JTextArea(), 
                                   INV = new JTextArea(), DIAL = new JTextArea();

    private final static JPanel EAST = new JPanel(new BorderLayout()), 
                                CNORTH = new JPanel(new BorderLayout()),
                                WEST = new JPanel(new BorderLayout()),
                                CENTER = new JPanel(), CCENTER = new JPanel(), 
                                CSOUTH = new JPanel(), SALAMAA = new JPanel(new FlowLayout(FlowLayout.LEFT));          
    
    private final static JScrollPane SCROLLW = new JScrollPane(DIAL, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                                                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
                                     SCROLLE = new JScrollPane(INV, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                                                     JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private final static JLabel ROOM = new JLabel(), 
                                INVLBL = new JLabel("Inventory");
    
    private final static JButton SIZE = new JButton("Small mode"),
                                 MUTE = new JButton("Mute"),
                                 KEYS = new JButton("Key click");
    
    private final static JTextField INPUT = new JTextField(23);
    
    private final static LinkedList<String> UNDO = new LinkedList<>();
    private final static Input_Holder HOLDER = new Input_Holder();
    
    private final static LinkedList<Click> KEYSOUND = new LinkedList() {{
        add(Click.SOFT); add(Click.CLICK); add(Click.VINTAGE); add(Click.NONE);
    }};

    private static final ArrayList<String> FURN_PARSER = new ArrayList<>();
    // </editor-fold> ================================================
    
// *****************************************************************************
// <editor-fold desc="CONSTRUCTOR AND COMPONENT CONTROLLERS">
// *****************************************************************************     
    public GUI() {
        Font myFont = new Font("Monospaced", Font.BOLD, 16);
        Font labelFont = new Font("MagicMedieval", Font.BOLD, 20);
        Color myColor = new Color(150, 84, 13);
        
        SCROLLW.setBackground(Color.DARK_GRAY);
        SCROLLW.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        
        SALAMAA.setBackground(Color.darkGray);
        SALAMAA.setPreferredSize(new Dimension(390, 45));
        SALAMAA.setBorder(BorderFactory.createRaisedBevelBorder());
        
        JButton[] buttons = {SIZE, MUTE, KEYS};
        for (JButton b : buttons) {
            b.setBackground(Color.DARK_GRAY);
            b.setFocusPainted(false);
            b.setForeground(Color.BLACK);
            b.setPreferredSize(new Dimension(90, 30));
            b.setBorder(BorderFactory.createRaisedBevelBorder());
            b.setFont(new Font("MagicMedieval", Font.BOLD, 15));
            b.addActionListener(new Button_Listener());
            SALAMAA.add(b);
        }

        WEST.add(SALAMAA, BorderLayout.NORTH);
        WEST.add(SCROLLW, BorderLayout.SOUTH);
        
        CENTER.setLayout(new BorderLayout());
        CNORTH.setBackground(Color.DARK_GRAY);
        ROOM.setFont(labelFont);
        ROOM.setForeground(Color.BLACK);
        CNORTH.add(DESC, BorderLayout.NORTH);
        CNORTH.add(ROOM, BorderLayout.SOUTH);
        CCENTER.setBackground(Color.BLACK);
        MEN.setEditable(false);
        MEN.setFont(myFont);
        MEN.setBackground(Color.BLACK);
        MEN.setForeground(myColor);
        CCENTER.add(MEN);
        CSOUTH.setBackground(Color.DARK_GRAY);
        INPUT.addActionListener(new Text_Field_Listener());
        INPUT.addKeyListener(new Text_Field_Key_Listener());
        INPUT.addFocusListener(new GameFocusListener());
        INPUT.setFont(myFont);
        INPUT.setBorder(BorderFactory.createLoweredBevelBorder());
        INPUT.setBackground(Color.DARK_GRAY);
        INPUT.setForeground(Color.BLACK);
        INPUT.setCaretColor(Color.LIGHT_GRAY);
        
        CSOUTH.add(INPUT);
        CENTER.add(CNORTH, BorderLayout.NORTH);
        CENTER.add(CCENTER, BorderLayout.CENTER);
        CENTER.add(CSOUTH, BorderLayout.SOUTH);
            
        SCROLLE.setBackground(Color.DARK_GRAY);
        SCROLLE.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        INVLBL.setFont(labelFont);
        INVLBL.setForeground(Color.BLACK);
        EAST.add(INVLBL, BorderLayout.NORTH);
        EAST.add(SCROLLE, BorderLayout.SOUTH);
        
        JLabel[] labels = {ROOM, INVLBL};
        for (JLabel l : labels) {
            l.setOpaque(true);      
            l.setBackground(Color.DARK_GRAY);
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setPreferredSize(new Dimension(390, 45));
            l.setBorder(BorderFactory.createRaisedBevelBorder());
        }
        
        JTextArea[] textAreas = {DIAL, DESC, INV};
        for (JTextArea t : textAreas) {
            t.setMargin(new Insets(0,6,0,6));
            t.setEditable(false);       t.setLineWrap(true);
            t.setWrapStyleWord(true);   t.setBackground(Color.BLACK);
            t.setForeground(myColor);   t.setFont(myFont);
        }
        
        INPUT.setPreferredSize(new Dimension(400, 40));
        WEST.setPreferredSize(new Dimension(300, 600));
        SCROLLW.setPreferredSize(new Dimension(290, 555));
        CENTER.setPreferredSize(new Dimension(400, 600));
        DESC.setPreferredSize(new Dimension(390, 350));
        EAST.setPreferredSize(new Dimension(300, 600));
        SCROLLE.setPreferredSize(new Dimension(290, 555));

        this.addComponents(true);
    }
/*----------------------------------------------------------------------------*/     
    private void addComponents(boolean big) {
        this.setPreferredSize(new Dimension (1000, big ? 600: 510));
        this.setLayout(new BorderLayout());
        this.add(WEST, BorderLayout.WEST);
        this.add(CENTER, BorderLayout.CENTER);
        this.add(EAST, BorderLayout.EAST);
    }
/*----------------------------------------------------------------------------*/
    /**
     * Resizes the frame and components when the upper-right resize button
     * is pressed.
     * 
     * @param big If the frame is entering big mode.
     */
    private void smallMode(boolean big) {
        Main.GAME_FRAME.setVisible(false);
        
        this.removeAll();
        
        if (big) {
            WEST.setPreferredSize(new Dimension(300, 600));
            SCROLLW.setPreferredSize(new Dimension(290, 555));
            CENTER.setPreferredSize(new Dimension(400, 600));
            DESC.setPreferredSize(new Dimension(390, 350));
            EAST.setPreferredSize(new Dimension(300, 600));
            SCROLLE.setPreferredSize(new Dimension(290, 555));
        }
        else {
            WEST.setPreferredSize(new Dimension(300, 510));
            SCROLLW.setPreferredSize(new Dimension(290, 465));
            CENTER.setPreferredSize(new Dimension(400, 510));
            DESC.setPreferredSize(new Dimension(390, 260));
            EAST.setPreferredSize(new Dimension(300, 510));
            SCROLLE.setPreferredSize(new Dimension(290, 465));
        }
        
        DESC.setFont(new Font("Monospaced", Font.BOLD, big ? 16 : 14));
        
        this.addComponents(big);
        
        Main.GAME_FRAME.pack();
        Main.GAME_FRAME.setVisible(true);
    }
// *****************************************************************************
// </editor-fold> CONFIGURES AND ADDS ALL COMPONENTS
// *****************************************************************************       
    
    
// *****************************************************************************
// <editor-fold desc="COLLECTORS">
//    
// These methods collect all text output in the game for the player.
// Each method sets the text of a different GUI component.    
// *****************************************************************************       
    /**
     * Collects all text not collected by the other collectors.
     * @param txt dialog text.
     */
    public static void out(String txt) {
        if (! txt.matches("none"))
            DIAL.setText(txt.replaceAll("\n", " "));
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects all room descriptions.
     * @param txt a room description.
     */
    public static void descOut(String txt) {
        DESC.setText(txt.replaceAll("\n", " "));
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects <code>triggeredEvent</code> return text
     * @param txt <code>triggeredEvent</code> room text
     */
    public static void roomOut(String txt) {
        ROOM.setText(txt);
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects all menu text; text which prompts player for input.
     * @param txt menu text
     */
    public static void menOut(String txt) {
        MEN.setText(txt);
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Displays all <code>toString</code> calls on inventories.
     * @param txt inventory toString method return text.
     * @see Inventory#toString() 
     */
    public static void invOut(String txt) {
        INV.setText(txt);
    }
// *****************************************************************************
// </editor-fold> COLLECT ALL GAME OUTPUT
// *****************************************************************************       
    
    
// *****************************************************************************       
// <editor-fold desc="INPUT RELATED">
// *****************************************************************************           
    /**
     * Used for any request of player input.
     * @return Commands input by the player.
     * @see Text_Field_Listener#actionPerformed
     */
    public static String promptOut() {
        synchronized (HOLDER) {
            try {
                HOLDER.wait();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return HOLDER.request();
    }
/*----------------------------------------------------------------------------*/
    /**
     * Holds player input.
     * @see Text_Field_Listener#actionPerformed 
     */
    private static class Input_Holder {
        private String playerInput;
        
        public void recieve(String s) {
            playerInput = s;
        }
        
        public String request() {
            return playerInput;
        }
    }
/*----------------------------------------------------------------------------*/
    /**
     * The player may reference the last referenced furniture using the words
     * 'it' or 'them'. This retrieves the last referenced furniture.
     * @return The last referenced object in the player's location.
     */
    public static String parsePreviousFurniture() {
        FURN_PARSER.clear();
        
        UNDO.stream().filter(i -> i.matches("(?:[a-z -]{3,})+")).forEach(j -> {
            // Filters out strings resembling phrases.
            if (j.matches("([a-z -]{3,})+")) {
                if (Player.getPos().hasFurniture(j))
                    // No verb. Uses whole string.
                    FURN_PARSER.add(j);
                else if (Player.getPos().hasFurniture(j = j.replaceFirst("\\w+ ", "")))
                    // First word might be a verb. Try second-last words.
                    FURN_PARSER.add(j);
            }
        });
        return (FURN_PARSER.size() > 0) ? FURN_PARSER.get(0) : 
                                          "object with that name";
    }
/*----------------------------------------------------------------------------*/
    /**
     * Prints the main menu of controls.
     */
    public static void toMainMenu() {
        MEN.setText("    <'w'/'s'/'a'/'d'> Move\n"
                  + "    <action object> Action\n"
                  + "<'e'> Search    <'c'>    Check\n"
                  + "<'i'> Inventory <'k'>    Keys\n"
                  + "<'h'> Get help  <'quit'> Quit");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDesc() {
        DESC.setText("");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDialog() {
        DIAL.setText("");
    }
// *****************************************************************************       
// </editor-fold> CLEAR METHODS AND PARSERS   
// *****************************************************************************           
    
    
// *****************************************************************************
// <editor-fold desc="LISTENERS">  
// *****************************************************************************
    /**
     * Allows player to go to last keyboard input with arrow keys.
     */
    private class Text_Field_Key_Listener implements KeyListener {
        private int current = 0;
        /*------------------------------------------------------*/
        @Override public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (current < UNDO.size())
                        INPUT.setText(UNDO.get(current++));
                    break;
                case KeyEvent.VK_DOWN:
                    INPUT.setText(" "); 
                    current = 0;
                    break;  
            }
        }
        /*------------------------------------------------------*/
        @Override public void keyPressed(KeyEvent e) {
            if (key != 0)
                AudioPlayer.playEffect(key);
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                current = 0;
        }
        /*------------------------------------------------------*/
        @Override public void keyTyped(KeyEvent e) {}
    }
/*----------------------------------------------------------------------------*/
    private class Text_Field_Listener implements ActionListener {
        /**
         * Waits for text to entered by the player and stores it, then notifies
         * the game to receive the input.
         * @param event Text entered by the player into the text field.
         */
        @Override public void actionPerformed(ActionEvent event) {
            synchronized (HOLDER) {
                HOLDER.recieve(INPUT.getText().toLowerCase().trim());
                
                if (HOLDER.request().matches("[a-z- ]{2,}|(?:[ts] \\d{1,2})")) {
                    if (UNDO.size() == 10)
                        UNDO.removeLast();
                    UNDO.push(HOLDER.request());
                }
                INPUT.setText(" ");
                HOLDER.notify();
            }
        } 
    }
/*----------------------------------------------------------------------------*/
    private class Button_Listener implements ActionListener {
        /**
         * Resizes the game panel, toggles the ambience, and changes key sound. 
         * On some monitors, the frame has been to large.
         * @param push A push of a button.
         */
        @Override public void actionPerformed(ActionEvent push) { // Resize
            if (push.getSource().equals(SIZE)) {
                AudioPlayer.playEffect(10);
                big = ! big;
                smallMode(big);
                SIZE.setText(big ? "Small mode" : "Big mode");
            }
            else if (push.getSource().equals(MUTE)) { // Toggles ambience
                AudioPlayer.playEffect(10);
                MUTE.setText(MUTE.getText().matches("Mute") ? "Unmute" : "Mute");
                AudioPlayer.muteTrack();
            }
            else { // Changes key click
                KEYSOUND.offer(KEYSOUND.poll());
                key = KEYSOUND.peek().getEffectId();
                
                if (key != 0)
                    AudioPlayer.playEffect(key);
            }
        }
    }
/*----------------------------------------------------------------------------*/
    /**
     * Keeps focus on the text field so user doesn't have to set in manually.
     */
    private class GameFocusListener implements FocusListener {
        @Override public void focusGained(FocusEvent e) {}

        @Override public void focusLost(FocusEvent e) {
            INPUT.requestFocus();
        }
    }
// *****************************************************************************
// </editor-fold> BUTTON AND TEXT FIELD LISTENERS
// *****************************************************************************   
}
