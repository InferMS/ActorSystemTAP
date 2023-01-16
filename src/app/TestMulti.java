package app;

import actors.*;
import extra.AddInsultMessage;
import extra.GetInsultMessage;

public class TestMulti {

    public static void main(String[] args) throws InterruptedException {
        ActorInt mensajero = ActorContext.getInstance().spawnActor("FerranXPelirroja", new HelloWorldActor());
        ActorInt mensajeroMain = ActorContext.getInstance().spawnActor_c("FerranEnMain", new HelloWorldActor());
        ActorInt insultador = ActorContext.getInstance().spawnActor("Ander", new InsultActor());
        ActorInt insultadorMain = ActorContext.getInstance().spawnActor_c("AnderenMain", new InsultActor());

        insultador.send(new AddInsultMessage(mensajero, "Eres un gilipollas Ander"));
        insultador.send(new GetInsultMessage(mensajero, "Damelo bobo"));

        insultadorMain.send(new AddInsultMessage(mensajeroMain, "A Marina se la follaran de Erasmus"));
        insultadorMain.send(new GetInsultMessage(mensajeroMain, "Damelo baby"));
        System.out.println(((ActorProxyAnswerMain) insultadorMain).receive());
    }
}
