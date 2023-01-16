package extra;

import actors.ActorInt;



public class Message {

    protected ActorInt fromActor;
    protected String message;

    public Message(ActorInt fromActor, String message) {
        this.fromActor=fromActor;
        this.message=message;
    }

    public ActorInt getFromActor() {
        return fromActor;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message;
    }

}

