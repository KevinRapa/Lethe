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
    public GUI() {
        // COMPONENT INSTANTIATION --------------------------------------------
        WEST = new JPanel(new BorderLayout());
        WEST.setPreferredSize(new Dimension(300, 600));
        DIALOG = new JTextArea();
        DIALOG.setBackground(Color.BLACK);
        DIALOG.setForeground(new Color(150, 84, 13));
        DIALOG.setLineWrap(true);
        DIALOG.setWrapStyleWord(true);
        DIALOG.setFont(new Font("Monospaced", Font.BOLD, 17));
        DIALOG.setEditable(false);
        SCROLL = new JScrollPane(DIALOG, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLL.setPreferredSize(new Dimension(290, 555));
        SCROLL.setBackground(Color.DARK_GRAY);
        SCROLL.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        SALAMAA = new JLabel();
        SALAMAA.setPreferredSize(new Dimension(390, 45));
        SALAMAA.setOpaque(true);
        SALAMAA.setBackground(Color.DARK_GRAY);
        SALAMAA.setBorder(BorderFactory.createRaisedBevelBorder());
        SALAMAA.setFont(new Font("Monospaced", Font.BOLD, 17));
        SALAMAA.setForeground(Color.BLACK);
        SALAMAA.setHorizontalAlignment(JLabel.CENTER);
        WEST.add(SALAMAA, BorderLayout.NORTH);
        WEST.add(SCROLL, BorderLayout.SOUTH);
        
        CENTER = new JPanel();
        CENTER.setLayout(new BorderLayout());
        CENTER.setPreferredSize(new Dimension(400, 600));
        CNORTH = new JPanel(new BorderLayout());
        CNORTH.setBackground(Color.DARK_GRAY);
        DESC = new JTextArea();
        DESC.setEditable(false);
        DESC.setPreferredSize(new Dimension(390, 350));
        DESC.setLineWrap(true);
        DESC.setWrapStyleWord(true);
        DESC.setFont(new Font("Monospaced", Font.BOLD, 17));
        DESC.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        DESC.setBackground(Color.BLACK);
        DESC.setForeground(new Color(150, 84, 13));
        ROOM = new JLabel();
        ROOM.setPreferredSize(new Dimension(390, 45));
        ROOM.setOpaque(true);
        ROOM.setBackground(Color.DARK_GRAY);
        ROOM.setBorder(BorderFactory.createRaisedBevelBorder());
        ROOM.setFont(new Font("Monospaced", Font.BOLD, 17));
        ROOM.setForeground(Color.BLACK);
        ROOM.setHorizontalAlignment(JLabel.CENTER);
        CNORTH.add(DESC, BorderLayout.NORTH);
        CNORTH.add(ROOM, BorderLayout.SOUTH);
        CCENTER = new JPanel();
        CCENTER.setBackground(Color.BLACK);
        MENU = new JTextArea();
        MENU.setEditable(false);
        MENU.setFont(new Font("Monospaced", Font.BOLD, 17));
        MENU.setBackground(Color.BLACK);
        MENU.setForeground(new Color(150, 84, 13));
        CCENTER.add(MENU);
        CSOUTH = new JPanel();
        CSOUTH.setBackground(Color.DARK_GRAY);
        INPUT = new JTextField(23);
        INPUT.setPreferredSize(new Dimension(400, 40));
        INPUT.addActionListener(new Text_Field_Listener());
        INPUT.setFont(new Font("Monospaced", Font.BOLD, 17));
        INPUT.setBorder(BorderFactory.createLoweredBevelBorder());
        INPUT.setBackground(Color.DARK_GRAY);
        INPUT.setForeground(Color.BLACK);
        CSOUTH.add(INPUT);
        CENTER.add(CNORTH, BorderLayout.NORTH);
        CENTER.add(CCENTER, BorderLayout.CENTER);
        CENTER.add(CSOUTH, BorderLayout.SOUTH);
        
        EAST = new JPanel(new BorderLayout());
        EAST.setPreferredSize(new Dimension(300, 600));
        INV = new JTextArea();
        INV.setEditable(false);
        INV.setPreferredSize(new Dimension(290, 555));
        INV.setFont(new Font("Monospaced", Font.BOLD, 17));
        INV.setLineWrap(true);
        INV.setWrapStyleWord(true);
        INV.setBackground(Color.BLACK);
        INV.setForeground(new Color(150, 84, 13));
        INV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        INVLBL = new JLabel("Inventory");
        INVLBL.setPreferredSize(new Dimension(390, 45));
        INVLBL.setOpaque(true);
        INVLBL.setBackground(Color.DARK_GRAY);
        INVLBL.setBorder(BorderFactory.createRaisedBevelBorder());
        INVLBL.setFont(new Font("Monospaced", Font.BOLD, 17));
        INVLBL.setForeground(Color.BLACK);
        INVLBL.setHorizontalAlignment(JLabel.CENTER);
        EAST.add(INVLBL, BorderLayout.NORTH);
        EAST.add(INV, BorderLayout.SOUTH);
        
        this.addComponents();
        
    }
/*----------------------------------------------------------------------------*/     
    private void addComponents() {
        this.setPreferredSize(new Dimension (1000, 600));
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
        MENU.setText("        -wsad- Move\n-e- Search     "
                   + "-c- Inspect\n-x- Activate   -i- Inventory\n-k- Keyring    "
                   + "-h- Help\n        -quit- Quit");
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
