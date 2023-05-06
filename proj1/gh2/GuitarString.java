package gh2;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Random;
import java.lang.Math;


//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor


    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your should initially fill your buffer array with zeros.

        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayDeque<>(capacity);
        for(int i = 0; i < capacity; i++){
            buffer.addLast(0.0);
        }

    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.

        double r = Math.random() - 0.5;
        for(int i = 0; i < buffer.size(); i++){
            buffer.removeFirst();
            buffer.addLast(r);
        }

    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {

       double frontSample = buffer.removeFirst();
       double nextSample = buffer.getFirst();
       double newSample = (frontSample + nextSample) * 0.5 * DECAY;
       buffer.addLast(newSample);

    }

    /* Return the double at the front of the buffer. */
    public double sample() {

        return buffer.getFirst();
    }
}

