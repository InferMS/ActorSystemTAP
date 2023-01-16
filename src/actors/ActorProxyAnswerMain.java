package actors;

import java.util.LinkedList;
import java.util.Queue;

import extra.Message;

public class ActorProxyAnswerMain extends ActorProxy{
    private Queue<Message> actorSendback;

    public ActorProxyAnswerMain(Actor actor) {
        super(actor);
        actorSendback = new LinkedList<>();
    }
    public void send(Message message) throws InterruptedException {
        actorSendback.add(message);
    }
    public Message receive() {
        return actorSendback.poll();
    }
}

