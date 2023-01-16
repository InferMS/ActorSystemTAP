package actors;

import observer.ActorListener;

import extra.Message;

public class ActorProxy implements ActorInt{
    protected Actor actor;

    public ActorProxy(Actor actor) {
        this.actor = actor;

    }

    public void send(Message message) throws InterruptedException {actor.send(message);}

    public void addObserver(ActorListener trafficObserver) {actor.addObserver(trafficObserver);}

    public String toString() {
        return actor.getName();
    }
}
