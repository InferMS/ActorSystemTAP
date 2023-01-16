package extra;

import java.util.function.Predicate;

import actors.ActorInt;

public class AddClosureMessage extends Message {

    private Predicate<String> predicate;

    public AddClosureMessage(ActorInt fromActor, String message, Predicate<String> predicate) {
        super(fromActor, message);
        this.predicate = predicate;
    }

    public Predicate<String> getPredicate() {
        return predicate;
    }

}

