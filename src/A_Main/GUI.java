package A_Main;

import static A_Main.Names.SEP;
import static A_Main.Names.W_DIR;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
/******************************************************************************
 * This class is responsible for the game interface.
 * All graphical components are set up here.
 * Any text useful to the player is collected here and displayed.
 * Any input from the player is processed here.
 * @author Kevin Rapa
 ******************************************************************************/
public class GUI extends JFXPanel {

    // Faux click noises when player types. Optional feature.
    private enum Click {
        NONE(-1), SOFT(0), CLICK(1), VINTAGE(2);
    
        public final int effectID; // Index. NONE's isn't used.
        //----------------------------------------
        Click(int key) { 
            this.effectID = key; 
        }
        //----------------------------------------
    }
    
    // <editor-fold desc="COMPONENTS AND ATTRIBUTES">
    private static int keySound = Click.NONE.effectID;
    
    private static Font myFont;
    
    private final static JTextArea 
        MEN_TXT = new JTextArea(),  // Menus are printed here.
        DESC_TXT = new JTextArea(), // Room descriptions are printed here.
        INV_TXT = new JTextArea(),  // Inventories are printed here.
        DIAL_TXT = new JTextArea(); // General text is printed here.

    private final static JPanel 
        EAST = new JPanel(new BorderLayout()),   // Holds inventory and dialog.
        WEST = new JPanel(),                     // Left half of the GUI.
        WNORTH = new JPanel(new BorderLayout()), // Holds room label and desc.
        WNSOUTH = new JPanel(),                  // Holds room name, score, moves.
        WSOUTH = new JPanel(new BorderLayout()), // Holds menu, input and buttons.
        INPUT_PNL = new JPanel(),                // Holds the input and prompt sigil.
        MEN_PNL = new JPanel(),                  // Holds menu so it may resize freely.
        BTN_PNL = new JPanel();                  // Holds just the five option buttons.
    
    private final static JScrollPane 
        SCROLLS = new JScrollPane(DIAL_TXT,      // Holds all general event dialog.
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
        SCROLLN = new JScrollPane(INV_TXT,       // Where player inventory is printed.
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    private final static JLabel 
        PROMPT_LBL = new JLabel(">"),    // Decorative prompt sigil.
        ROOM_LBL = new JLabel(),         // Displays player's current room.
        MOVE_LBL = new JLabel(),         // Displays number of moves.
        SCORE_LBL = new JLabel();        // Displays current score.
    
    private final static JButton 
        SWAP = new JButton("Swap"),      // Swaps dialog and inventory.
        COLOR2 = new JButton("Color II"),// Changes label colors
        MUTE = new JButton("Mute"),      // Mute button
        KEYS = new JButton("Click"),     // Button controlling faux key sounds.
        COLOR1 = new JButton("Color I"); // Button changing dialog colors.
    
    private final static JTextField 
        INPUT = new JTextField(35);  // Player enters commands here.
    
    // Holds previous input.
    private final static LinkedList<String> UNDO = new LinkedList<>();
    
    // Holds player input to be recieved by main thread.
    private final static Input_Holder HOLDER = new Input_Holder();
    
    // Queue treated as circular to rotate between key sounds.
    private final static LinkedList<Click> KEYSOUND = new LinkedList<>();
    
    // Queue treated as curcular to rotate font colors.
    private final static LinkedList<Color> 
        COLORS_DIAL = new LinkedList<>(),
        COLORS_LABEL = new LinkedList<>();

    static {
        Color lightBrown = new Color(122, 84, 13);
        Color darkRed = new Color(196, 11, 15);
        
        KEYSOUND.addAll(Arrays.asList(
                Click.NONE, Click.SOFT, Click.CLICK, Click.VINTAGE)
        );
        COLORS_DIAL.addAll(Arrays.asList(Color.GRAY, Color.LIGHT_GRAY, 
                new Color(27, 203, 22), darkRed, 
                new Color(141, 28, 154), lightBrown)
        );  
        COLORS_LABEL.addAll(Arrays.asList(Color.LIGHT_GRAY, lightBrown, 
                        Color.ORANGE, darkRed, Color.GRAY));
    }
    // </editor-fold>
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR AND COMPONENT CONTROLLERS">
// *****************************************************************************     
    public GUI() {
        Font labelFont;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String p = "data" + SEP + "img" + SEP;
        FocusListener focusListener = new FocusListener() {
            // Serves to keep focus on the text field.
            @Override public void focusGained(FocusEvent e) {
                INPUT.requestFocus();
            }
            @Override public void focusLost(FocusEvent e) {}
        };
        
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, 
                        new File(W_DIR, p + "fixedSys.ttf")).deriveFont(20.0f);

            ge.registerFont(myFont);
        } catch (IOException | FontFormatException e) {
            myFont = new Font("Monospaced", Font.BOLD, 16);
        }
        try {
            labelFont = Font.createFont(Font.TRUETYPE_FONT, 
                        new File(W_DIR, p + "MagicMedieval.ttf"));

            ge.registerFont(labelFont);
        } catch (IOException | FontFormatException e) {
            labelFont = new Font("Monospaced", Font.BOLD, 16);
        }

        Color myColor = COLORS_DIAL.getLast();
        JTextArea[] textAreas = {DIAL_TXT, DESC_TXT, INV_TXT};
        Insets defInsets = new Insets(2,6,0,6);
        for (JTextArea t : textAreas) {
            t.addFocusListener(focusListener);
            t.setMargin(defInsets);
            t.setEditable(false);       t.setLineWrap(true);
            t.setWrapStyleWord(true);   t.setBackground(Color.BLACK);
            t.setForeground(myColor);   t.setFont(myFont);
        }
        
        Button_Listener l = new Button_Listener();
        JButton[] buttons = {SWAP, MUTE, KEYS, COLOR1, COLOR2};
        for (JButton b : buttons) {
            b.setBackground(Color.BLACK);
            b.setFocusPainted(false);
            b.setForeground(COLORS_LABEL.getLast());
            b.setPreferredSize(new Dimension(74, 35));
            b.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.BLACK));
            b.setFont(labelFont.deriveFont(Font.BOLD, 17.0f));
            b.addActionListener(l);
            BTN_PNL.add(b);
        }
        
        JLabel[] labels = {ROOM_LBL, MOVE_LBL, SCORE_LBL};
        for (JLabel label : labels) { 
            label.setForeground(COLORS_LABEL.getLast());
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setBorder(BorderFactory.createEmptyBorder());
        }
        
        Component[] cmps =
            {MEN_TXT, MEN_PNL, INPUT, BTN_PNL, INPUT_PNL, WNSOUTH, WEST};
        for (Component c : cmps)
            c.setBackground(Color.BLACK);
        
        // WEST
        WNORTH.setPreferredSize(new Dimension(400, 385));
        DESC_TXT.setPreferredSize(new Dimension(400, 335));
        WNSOUTH.setPreferredSize(new Dimension(400, 50));
        SCORE_LBL.setPreferredSize(new Dimension(80, 50));
        SCORE_LBL.setFont(labelFont.deriveFont(Font.BOLD, 18.0f));
        MOVE_LBL.setPreferredSize(new Dimension(80, 50));
        MOVE_LBL.setFont(labelFont.deriveFont(Font.BOLD, 18.0f));
        ROOM_LBL.setPreferredSize(new Dimension(225, 50));
        ROOM_LBL.setFont(labelFont.deriveFont(Font.BOLD, 22.0f));
        WNSOUTH.add(MOVE_LBL);
        WNSOUTH.add(ROOM_LBL);
        WNSOUTH.add(SCORE_LBL);
        WNORTH.add(WNSOUTH, BorderLayout.SOUTH);
        WNORTH.add(DESC_TXT, BorderLayout.NORTH);
        WSOUTH.setPreferredSize(new Dimension(400, 265));
        MEN_TXT.setEditable(false);
        MEN_TXT.setFont(myFont);
        MEN_TXT.setForeground(myColor);
        MEN_TXT.addFocusListener(focusListener);
        MEN_PNL.setPreferredSize(new Dimension(390, 170));
        MEN_PNL.add(MEN_TXT);
        INPUT.addActionListener(new Text_Field_Listener());
        INPUT.addKeyListener(new Text_Field_Key_Listener());
        INPUT.setFont(myFont);
        INPUT.setCaret(new RetroCaret());
        INPUT.setBorder(BorderFactory.createEmptyBorder());
        INPUT.setForeground(Color.LIGHT_GRAY);
        INPUT.setCaretColor(Color.GRAY);
        PROMPT_LBL.setHorizontalAlignment(JLabel.RIGHT);
        PROMPT_LBL.setPreferredSize(new Dimension(25, 25));
        PROMPT_LBL.setFont(myFont.deriveFont(22.0f));
        PROMPT_LBL.setForeground(Color.LIGHT_GRAY);
        INPUT_PNL.setPreferredSize(new Dimension(400, 25));
        INPUT_PNL.add(PROMPT_LBL);
        INPUT_PNL.add(INPUT);
        BTN_PNL.setPreferredSize(new Dimension(400, 60));
        WSOUTH.add(MEN_PNL, BorderLayout.NORTH);
        WSOUTH.add(INPUT_PNL, BorderLayout.CENTER);
        WSOUTH.add(BTN_PNL, BorderLayout.SOUTH);
        WEST.setPreferredSize(new Dimension(400, 645));
        WEST.add(WNORTH, BorderLayout.NORTH);
        WEST.add(WSOUTH, BorderLayout.SOUTH);
        
        // EAST
        INV_TXT.setFont(myFont.deriveFont(19.0f));
        EAST.setPreferredSize(new Dimension(300, 645));
        SCROLLN.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        SCROLLN.setPreferredSize(new Dimension(300, 343));
        SCROLLS.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        SCROLLS.setPreferredSize(new Dimension(300, 305));
        EAST.add(SCROLLN, BorderLayout.NORTH);
        EAST.add(SCROLLS, BorderLayout.SOUTH);
        
        this.addComponents();
    }
/*----------------------------------------------------------------------------*/     
    private void addComponents() {
        this.setPreferredSize(new Dimension (700, 645));
        this.setLayout(new BorderLayout());
        add(WEST, BorderLayout.WEST);
        add(EAST, BorderLayout.EAST);
    }
// *****************************************************************************
// </editor-fold> CONFIGURES AND ADDS ALL COMPONENTS
// *****************************************************************************       
    
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="COLLECTORS">
//    
// These methods collect all text output in the game for the player.
// Each method sets the text of a different GUI component.    
// *****************************************************************************       
    /**
     * Collects all text not collected by the other collectors.
     * Complicated events may send <code>null</code>.
     * @param txt dialog text.
     */
    public static void out(String txt) {
        if (! txt.equals(""))
            DIAL_TXT.setText((txt));
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects all room descriptions.
     * @param txt a room description.
     */
    public static void descOut(String txt) {
        DESC_TXT.setText(txt);
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects <code>triggeredEvent</code> return text.
     * For triggered events that move the player, <code>null</code> is sent.
     * @param txt <code>triggeredEvent</code> room text
     */
    public static void roomOut(String txt) {
        if (! txt.equals(""))
            ROOM_LBL.setText(txt);
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects all menu text; text which prompts player for input.
     * @param txt menu text
     */
    public static void menOut(String txt) {
        MEN_TXT.setText(txt);
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Displays all <code>toString</code> calls on inventories.
     * @param txt inventory toString method return text.
     * @see Inventory#toString() 
     */
    public static void invOut(String txt) {
        INV_TXT.setText(txt);
    }
// *****************************************************************************
// </editor-fold> COLLECT ALL GAME OUTPUT
// *****************************************************************************       
    
    
// *****************************************************************************       
// <editor-fold defaultstate="collapsed" desc="INPUT RELATED, CLEAR METHODS AND PARSERS">
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
    public static String askChoice(String menu, Pattern pattern) {
        String answer;
        
        menOut(menu);
        
        answer = promptOut();
        
        while (! pattern.matcher(answer).matches()) {
            menOut("That's not valid" + menu);
            answer = promptOut();
        }
        return answer;
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
     * Prints the main menu of controls.
     */
    public static void toMainMenu() {
        MEN_TXT.setText(Menus.MAIN_MENU);
    }
/*----------------------------------------------------------------------------*/
    public static void clearDesc() {
        DESC_TXT.setText("");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDialog() {
        DIAL_TXT.setText("");
        DIAL_TXT.setCaretPosition(0);
    }
/*----------------------------------------------------------------------------*/
    public static void updateMovesAndScore(int moves, int score) {
        MOVE_LBL.setText("<html>Moves<br>" + moves + "</html>");
        SCORE_LBL.setText("<html>Score<br>" + score + "</html>");
    }
/*----------------------------------------------------------------------------*/
    public static void resetScroll() {
        SCROLLN.getVerticalScrollBar().setValue(0);
        SCROLLS.getVerticalScrollBar().setValue(0);
    }
/*----------------------------------------------------------------------------*/
    public static void giveFocus() {
        INPUT.requestFocus();
    }
/*----------------------------------------------------------------------------*/
    /**
     * For the easter egg command 'XYZZY'.
     */
    public static void randomizeColors() {
        Random rand = new Random();
        Component[] compList = {
            ROOM_LBL, DIAL_TXT, DESC_TXT, INV_TXT, SWAP, COLOR2, 
            MUTE, WNSOUTH, MEN_PNL, KEYS, COLOR1, PROMPT_LBL, 
            MEN_TXT, WSOUTH, INPUT, MOVE_LBL, SCORE_LBL
        };
        
        for (Component c : compList) {
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            c.setBackground(new Color(r,g,b));
        }
        for (Component c : compList) {
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            c.setForeground(new Color(r,g,b));
        }
    }
/*----------------------------------------------------------------------------*/
    public static void displayCredits() {
        invOut("AMBIENT TRACK SOURCES (All from freesound.org): "
            + "AniCator, Bluehand, BrainClaim, cormi, EKVelika, ERH, dobroide, "
            + "E1ectr0n1cF4n, felix.blume, German1990, heatfuse, holger.schwetter, "
            + "iankath, InSintesi, JarredGibb, jobro, juskiddink, karma-ron, "
            + "klankbeeld, MattJ99, mensageirocs, NoiseCollector, omnisounddesign, "
            + "plagasul, richardemoore, RogerBoyX69, Setuniman, ShadyDave, silencyo, "
            + "spoonbender, tc630, Timbre, veedgo, waveplay");
        
        out("SOUND EFFECT SOURCES (All from freesound.org): Erdie, "
            + "everythingsounds, Evil-Dog, fons, FreqMan, GreekIrish, "
            + "hanneswannerberger, Hybrid_V, ignotus, jc144940, KorgMS2000B, "
            + "LittleRobotSoundFactory, MalMan35, martian, mhtaylor67, "
            + "missozzy, MWLANDI, OtisJames, qubodup, Reitanna, "
            + "Robinhood76, RutgerMuller, rwm28, SmartWentCody, "
            + "Suprasummun, Taira Komori, tec studios, thefilmbakery, "
            + "tiagusilva37, timgormly, thearxx08, viaaico2013, VSokorelos");
        
        
        menOut(Menus.CREDITS);
        GUI.promptOut();
        clearDialog();
        Player.printInv();
    }
// *****************************************************************************       
// </editor-fold>  
// *****************************************************************************           
    
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="LISTENERS">  
// *****************************************************************************
    /**
     * Allows player to go to last keyboard input with arrow keys.
     */
    private static class Text_Field_Key_Listener implements KeyListener {
        private static int undoPosition = 0;
        private static final JScrollBar 
                SB = SCROLLS.getVerticalScrollBar(),
                SN = SCROLLN.getVerticalScrollBar();
        private static final int 
                BACKSPACE = KeyEvent.VK_BACK_SPACE,
                UP = KeyEvent.VK_UP,
                DOWN = KeyEvent.VK_DOWN,
                ENTER = KeyEvent.VK_ENTER,
                OPEN_BRACKET = KeyEvent.VK_OPEN_BRACKET,
                CLOSE_BRACKET = KeyEvent.VK_CLOSE_BRACKET;
        /*------------------------------------------------------*/
        @Override public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case ENTER:
                    undoPosition = 0;
                    break;
                case UP: // Arrow key controls
                    if (undoPosition < UNDO.size())
                        INPUT.setText(UNDO.get(undoPosition++));
                    break;
                case DOWN:
                    INPUT.setText(""); 
                    undoPosition = 0;
                    break;  
                case OPEN_BRACKET:  // Player uses brackets to scroll
                    if (SB.isVisible())
                        SB.setValue(SB.getValue() + 15);
                    if (SN.isVisible())
                        SN.setValue(SN.getValue() + 15);
                    break;
                case CLOSE_BRACKET:
                    if (SB.isVisible())
                        SB.setValue(SB.getValue() - 15);
                    if (SN.isVisible())
                        SN.setValue(SN.getValue() - 15);
                    break;
                case BACKSPACE:
                    break;
                default:
                    AudioPlayer.playKeySound(GUI.keySound);
            }   
        }
        /*------------------------------------------------------*/
        @Override public void keyTyped(KeyEvent e) {}
        /*------------------------------------------------------*/
        @Override public void keyReleased(KeyEvent e) {}
    }
/*----------------------------------------------------------------------------*/
    private static class Text_Field_Listener implements ActionListener {
        /**
         * Waits for text to entered by the player and stores it, then notifies
         * the game to receive the input.
         * Doesn't add save in order to prevent saving repeatedly in quick 
         * succession. Also ignores single-key input and empty strings.
         * @param event Text entered by the player into the text field.
         */
        @Override public void actionPerformed(ActionEvent event) {
            synchronized (HOLDER) {
                HOLDER.recieve(INPUT.getText().toLowerCase().trim());

                if (UNDO.size() == 15)
                    UNDO.removeLast();
                
                String input = HOLDER.request();
                
                if (input.length() > 1 && ! input.equals("save") && ! input.equals("xyzzy"))
                    // Ignores "save" to discourage rapid mischevious saving.
                    // Likewise for "xyzzy", which does a lot of work.
                    // Input of length 1 is insignificant to save.
                    UNDO.push(HOLDER.request());
                
                INPUT.setText("");
                HOLDER.notify();
            }
        } 
    }
/*----------------------------------------------------------------------------*/
    private class Button_Listener implements ActionListener {
        private boolean swapped = false;
        private final Component[] COMP_LIST_1 =
            {SWAP, MUTE, KEYS, COLOR1, COLOR2, ROOM_LBL, MOVE_LBL, SCORE_LBL};
        
        @Override public void actionPerformed(ActionEvent push) { 
            Object o = push.getSource();

            if (o.equals(COLOR2)) { // Change font color of labels and buttons
                AudioPlayer.playEffect(10);
                Color newColor = COLORS_LABEL.peek();
                
                for (Component c : COMP_LIST_1)
                    c.setForeground(newColor);

                COLORS_LABEL.offer(COLORS_LABEL.poll());
            }
            else if (o.equals(MUTE)) { // Toggles ambience
                AudioPlayer.toggleMute((JButton)o);
                AudioPlayer.playEffect(10);
            }
            else if (o.equals(COLOR1)) { // Toggles font color of text areas
                AudioPlayer.playEffect(10);
                Color newColor = COLORS_DIAL.peek();
                MEN_TXT.setForeground(newColor);
                INV_TXT.setForeground(newColor);
                DESC_TXT.setForeground(newColor);
                DIAL_TXT.setForeground(newColor);
                COLORS_DIAL.offer(COLORS_DIAL.poll());
            }
            else if (o.equals(SWAP)) {
                AudioPlayer.playEffect(10);
                swapped = ! swapped;
                GUI.this.setVisible(false);
                
                if (swapped) {
                    EAST.add(SCROLLS, BorderLayout.NORTH);
                    EAST.add(SCROLLN, BorderLayout.SOUTH);
                } else {
                    EAST.add(SCROLLN, BorderLayout.NORTH);
                    EAST.add(SCROLLS, BorderLayout.SOUTH);
                }
                GUI.this.setVisible(true);
            }
            else { // Changes key click noise
                KEYSOUND.offer(KEYSOUND.poll());
                GUI.keySound = KEYSOUND.peek().effectID;
                AudioPlayer.playKeySound(GUI.keySound);
            }
            giveFocus(); // Returns focus to input so player doesn't have to.
        }
    }
// *****************************************************************************
// </editor-fold> BUTTON AND TEXT FIELD LISTENERS
// *****************************************************************************   
    

// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="CUSTOM CARET"> 
// *****************************************************************************    
    /**
     * A simple block caret emulating the command prompt/terminal caret.
     */
    private class RetroCaret extends DefaultCaret {
        public RetroCaret() {
            super();
            this.setBlinkRate(450);
        }
        
        @Override protected synchronized void damage(Rectangle rectangle) {
            if (rectangle != null) {
                this.x = rectangle.x;
                this.y = rectangle.y;
                this.height = rectangle.height;

                if (width <= 0)
                    width = getComponent().getWidth();

                repaint();
            }
        }
        //---------------------------------------------------------------------
        @Override public void paint(Graphics g) {
            JTextComponent comp = getComponent();

            if (comp != null) {
                Rectangle r;

                try {
                    r = comp.modelToView(getDot());

                    if (r == null) 
                        return;
                        
                } catch (BadLocationException e) {
                    return;
                }

                if (x != r.x || y != r.y) {
                    repaint();
                    x = r.x;
                    y = r.y;
                    height = r.height;
                }

                g.setColor(Color.LIGHT_GRAY);
                g.setXORMode(comp.getBackground());

                if (isVisible()) 
                    g.fillRect(x, y, 10, 20);
            }
        }
    }
// *****************************************************************************
// </editor-fold> RETRO CARET
// *****************************************************************************   
}
