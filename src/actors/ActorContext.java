package actors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorContext {

    private static ActorContext actorContext = new ActorContext();
    private static Map<String,ActorProxy> actors = new HashMap<String,ActorProxy>();
    private static Map<String,ActorProxyAnswerMain> actors_c = new HashMap<String,ActorProxyAnswerMain>();

    private ActorContext() {}

    public Map<String, ActorProxy> getActors() {
        return actors;
    }

    public static ActorContext getInstance() {return actorContext;}

    public ActorProxy spawnActor(String name, Actor actor) {
        ActorProxy actorProxy = new ActorProxy(actor);
        actors.put(name, actorProxy);
        actor.iniciar(name);
        return actorProxy;
    }

    public ActorProxyAnswerMain spawnActor_c(String name, Actor actor) {
        ActorProxyAnswerMain actorProxy = new ActorProxyAnswerMain(actor);
        actors_c.put(name, actorProxy);
        actor.iniciar(name);
        return actorProxy;
    }

    public ActorProxy lookup(String name) {return actors.get(name);}
    public ActorProxyAnswerMain lookup_c(String name) {return actors_c.get(name);}

    public List<String> getNames() {return actors.keySet().stream().toList();}
}

