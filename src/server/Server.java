package server;
import java.io.IOException;

import org.apache.xmlrpc.WebServer;

import controllers.*;

public class Server implements Runnable{

    @Override
    public void run() {

        WebServer server;
        try {
            server = new WebServer(58000);
            server.addHandler("Monitor", new MonitorController());
            server.addHandler("Actor", new ActorController());
            server.addHandler("Message", new MessageController());
            server.addHandler("Decorator", new DecoratorController());
            server.addHandler("Context", new ContextController());


            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
