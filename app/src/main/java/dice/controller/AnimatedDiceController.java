package dice.controller;

import dice.ControllerInterface;
import dice.view.DiceView;
import dice.model.Dice;

import javax.swing.Timer;
import java.awt.event.*;

public class AnimatedDiceController implements ControllerInterface {
    protected Dice dice;
    protected DiceView view;
    protected int numRolls;

    public AnimatedDiceController(Dice dice) {
        this.dice = dice;
        view = new DiceView(dice, this);
    }

    public void rollDie(int index) {
        numRolls = 0;
        // start a timer
        // attach an anonumous action listener to it, calling the rollOne function
        // stop the timer after 10 callbacks
        final Timer timer = new Timer(200, null);
        timer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dice.rollOne(index);
                numRolls++;
                if (numRolls > 5) {
                    timer.stop();
                }
            }
        });

        timer.start();
    }

    public void rollAll() {
        for (int i = 0; i < dice.getNumDice(); i++) {
            rollDie(i);
        }
    }
}
