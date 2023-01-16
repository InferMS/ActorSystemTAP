package actors;

import extra.Message;

public interface ActorInt {
    public void send(Message message) throws InterruptedException;
}
