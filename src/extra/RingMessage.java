package extra;

import actors.ActorInt;

public class RingMessage extends Message{

    int laps;
    long startTime;

    public RingMessage(ActorInt fromActor, String message, int laps) {
        super(fromActor, message);
        this.laps=laps;
        startTime = System.currentTimeMillis();

    }

    public long getStartTime() {
        System.out.println(startTime);
        return startTime;
    }

    public int getLaps() {return laps;}

    public void lapDone() {laps--;}

}
