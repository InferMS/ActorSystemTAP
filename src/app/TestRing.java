package app;

import actors.ActorContext;
import actors.ActorInt;
import actors.RingActor;
import extra.LinkMessage;
import extra.RingMessage;

public class TestRing {

    public static void main(String[] args) throws InterruptedException {
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

        head.send(new RingMessage(null, null, 100));
    }
}
