package app;

import actors.*;
import decorators.*;
import extra.*;

public class TestDecorators {

    public static void main(String[] args) throws InterruptedException {
        ActorInt encriptao = ActorContext.getInstance().spawnActor("encriptador", new EncryptionDecorator(new HelloWorldActor()));
        ActorInt encriptao2 = ActorContext.getInstance().spawnActor("encriptador2", new EncryptionDecorator(new HelloWorldActor()));

        //encriptao.send(new EncryptedMessage(encriptao2, encriptar("Pedrito el remolon", 2), 2));


        encriptao.send(new TextMessage(encriptao2, "Pedrito el remolon"));

        ActorInt lambda1 = ActorContext.getInstance().spawnActor("encriptador", new LambdaFirewallDecorator(new HelloWorldActor()));

        lambda1.send(new AddClosureMessage(lambda1, "bobo", (String p) -> p.startsWith("p")));
        lambda1.send(new TextMessage(lambda1, "papi"));
        lambda1.send(new TextMessage(lambda1, "bapi"));


    }
}
