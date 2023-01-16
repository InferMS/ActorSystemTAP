package actors;

import extra.*;

public class PingPongActor extends Actor{

    @Override
    public void processMessage(Message message) throws InterruptedException {
        if (message instanceof PingPongMessage) {
            ((PingPongMessage)message).decreaseBounce();
            if (((PingPongMessage)message).getBounces()>=0) {
                message.getFromActor().send(message);
                System.out.println(((PingPongMessage)message).getBounces()%2==0 ? "ping":"pong");
            }
            else {
                System.out.println("fin");
            }
        }
        else {
            System.out.println("Tipo de mensaje no válido");
        }
    }

}