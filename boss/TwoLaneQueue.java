package cs410;

import java.util.Collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;
public class TwoLaneQueue {
    public int fastturns; // this counter
    Queue<String> fastLane;// this is Queue for fastlane
    Queue<String> slowLane;//this is Queue for slowlane
    TwoLaneQueue() {
        fastturns = 0;
        fastLane = new LinkedList<>();
        slowLane = new LinkedList<>();
    }
    //we are  enqueueing lane to the fastlane
    public void enqueueFast(String lane) {
        fastLane.add(lane);
    }
    //we are adding enqueueing an lane  to the slowlane
    public void enqueueSlow(String lane) {
        slowLane.add(lane);
    }
    //we are  dequeue and return from the  fast or slow
    //we are  dequeue and return from the  fast or slow
    public String dequeue() {
        if (!fastLane.isEmpty()) {
            fastturns++; //increament fasturns
            return fastLane.remove();
        }
        //else if slowlane is empty
        else if (!slowLane.isEmpty()) {
// if our fatsturn is >= 3
            if (fastturns >= 3) {
                fastturns = 0;
                //then return and remmove slowlane
                return slowLane.remove();
            }
            else {

                return slowLane.remove();
            }


        }
        else {

            //or throw
            throw new NoSuchElementException("Empty lane");
        }


    }
}

