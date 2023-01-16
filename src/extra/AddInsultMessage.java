package extra;

import actors.ActorInt;

public class AddInsultMessage extends Message{

    public AddInsultMessage(ActorInt fromActor, String message) {
        super(fromActor, message);
    }

}
