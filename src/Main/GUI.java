package Main;

import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
/******************************************************************************
 * This class is responsible for the game interface.
 * All graphical components are set up here.
 * Any text useful to the player is collected here and displayed.
 * Any input from the player is processed here.
 * @author Kevin Rapa
 ******************************************************************************/
public class GUI extends JPanel {
    private boolean big = true;
    private final static JTextArea MEN = new JTextArea(), DESC = new JTextArea(), 
                                   INV = new JTextArea(), DIAL = new JTextArea();

    private final static JPanel EAST = new JPanel(new BorderLayout()), 
                                CNORTH = new JPanel(new BorderLayout()),
                                WEST = new JPanel(new BorderLayout()),
                                CENTER = new JPanel(), CCENTER = new JPanel(), 
                                CSOUTH = new JPanel(), SALAMAA = new JPanel(new FlowLayout(FlowLayout.LEFT));          
    
    private final static JLabel ROOM = new JLabel(), 
                                INVLBL = new JLabel("Inventory");
    
    private final static JButton SIZE = new JButton("Small Mode");
    private final static JTextField INPUT = new JTextField(23);
    private final static LinkedList<String> HOLDER = new LinkedList<>();
    private final static JScrollPane SCROLL = new JScrollPane(DIAL, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                                                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
/* CONSTRUCTOR ---------------------------------------------------------------*/ 
    public GUI() {
        // COMPONENT INSTANTIATION --------------------------------------------
        Font myFont = new Font("Monospaced", Font.BOLD, 16);
        Font labelFont = new Font("MagicMedieval", Font.BOLD, 20);
        Color myColor = new Color(150, 84, 13);
        
        SCROLL.setBackground(Color.DARK_GRAY);
        SCROLL.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        SIZE.setBackground(Color.DARK_GRAY);
        SIZE.setFocusPainted(false);
        SIZE.setForeground(Color.BLACK);
        SIZE.setPreferredSize(new Dimension(90, 30));
        SIZE.setBorder(BorderFactory.createRaisedBevelBorder());
        SIZE.setFont(new Font("MagicMedieval", Font.BOLD, 15));
        SIZE.addActionListener(new Size_Listener());
        SALAMAA.setBackground(Color.darkGray);
        SALAMAA.setPreferredSize(new Dimension(390, 45));
        SALAMAA.setBorder(BorderFactory.createRaisedBevelBorder());
        SALAMAA.add(SIZE);
        WEST.add(SALAMAA, BorderLayout.NORTH);
        WEST.add(SCROLL, BorderLayout.SOUTH);
        
        CENTER.setLayout(new BorderLayout());
        CNORTH.setBackground(Color.DARK_GRAY);
        DESC.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));  
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
        INPUT.setFont(myFont);
        INPUT.setBorder(BorderFactory.createLoweredBevelBorder());
        INPUT.setBackground(Color.DARK_GRAY);
        INPUT.setForeground(Color.BLACK);
        CSOUTH.add(INPUT);
        CENTER.add(CNORTH, BorderLayout.NORTH);
        CENTER.add(CCENTER, BorderLayout.CENTER);
        CENTER.add(CSOUTH, BorderLayout.SOUTH);
            
        INV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        INVLBL.setFont(labelFont);
        INVLBL.setForeground(Color.BLACK);
        EAST.add(INVLBL, BorderLayout.NORTH);
        EAST.add(INV, BorderLayout.SOUTH);
        
        JLabel[] labels = {ROOM, INVLBL};
        for (JLabel C : labels) {
            C.setOpaque(true);      
            C.setBackground(Color.DARK_GRAY);
            C.setHorizontalAlignment(JLabel.CENTER);
            C.setPreferredSize(new Dimension(390, 45));
            C.setBorder(BorderFactory.createRaisedBevelBorder());
        }
        
        JTextArea[] textAreas = {DIAL, DESC, INV};
        for (JTextArea C : textAreas) {
            C.setEditable(false);       C.setLineWrap(true);
            C.setWrapStyleWord(true);   C.setBackground(Color.BLACK);
            C.setForeground(myColor);   C.setFont(myFont);
        }
        
        INPUT.setPreferredSize(new Dimension(400, 40));
        WEST.setPreferredSize(new Dimension(300, 600));
        SCROLL.setPreferredSize(new Dimension(290, 555));
        CENTER.setPreferredSize(new Dimension(400, 600));
        DESC.setPreferredSize(new Dimension(390, 350));
        EAST.setPreferredSize(new Dimension(300, 600));
        INV.setPreferredSize(new Dimension(290, 555));

        this.addComponents(true);
    }
/*----------------------------------------------------------------------------*/     
    private void addComponents(boolean big) {
        this.setPreferredSize(new Dimension (big ? 1000 : 935, big ? 600: 510));
        this.setLayout(new BorderLayout());
        this.add(WEST, BorderLayout.WEST);
        this.add(CENTER, BorderLayout.CENTER);
        this.add(EAST, BorderLayout.EAST);
    }
// *****************************************************************************
// <editor-fold desc="COLLECTORS">
//    
// These five methods collect all text output in the game for the player.
// Each method sets the text of a different GUI component.    
// *****************************************************************************       
    /**
     * Collects all text not collected by the other collectors.
     * @param txt dialog text.
     */
    public static void out(String txt) {
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
     * Collects all <code>toString</code> method return text.
     * @param txt inventory toString method return text.
     * @see Inventory#toString() 
     */
    public static void invOut(String txt) {
        INV.setText(txt);
    }
// *****************************************************************************
// </editor-fold>
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
            catch (InterruptedException e) {}
        }
        return HOLDER.pop();
    }
/*----------------------------------------------------------------------------*/
    /**
     * Prints the main menu of controls.
     */
    public static void clearMenu() {
        MEN.setText("     <'w'/'s'/'a'/'d'> Move\n<'e'> Search     "
                   + "<'c'> Inspect\n<'x'> Activate   <'i'> Inventory\n<'k'> Keyring    "
                   + "<'h'> Get help\n         <'quit'> Quit");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDesc() {
        DESC.setText("");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDialog() {
        DIAL.setText("");
    }
/*----------------------------------------------------------------------------*/
    /**
     * Resizes the frame and components when the resize button in the upper-right
     * is pressed.
     * 
     * @param big If the frame is entering big mode.
     */
    private void smallMode(boolean big) {
        Salamaa.gameFrame.setVisible(false);
        
        this.removeAll();
        
        if (big) {
            WEST.setPreferredSize(new Dimension(300, 600));
            SCROLL.setPreferredSize(new Dimension(290, 555));
            CENTER.setPreferredSize(new Dimension(400, 600));
            DESC.setPreferredSize(new Dimension(390, 350));
            EAST.setPreferredSize(new Dimension(300, 600));
            INV.setPreferredSize(new Dimension(290, 555));
        }
        else {
            WEST.setPreferredSize(new Dimension(275, 510));
            SCROLL.setPreferredSize(new Dimension(265, 465));
            CENTER.setPreferredSize(new Dimension(375, 510));
            DESC.setPreferredSize(new Dimension(365, 260));
            EAST.setPreferredSize(new Dimension(275, 510));
            INV.setPreferredSize(new Dimension(265, 465));
        }
        
        Component[] comps = {MEN, INPUT, DIAL, DESC, INV};
        for (Component c : comps)
            c.setFont(new Font("Monospaced", Font.BOLD, big ? 16 : 14));
        
        this.addComponents(big);
        
        Salamaa.gameFrame.pack();
        Salamaa.gameFrame.setVisible(true);
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
                HOLDER.add(INPUT.getText());
                INPUT.setText("");
                HOLDER.notify();
            }
        } 
    }
/*----------------------------------------------------------------------------*/
    private class Size_Listener implements ActionListener {
        /**
         * Resizes the game panel. 
         * On some monitors, the frame has been to large.
         * @param push A push of the SIZE button.
         */
        @Override public void actionPerformed(ActionEvent push) {
            AudioPlayer.playEffect(10);
            big = ! big;
            smallMode(big);
            SIZE.setText(big ? "Small mode" : "Big mode");
        }
    }
/*----------------------------------------------------------------------------*/
}