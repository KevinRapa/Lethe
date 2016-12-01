package Core;

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
 * @author Mantis Toboggan
 ******************************************************************************/
public class GUI extends JPanel {
    private static JTextArea MENU, DESC, INV, DIALOG;
    private static JTextField INPUT;
    private static JPanel EAST, CENTER, CNORTH, CCENTER, CSOUTH, WEST;
    private static JLabel ROOM, INVLBL, SALAMAA;
    private static final LinkedList<String> HOLDER = new LinkedList();
    private static JScrollPane SCROLL;
/* CONSTRUCTOR ---------------------------------------------------------------*/ 
    public GUI(boolean normalSize) {
        // COMPONENT INSTANTIATION --------------------------------------------
        Font myFont = new Font("Monospaced", Font.BOLD, 17);
        
        WEST = new JPanel(new BorderLayout());
        DIALOG = new JTextArea();
        DIALOG.setBackground(Color.BLACK);
        DIALOG.setForeground(new Color(150, 84, 13));
        DIALOG.setLineWrap(true);
        DIALOG.setWrapStyleWord(true);
        DIALOG.setFont(myFont);
        DIALOG.setEditable(false);
        SCROLL = new JScrollPane(DIALOG, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLL.setBackground(Color.DARK_GRAY);
        SCROLL.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        SALAMAA = new JLabel();
        SALAMAA.setOpaque(true);
        SALAMAA.setBackground(Color.DARK_GRAY);
        SALAMAA.setBorder(BorderFactory.createRaisedBevelBorder());
        SALAMAA.setHorizontalAlignment(JLabel.CENTER);
        WEST.add(SALAMAA, BorderLayout.NORTH);
        WEST.add(SCROLL, BorderLayout.SOUTH);
        
        CENTER = new JPanel();
        CENTER.setLayout(new BorderLayout());
        CNORTH = new JPanel(new BorderLayout());
        CNORTH.setBackground(Color.DARK_GRAY);
        DESC = new JTextArea();
        DESC.setEditable(false);
        DESC.setLineWrap(true);
        DESC.setWrapStyleWord(true);
        DESC.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        DESC.setBackground(Color.BLACK);
        DESC.setForeground(new Color(150, 84, 13));
        ROOM = new JLabel();       
        ROOM.setOpaque(true);
        ROOM.setBackground(Color.DARK_GRAY);
        ROOM.setBorder(BorderFactory.createRaisedBevelBorder());
        ROOM.setFont(myFont);
        ROOM.setForeground(Color.BLACK);
        ROOM.setHorizontalAlignment(JLabel.CENTER);
        CNORTH.add(DESC, BorderLayout.NORTH);
        CNORTH.add(ROOM, BorderLayout.SOUTH);
        CCENTER = new JPanel();
        CCENTER.setBackground(Color.BLACK);
        MENU = new JTextArea();
        MENU.setEditable(false);
        MENU.setFont(myFont);
        MENU.setBackground(Color.BLACK);
        MENU.setForeground(new Color(150, 84, 13));
        CCENTER.add(MENU);
        CSOUTH = new JPanel();
        CSOUTH.setBackground(Color.DARK_GRAY);
        INPUT = new JTextField(23);
        INPUT.addActionListener(new Text_Field_Listener());
        INPUT.setFont(myFont);
        INPUT.setBorder(BorderFactory.createLoweredBevelBorder());
        INPUT.setBackground(Color.DARK_GRAY);
        INPUT.setForeground(Color.BLACK);
        CSOUTH.add(INPUT);
        CENTER.add(CNORTH, BorderLayout.NORTH);
        CENTER.add(CCENTER, BorderLayout.CENTER);
        CENTER.add(CSOUTH, BorderLayout.SOUTH);
        
        EAST = new JPanel(new BorderLayout());      
        INV = new JTextArea();
        INV.setEditable(false);
        INV.setFont(myFont);
        INV.setLineWrap(true);
        INV.setWrapStyleWord(true);
        INV.setBackground(Color.BLACK);
        INV.setForeground(new Color(150, 84, 13));
        INV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        INVLBL = new JLabel("Inventory");
        INVLBL.setOpaque(true);
        INVLBL.setBackground(Color.DARK_GRAY);
        INVLBL.setBorder(BorderFactory.createRaisedBevelBorder());
        INVLBL.setFont(myFont);
        INVLBL.setForeground(Color.BLACK);
        INVLBL.setHorizontalAlignment(JLabel.CENTER);
        EAST.add(INVLBL, BorderLayout.NORTH);
        EAST.add(INV, BorderLayout.SOUTH);
        
        if (normalSize) {
        DESC.setFont(myFont);
        WEST.setPreferredSize(new Dimension(300, 600));
        SCROLL.setPreferredSize(new Dimension(290, 555));
        SALAMAA.setPreferredSize(new Dimension(390, 45));
        
        CENTER.setPreferredSize(new Dimension(400, 600));
        DESC.setPreferredSize(new Dimension(390, 350));
        ROOM.setPreferredSize(new Dimension(390, 45));
        INPUT.setPreferredSize(new Dimension(400, 40));
        
        EAST.setPreferredSize(new Dimension(300, 600));
        INV.setPreferredSize(new Dimension(290, 555));
        INVLBL.setPreferredSize(new Dimension(390, 45));
        }
        else {
        // IF THE WINDOW IS TOO TALL
        DESC.setFont(new Font("Monospaced", Font.BOLD, 15));
        WEST.setPreferredSize(new Dimension(300, 500));
        SCROLL.setPreferredSize(new Dimension(290, 455));
        SALAMAA.setPreferredSize(new Dimension(390, 45));
        
        CENTER.setPreferredSize(new Dimension(400, 500));
        DESC.setPreferredSize(new Dimension(390, 250));
        ROOM.setPreferredSize(new Dimension(390, 45));
        INPUT.setPreferredSize(new Dimension(400, 40));
        
        EAST.setPreferredSize(new Dimension(300, 500));
        INV.setPreferredSize(new Dimension(290, 455));
        INVLBL.setPreferredSize(new Dimension(390, 45));
        }
        
        this.addComponents(normalSize);
        
    }
/*----------------------------------------------------------------------------*/     
    private void addComponents(boolean normalSize) {
        if (normalSize)
            this.setPreferredSize(new Dimension (1000, 600));
        else
            this.setPreferredSize(new Dimension (1000, 500));
        
        this.setBackground(Color.BLACK);
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
        DIALOG.setText(txt.replaceAll("\n", " "));
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
        MENU.setText(txt);
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
    public static void clearMenu() {
        MENU.setText("         <w/s/a/d> Move\n<'e'> Search     "
                   + "<'c'> Inspect\n<'x'> Activate   <'i'> Inventory\n<'k'> Keyring    "
                   + "<'h'> Get help\n    <'quit'> Save and quit");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDesc() {
        DESC.setText("");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDialog() {
        DIALOG.setText("");
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
}
