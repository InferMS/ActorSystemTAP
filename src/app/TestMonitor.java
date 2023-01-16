package app;

import observer.MonitorService;
import actors.ActorContext;
import actors.ActorProxy;
import actors.HelloWorldActor;
import extra.QuitMessage;
import extra.TextMessage;

public class TestMonitor {

    public static void main(String[] args) throws InterruptedException {
        MonitorService monitor = new MonitorService();
        ActorProxy actor = ActorContext.getInstance().spawnActor("El Padre De Ismael", new HelloWorldActor());
        ActorProxy ainhoa = ActorContext.getInstance().spawnActor("ainhoa", new HelloWorldActor());
        ActorProxy ismael = ActorContext.getInstance().spawnActor("ismael", new HelloWorldActor());

        monitor.monitorActor("El Padre De Ismael");
        monitor.monitorActor("ainhoa");
        monitor.monitorActor("ismael");

        actor.send(new TextMessage(actor, "Samba"));
        monitor.startMessageLog("El Padre De Ismael");
        monitor.startEventLog("El Padre De Ismael");
        actor.send(new TextMessage(actor, "d"));
        actor.send(new TextMessage(actor, "s"));
        actor.send(new QuitMessage(actor, "finalización"));

        ainhoa.send(new TextMessage(ismael, "Te"));
        ainhoa.send(new TextMessage(ismael, "follo"));
        ainhoa.send(new TextMessage(ismael, "pedazo"));
        ainhoa.send(new TextMessage(ismael, "de"));
        ainhoa.send(new TextMessage(ismael, "guarra"));
        ainhoa.send(new TextMessage(ismael, "!"));

        ismael.send(new TextMessage(ainhoa, "Oh"));
        ismael.send(new TextMessage(ainhoa, "Si"));
        ismael.send(new TextMessage(ainhoa, "Mi"));
        ismael.send(new TextMessage(ainhoa, "Papi"));
        ismael.send(new TextMessage(ainhoa, "Chulo"));
        ismael.send(new TextMessage(ainhoa, "Estoy"));
        ismael.send(new TextMessage(ainhoa, "Mas"));
        ismael.send(new TextMessage(ainhoa, "Caliente"));
        ismael.send(new TextMessage(ainhoa, "Que"));
        ismael.send(new TextMessage(ainhoa, "Un"));
        ismael.send(new TextMessage(ainhoa, "Radiador"));
        ismael.send(new TextMessage(ainhoa, "<3"));
        ismael.send(new TextMessage(ainhoa, "<3"));
        ismael.send(new TextMessage(ainhoa, "<3"));
        ismael.send(new TextMessage(ainhoa, "<3"));
        ismael.send(new TextMessage(ainhoa, "<3"));
        ismael.send(new TextMessage(ainhoa, "<3"));
        ismael.send(new TextMessage(ainhoa, "<3"));

        Thread.sleep(1000);
        System.out.println(monitor.getTraffic());
        //System.out.println(monitor.getMessageLog("papote"));
        //System.out.println(monitor.getEventLog("papote"));
    }
}
