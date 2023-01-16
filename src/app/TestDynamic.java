package app;

import actors.ActorContext;
import actors.ActorProxy;
import actors.InsultActor;
import dynamicproxy.DynamicProxy;
import dynamicproxy.InsultInt;
import dynamicproxy.InsultService;

public class TestDynamic {

    public static void main(String[] args) {
        ActorProxy actor = ActorContext.getInstance().spawnActor("pedro", new InsultActor());
        InsultInt insulter = (InsultInt) DynamicProxy.intercept(new InsultService(), actor);
        insulter.addInsult("Perro hijueputa");
        insulter.addInsult("Perro pendejo");
        insulter.getInsult();
        insulter.getInsult();
    }
}
