package dice.controller;

import dice.ControllerInterface;
import dice.view.DiceView;
import dice.model.Dice;

public class DiceController implements ControllerInterface {
    protected Dice dice;
    protected DiceView view;

    public DiceController(Dice dice) {
        this.dice = dice;
        view = new DiceView(dice, this);
    }

    public void rollDie(int index) {
        dice.rollOne(index);
    }

    public void rollAll() {
        dice.rollAll();
    }
}
