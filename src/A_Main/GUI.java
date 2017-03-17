package A_Main;

import static A_Main.Patterns.*;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import static A_Main.NameConstants.SEP;
import static A_Main.NameConstants.W_DIR;
import java.util.Random;
import java.util.regex.Pattern;
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
    
        public final int soundEffectId; // Index. NONE's should never be used.
        //----------------------------------------
        Click(int key) { 
            this.soundEffectId = key; 
        }
        //----------------------------------------
    }
    
    // <editor-fold defaultstate="collapsed" desc="COMPONENTS AND ATTRIBUTES">
    private static boolean big = true;
    private static int key = Click.NONE.soundEffectId;
    private final static String MOVES = "Moves: ", SCORE = "    Score: ";
    
    private static Font myFont;
    
    private final static JTextArea 
        MEN = new JTextArea(), DESC = new JTextArea(), 
        INV = new JTextArea(), DIAL = new JTextArea();

    private final static JPanel 
        EAST = new JPanel(new BorderLayout()), 
        CNORTH = new JPanel(new BorderLayout()),
        WEST = new JPanel(new BorderLayout()),
        CENTER = new JPanel(), CCENTER = new JPanel(), 
        CSOUTH = new JPanel(), SALAMAA = new JPanel(new FlowLayout(FlowLayout.LEFT));          
    
    private final static JScrollPane 
        SCROLLW = new JScrollPane(DIAL, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
        SCROLLE = new JScrollPane(INV, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    private final static JLabel 
        ROOM = new JLabel(), 
        PROMPT = new JLabel(">"),
        INVLBL = new JLabel();
    
    private final static JButton 
        SIZE = new JButton("Small"),
        MUTE = new JButton("Mute"),
        KEYS = new JButton("Click"),
        COLOR = new JButton("Color");
    
    private final static JTextField 
        INPUT = new JTextField("", 35);
    
    private final static LinkedList<String> UNDO = new LinkedList<>();
    private final static Input_Holder HOLDER = new Input_Holder();
    private final static ArrayList<String> FURN_PARSER = new ArrayList<>();
    private final static LinkedList<Click> KEYSOUND = new LinkedList<>();
    private final static LinkedList<Color> COLORS = new LinkedList<>();

    static {
        KEYSOUND.add(Click.NONE); KEYSOUND.add(Click.SOFT); 
        KEYSOUND.add(Click.CLICK); KEYSOUND.add(Click.VINTAGE); 
        
        COLORS.add(Color.GRAY);  
        COLORS.add(Color.LIGHT_GRAY);
        COLORS.add(Color.GREEN);  
        COLORS.add(new Color(196, 11, 15)); 
        COLORS.add(new Color(141, 28, 179));
        COLORS.add(new Color(150, 84, 13));
    }
    // </editor-fold>
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR AND COMPONENT CONTROLLERS">
// *****************************************************************************     
    public GUI() {
        Font labelFont;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try {
            myFont = Font
                    .createFont(Font.TRUETYPE_FONT, new File(W_DIR, "img" + SEP + "fixedSys.ttf"))
                    .deriveFont(20.0f);

            ge.registerFont(myFont);
        } catch (IOException | FontFormatException e) {
            myFont = new Font("Monospaced", Font.BOLD, 16);
        }
        try {
            labelFont = Font
                    .createFont(Font.TRUETYPE_FONT, new File(W_DIR, "img" + SEP + "MagicMedieval.ttf"));

            ge.registerFont(labelFont);
        } catch (IOException | FontFormatException e) {
            labelFont = new Font("Monospaced", Font.BOLD, 16);
        }

        Color myColor = COLORS.getLast();
        
        SCROLLW.setBackground(Color.DARK_GRAY);
        SCROLLW.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));

        SALAMAA.setBackground(Color.DARK_GRAY);
        SALAMAA.setPreferredSize(new Dimension(390, 47));
        
        JButton[] buttons = {SIZE, MUTE, KEYS, COLOR};
        for (JButton b : buttons) {
            b.setBackground(Color.DARK_GRAY);
            b.setFocusPainted(false);
            b.setForeground(Color.BLACK);
            b.setPreferredSize(new Dimension(69, 35));
            b.setBorder(BorderFactory.createRaisedBevelBorder());
            b.setFont(labelFont.deriveFont(Font.BOLD, 17.0f));
            b.addActionListener(new Button_Listener());
            SALAMAA.add(b);
        }

        WEST.add(SALAMAA, BorderLayout.NORTH);
        WEST.add(SCROLLW, BorderLayout.SOUTH);
        
        CENTER.setLayout(new BorderLayout());
        CNORTH.setBackground(Color.DARK_GRAY);
        ROOM.setFont(labelFont.deriveFont(Font.BOLD, 22.0f));
        ROOM.setForeground(Color.BLACK);
        CNORTH.add(DESC, BorderLayout.NORTH);
        CNORTH.add(ROOM, BorderLayout.SOUTH);
        CCENTER.setBackground(Color.BLACK);
        MEN.setEditable(false);
        MEN.setFont(myFont);
        MEN.setBackground(Color.BLACK);
        MEN.setForeground(myColor);
        CCENTER.add(MEN);
        CSOUTH.setBackground(Color.BLACK);
        INPUT.addActionListener(new Text_Field_Listener());
        INPUT.addKeyListener(new Text_Field_Key_Listener());
        INPUT.setFont(myFont);
        INPUT.setCaret(new RetroCaret());
        INPUT.getCaret().setBlinkRate(450);
        INPUT.setBorder(BorderFactory.createEmptyBorder());
        INPUT.setBackground(Color.BLACK);
        INPUT.setForeground(Color.LIGHT_GRAY);
        INPUT.setCaretColor(Color.GRAY);
        PROMPT.setBackground(Color.BLACK);
        PROMPT.setOpaque(true);
        PROMPT.setHorizontalAlignment(JLabel.RIGHT);
        PROMPT.setPreferredSize(new Dimension(25, 25));
        PROMPT.setFont(myFont.deriveFont(22.0f));
        PROMPT.setForeground(Color.LIGHT_GRAY);
        
        CSOUTH.add(PROMPT);
        CSOUTH.add(INPUT);
        CENTER.add(CNORTH, BorderLayout.NORTH);
        CENTER.add(CCENTER, BorderLayout.CENTER);
        CENTER.add(CSOUTH, BorderLayout.SOUTH);
            
        SCROLLE.setBackground(Color.DARK_GRAY);
        SCROLLE.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        INVLBL.setFont(labelFont.deriveFont(Font.BOLD, 22.0f));
        INVLBL.setForeground(Color.BLACK);
        EAST.add(INVLBL, BorderLayout.NORTH);
        EAST.add(SCROLLE, BorderLayout.SOUTH);
        
        JLabel[] labels = {ROOM, INVLBL};
        for (JLabel l : labels) {
            l.setOpaque(true);      
            l.setBackground(Color.DARK_GRAY);
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setPreferredSize(new Dimension(390, 45));
            l.setBorder(BorderFactory.createEmptyBorder());
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
            DESC.setFont(myFont);
        }
        else {
            WEST.setPreferredSize(new Dimension(300, 510));
            SCROLLW.setPreferredSize(new Dimension(290, 465));
            CENTER.setPreferredSize(new Dimension(400, 510));
            DESC.setPreferredSize(new Dimension(390, 260));
            EAST.setPreferredSize(new Dimension(300, 510));
            SCROLLE.setPreferredSize(new Dimension(290, 465));
            DESC.setFont(myFont.deriveFont(myFont.getSize() - 3.0f));
        }

        this.addComponents(big);
        
        Main.GAME_FRAME.pack();
        Main.GAME_FRAME.setVisible(true);
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
        if (txt != null)
            DIAL.setText(NEWLINE.matcher(txt).replaceAll(" "));
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects all room descriptions.
     * @param txt a room description.
     */
    public static void descOut(String txt) {
        DESC.setText(NEWLINE.matcher(txt).replaceAll(" "));
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects <code>triggeredEvent</code> return text.
     * For triggered events that move the player, <code>null</code> is sent.
     * @param txt <code>triggeredEvent</code> room text
     */
    public static void roomOut(String txt) {
        if (txt != null)
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
     * The player may reference the last typed existing furniture using 'it' or 'them'.
     * This retrieves the last referenced furniture if one exists.
     * Firsts, filters out previous input resembling phrases.
     * Then searches furniture matching the phrase,
     *      - First tries whole string
     *      - If none exists, tries with first word removed. Might be a verb.
     * @return The last referenced object in the player's location.
     */
    public static String parsePreviousFurniture() {
        FURN_PARSER.clear();

        UNDO.stream()
                .filter(i -> (THREE_PLUS_CHAR_WORD.matcher(i).matches()))
                .forEach(j -> 
        {
            if (Player.getPos().hasFurniture(j)
                 || Player.getPos().hasFurniture(
                        j = FURNITURE_SPACE_P.matcher(j).replaceFirst("")))
            {
                FURN_PARSER.add(j); 
            }
        });
        
        return (FURN_PARSER.size() > 0) ? FURN_PARSER.get(0) : "object with that name";
    }
/*----------------------------------------------------------------------------*/
    /**
     * Prints the main menu of controls.
     */
    public static void toMainMenu() {
        MEN.setText(Menus.MAIN_MENU);
    }
/*----------------------------------------------------------------------------*/
    public static void clearDesc() {
        DESC.setText("");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDialog() {
        DIAL.setText("");
        DIAL.setCaretPosition(0);
    }
/*----------------------------------------------------------------------------*/
    public static void updateMovesAndScore(int moves, int score) {
        INVLBL.setText(MOVES + moves + SCORE + score);
    }
/*----------------------------------------------------------------------------*/
    public static void resetScroll() {
        SCROLLW.getVerticalScrollBar().setValue(0);
    }
/*----------------------------------------------------------------------------*/
    public static void giveFocus() {
        // Only used by title frame when the game starts.
        INPUT.requestFocus();
    }
/*----------------------------------------------------------------------------*/
    /**
     * For the easter egg command 'XYZZY'.
     */
    public static void randomizeColors() {
        Random rand = new Random();
        Component[] compList = 
        {ROOM, INVLBL, DIAL, DESC, INV, SIZE, MUTE, CCENTER,
            KEYS, COLOR, PROMPT, MEN, SALAMAA, CSOUTH, INPUT};
        
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
// *****************************************************************************       
// </editor-fold>  
// *****************************************************************************           
    
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="LISTENERS">  
// *****************************************************************************
    /**
     * Allows player to go to last keyboard input with arrow keys.
     */
    private class Text_Field_Key_Listener implements KeyListener {
        private int undoPosition = 0;
        private final int 
                BACKSPACE = KeyEvent.VK_BACK_SPACE,
                UP = KeyEvent.VK_UP,
                DOWN = KeyEvent.VK_DOWN,
                ENTER = KeyEvent.VK_ENTER;
        /*------------------------------------------------------*/
        @Override public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            
            // For playing the key sound
            if (keyCode != BACKSPACE)
                AudioPlayer.playKeySound(key);
            if (keyCode == ENTER)
                undoPosition = 0;

            // For fetching last command or clearing prompt.
            switch(keyCode) {
                case UP:
                    if (undoPosition < UNDO.size())
                        INPUT.setText(UNDO.get(undoPosition++));
                    break;
                case DOWN:
                    INPUT.setText(""); 
                    undoPosition = 0;
                    break;  
            }   
        }
        /*------------------------------------------------------*/
        @Override public void keyTyped(KeyEvent e) {}
        /*------------------------------------------------------*/
        @Override public void keyReleased(KeyEvent e) {}
    }
/*----------------------------------------------------------------------------*/
    private class Text_Field_Listener implements ActionListener {
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

                if (UNDO.size() == 10)
                    UNDO.removeLast();
                
                String input = HOLDER.request();
                
                if (input.length() > 1 && ! input.equals("save"))
                    UNDO.push(HOLDER.request());
                
                INPUT.setText("");
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
                SIZE.setText(big ? "Small" : "Big");
            }
            else if (push.getSource().equals(MUTE)) { // Toggles ambience
                AudioPlayer.playEffect(10);
                MUTE.setText(MUTE.getText().equals("Mute") ? "Unmute" : "Mute");
                AudioPlayer.toggleMute();
            }
            else if (push.getSource().equals(COLOR)) { // Toggles ambience
                AudioPlayer.playEffect(10);
                Color newColor = COLORS.peek();
                COLORS.offer(COLORS.poll());
                MEN.setForeground(newColor);
                INV.setForeground(newColor);
                DESC.setForeground(newColor);
                DIAL.setForeground(newColor);
            }
            else { // Changes key click
                KEYSOUND.offer(KEYSOUND.poll());
                key = KEYSOUND.peek().soundEffectId;
                AudioPlayer.playKeySound(key);
            }
            giveFocus();
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
