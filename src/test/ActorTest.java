package test;

import actors.ActorContext;
import actors.ActorInt;
import actors.PingPongActor;
import actors.RingActor;
import extra.LinkMessage;
import extra.PingPongMessage;
import extra.RingMessage;
import org.junit.Assert;
import org.junit.Test;

public class ActorTest {

    @Test
    public void testRing() throws InterruptedException{
        ActorInt head = ActorContext.getInstance().spawnActor("head", new RingActor(true));
        ActorInt actorAux = ActorContext.getInstance().spawnActor(String.valueOf(1), new RingActor(false));
        ActorInt actorAux2;

        for (int i = 0; i < 100; i++) {


            if (i==0) {
                head.send(new LinkMessage(actorAux, null));
            }
            else if(i==99) {
                actorAux.send(new LinkMessage(head, null));
            }
            else {
                actorAux2 = ActorContext.getInstance().spawnActor(String.valueOf(i+1), new RingActor(false));
                actorAux.send(new LinkMessage(actorAux2, null));
                actorAux = actorAux2;
            }
        }
        RingMessage message = new RingMessage(null, null, 100);
        head.send(message);
        System.out.println("-> TESTING RING...");
        Thread.sleep(1000);
        Assert.assertTrue(message.getLaps()==-1);
    }

    @Test
    public void testPingPong() throws InterruptedException{
        ActorInt pingActor = ActorContext.getInstance().spawnActor("ping", new PingPongActor());
        ActorInt pongActor = ActorContext.getInstance().spawnActor("pong", new PingPongActor());

        PingPongMessage message = new PingPongMessage(pingActor, null, 7);
        pongActor.send(message);
        System.out.println("-> TESTING PING PONG...");
        Thread.sleep(1000);
        Assert.assertTrue(message.getBounces()==-1);
    }
}
