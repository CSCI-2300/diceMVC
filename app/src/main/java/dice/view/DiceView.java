package dice.view;
import javax.swing.*;
import java.util.ArrayList;

import dice.model.Observer;
import dice.model.Dice;
import dice.ControllerInterface;
public class DiceView implements Observer {

    protected JFrame mainFrame;
    protected JPanel mainPanel;
    protected Dice dice;
    protected ArrayList<DiceLabel> labels;

    public DiceView(Dice dice, ControllerInterface controller) {
        this.dice = dice;
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

        dice.register(this);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void update() {
       for (int i = 0; i < dice.getNumDice(); i++) {
            labels.get(i).setValue(dice.getValue(i));
       } 
    }
}
