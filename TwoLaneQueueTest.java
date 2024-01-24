package cs410;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
public class TwoLaneQueueTest {
    @Test
    public void testEnqueueFfasLAne() {

        TwoLaneQueue queue = new TwoLaneQueue();

        //we have to enqueue fastlane

        queue.fastLane.add("faSt 1");

        queue.fastLane.add("faSt 2");


        //we have to dequeue
        String res = queue.dequeue();
        //come from faslane
        assertEquals("faSt 1", res);
    }
    @Test
    public void  testSDequeuefSlowlane(){

        TwoLaneQueue queue = new TwoLaneQueue();
        queue.slowLane.add("sLow 1");
        queue.slowLane.add("sLow 2");
        //dequeue
        String res  = queue.dequeue();

        //come from slowlane
        assertEquals("sLow 1", res);
    }
    @Test
    public void testLane(){

        TwoLaneQueue queue = new TwoLaneQueue();
        queue.fastLane.add("faSt 1");
        queue.fastLane.add("faSt 2");
        queue.slowLane.add("sLow 1");
        queue.slowLane.add("sLow 2");
        //we have to dequeu 4 elements
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        String res = queue.dequeue();
        assertEquals("sLow 2", res);
    }
}