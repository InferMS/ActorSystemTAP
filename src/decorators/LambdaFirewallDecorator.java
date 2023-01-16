package decorators;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import actors.Actor;
import extra.Message;
import extra.AddClosureMessage;

public class LambdaFirewallDecorator extends Actor {

    private Actor actor;
    private List<Predicate<String>> predList = new LinkedList<>();

    public LambdaFirewallDecorator(Actor actor) {
        this.actor = actor;
    }

    @Override
    public void processMessage(Message message) throws InterruptedException {
        if (message instanceof AddClosureMessage) {
            predList.add(((AddClosureMessage)message).getPredicate());
        }
        else {
            if (filter(message)) {
                actor.processMessage(message);
            }
        }
    }

    private boolean filter(Message message) {
        for (Predicate<String> predicate : predList) {
            if (!predicate.test(message.getMessage())) {
                return false;
            }
        }
        return true;
    }
}

