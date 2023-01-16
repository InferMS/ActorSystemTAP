package extra;

import actors.ActorInt;

public class PingPongMessage extends Message {

    private int bounces;

    public PingPongMessage(ActorInt fromActor, String message, int bounces) {
        super(fromActor, message);
        this.bounces=bounces;
    }

    public void decreaseBounce() {bounces--;}

    public int getBounces() {
        return bounces;
    }

}
