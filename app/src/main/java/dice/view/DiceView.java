package dice.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import dice.model.Observer;
import dice.model.Dice;
import dice.ControllerInterface;

public class DiceView implements Observer, ActionListener {

    protected JFrame mainFrame;
    protected JPanel mainPanel;
    protected Dice dice;
    protected ArrayList<DiceLabel> labels;
    protected ControllerInterface controller;

    public DiceView(Dice dice, ControllerInterface controller) {
        this.dice = dice;
        this.controller = controller;

        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainFrame.add(mainPanel);
        
        labels = new ArrayList<DiceLabel>();
        for (int i = 0; i < dice.getNumDice(); i++) {
            DiceLabel label = new DiceLabel(i, controller);
            labels.add(label);
            mainPanel.add(label);
        }                        

        JButton rollAll = new JButton("Roll all");
        rollAll.addActionListener(this);
        mainPanel.add(rollAll);

        dice.register(this);
        mainFrame.pack();
        mainFrame.setVisible(true);


    }

    public void update() {
       for (int i = 0; i < dice.getNumDice(); i++) {
            labels.get(i).setValue(dice.getValue(i));
       } 
    }

    // handles "Roll all" button
    public void actionPerformed(ActionEvent event) {
        controller.rollAll();
    }
}
