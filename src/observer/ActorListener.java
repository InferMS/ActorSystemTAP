package observer;
import java.util.EventListener;

public interface ActorListener extends EventListener {

    public void dataChanged(ActorEvent event);

    public Object getState();
}

