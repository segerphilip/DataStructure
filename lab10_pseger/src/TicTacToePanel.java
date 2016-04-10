
/**
 * FILE NAME: TicTacToePanel.java
 * WHO: CS230 staff
 * WHAT: Sets up the Panel that contains the TicTacToe game.
 * It communicates with the TicTacToe.java class where
 * the functionality of the game resides.
 * <p>
 * Stella Feb 13: added the "play again" button and its functionality
 * Sohie Sep 13: updated border layout locations to page_start, page_end, etc, and added background colors
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToePanel extends JPanel {
    //instance vars

    private ImageIcon xImg, oImg, tieImg; //these images will be used in a couple
    // of diff methods,so make them instance vars, and create them only once.
    private JButton push1, push2, push3, push4, push5, push6, push7, push8, push9;
    private TicTacToe game;
    private JPanel buttonPanel;


    // TicTacToePanel constructor. Notice how it takes an instance of the game as input!
    public TicTacToePanel(TicTacToe g) {


        this.game = g;

        push1 = new JButton("");
        push2 = new JButton("");
        push3 = new JButton("");

        ButtonListener listener = new ButtonListener();

        push1.addActionListener(listener);
        push2.addActionListener(listener);
        push3.addActionListener(listener);
      /*
    xImg = createImageIcon("images/X.jpg",
                           "an X image");
    oImg = createImageIcon("images/O.jpg",
                           "a Y image");
    tieImg = createImageIcon("images/Tie.jpg",
                             "a tie image");
       */

        buttonPanel = new JPanel();
        buttonPanel.add(push1);
        buttonPanel.add(push2);
        buttonPanel.add(push3);


        setLayout(new BorderLayout(10, 10)); // hgap, vgap
        setBackground (Color.blue); // to match the background color of center grid panel

        add(buttonPanel);
        add(push1);
        add(push2);
        add(push3);
    }

    /**
     * Creates and returns an ImageIcon out of an image file.
     *
     * @param path        The path to the imagefile relevant to the current file.
     * @param description A short description to the image.
     * @return ImageIcon An ImageIcon, or null if the path was invalid.
     */
    private static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = TicTacToe.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
} //end TicTacToePanel public class
