package extra;

import actors.ActorInt;

public class QuitMessage extends Message{

    public QuitMessage(ActorInt fromActor, String message) {
        super(fromActor, message);
    }

}
