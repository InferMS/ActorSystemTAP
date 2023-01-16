package observer;

import java.util.EventObject;

import actors.Actor;
import extra.Message;

public class ActorEvent extends EventObject {

    private String eventType;
    private Message message;

    public ActorEvent(Actor source, String eventType, Message message) {
        super(source);
        this.eventType = eventType;
        this.message = message;
    }

    public String getEventType() {
        return eventType;
    }

    public Message getContent() {
        return message;
    }

    @Override
    public String toString() {
        return "Evento de tipo: \"" + eventType +"\" recibido en el actor: " + source;
    }
}
