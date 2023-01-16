package app;

import actors.*;
import extra.TextMessage;

public class TestHelloWorld {

    public static void main(String[] args) throws InterruptedException {
        ActorProxy helloWorld = ActorContext.getInstance().spawnActor("FerranXPelirroja", new HelloWorldActor());

        try { helloWorld.send(new TextMessage(null , "Solo quiere jugar contigo bro"));}
        catch (Exception e) {
            System.out.println("Nop, thread terminado");
        }
    }
}
