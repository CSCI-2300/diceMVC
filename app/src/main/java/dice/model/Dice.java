package dice.model;

import java.util.ArrayList;
import java.util.Random;

public class Dice {

    protected ArrayList<Integer> values;
    protected Random randomizer;
    protected ArrayList<Observer> observers;

    public Dice(int numDice) {
        observers = new ArrayList<Observer>();

        values = new ArrayList<Integer>();
        for (int i = 0; i < numDice; i++) {
            values.add(1);
        }
        randomizer = new Random();
    }

    public void rollOne(int index) {
        int newValue = randomizer.nextInt(5)+1;
        values.set(index, newValue);
        notifyObservers();
    }

    public void rollAll() {
        System.out.println("Rolling one");
        for (int i = 0; i < values.size(); i++) {
            rollOne(i);
        }
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public int getNumDice() {
        return values.size();
    }

    public void notifyObservers() {
        for (Observer o: observers) {
            o.update();
        }
    }

    public int getValue(int i) {
        return values.get(i);
    }
}
