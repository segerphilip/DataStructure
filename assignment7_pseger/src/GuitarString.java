import java.util.*;
import javafoundations.*;

public class GuitarString {
    private BoundedQueue<Double> chord;
    private double frequency;

    //-----------------------------------------------------------------
    //  Constructor takes a frequency to build around
    //-----------------------------------------------------------------
    public GuitarString(double frequency) {
        this.frequency = frequency;
        final int sampleRate = 44100;
        int capacity = (int) Math.round(44100 / frequency);
        chord = new BoundedQueue<Double>(capacity);
        for (int i = 0; i < capacity; i++) {
            chord.enqueue((double) 0);
        }
    }

    //-----------------------------------------------------------------
    //  Simulates a pluck by replace all the values in the queue with
    //  a value from -0.5 to 0.5
    //-----------------------------------------------------------------
    public void pluck() {
        Random rand = new Random();
        for (int i = 0; i < frequency; i++) {
            chord.dequeue();
            double randomNum = -0.5 + rand.nextDouble();
            chord.enqueue(randomNum);
        }
    }

    //-----------------------------------------------------------------
    //  Returns the first value in the queue
    //-----------------------------------------------------------------
    public double sample() {
        return chord.first();
    }

    //-----------------------------------------------------------------
    //  Dequeues, takes the average of it and the sample, then multiplies
    //  by .944 to create an energy decay factor
    //-----------------------------------------------------------------
    public void tic() {
        try {
            double note = chord.dequeue();
            double newnote = ((note + chord.first()) * 0.994) / 2;
            chord.enqueue(newnote);
        }
        catch (NullPointerException exception) {
            System.out.println("Empty array");
        }
    }

    //-----------------------------------------------------------------
    //  Testing code
    //-----------------------------------------------------------------
    public static void main(String[] args) {
        GuitarString gs1 = new GuitarString(10);
        gs1.pluck();
        gs1.pluck();
    }
}