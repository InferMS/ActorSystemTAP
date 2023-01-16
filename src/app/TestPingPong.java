package app;

import actors.ActorContext;
import actors.ActorInt;
import actors.PingPongActor;
import extra.PingPongMessage;

public class TestPingPong {

    public static void main(String[] args) throws InterruptedException {
        ActorInt pingActor = ActorContext.getInstance().spawnActor("ping", new PingPongActor());
        ActorInt pongActor = ActorContext.getInstance().spawnActor("pong", new PingPongActor());

        pongActor.send(new PingPongMessage(pingActor, null, 7));
    }
}
