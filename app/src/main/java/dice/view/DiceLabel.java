package dice.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dice.ControllerInterface;

public class DiceLabel extends JLabel implements MouseListener {

    public static String []diceValues = {"\u2680", "\u2681", "\u2682", "\u2683", "\u2684", "\u2685"};

    protected int index;
    protected ControllerInterface controller;

    public DiceLabel(int index, ControllerInterface controller) {
        this.index = index;
        this.setText(diceValues[0]);
        this.addMouseListener(this);        
        this.controller = controller;

        // set the size of the dice by calling methods of JLabel
        this.setFont(new Font("Symbola",Font.PLAIN,100));
    }

    public void setValue(int value) {
        this.setText(diceValues[value-1]);
    }

    @Override
    public void mouseEntered(MouseEvent event) {}
    @Override
    public void mouseExited(MouseEvent event){}
    @Override 
    public void mousePressed(MouseEvent event){}
    @Override 
    public void mouseReleased(MouseEvent event){}

    @Override 
    public void mouseClicked(MouseEvent event) {
        System.out.println("FIX ME: User wants to roll die " + index);
        controller.rollDie(index);
    }     
}
