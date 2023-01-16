package decorators;

import actors.Actor;
import extra.Message;

public class FirewallDecorator extends Actor {

    private Actor actor;

    public FirewallDecorator(Actor actor) {
        this.actor = actor;
    }


    @Override
    public void processMessage(Message message) throws InterruptedException {
        if (!(actor.getProxy(message).equals(null))) {
            actor.processMessage(message);
        }

    }

}

