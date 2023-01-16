package actors;

import extra.*;

public class RingActor extends Actor {

    ActorInt nextActor;
    boolean head,end;

    public RingActor(boolean head) {
        this.head=head;
        end=false;
    }

    @Override
    public void processMessage(Message message) throws InterruptedException {
        if (message instanceof LinkMessage) {
            nextActor = message.getFromActor();
        }
        else if(message instanceof RingMessage) {
            if (head) {
                ((RingMessage)message).lapDone();
            }
            if (((RingMessage)message).getLaps()>=0) {
                nextActor.send(message);
            }
            else {
                System.out.println("End");
                System.out.println(System.currentTimeMillis() - ((RingMessage)message).getStartTime());
            }
        }
    }
}
