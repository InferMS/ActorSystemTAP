package observer;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import actors.ActorContext;
import actors.ActorProxy;
import extra.Message;

public class MonitorService {
    private Map<ActorProxy, TrafficObserver> actorListeners = new HashMap<>();


    public void monitorActor(String name) {
        TrafficObserver trafficObserver = new TrafficObserver();
        ActorProxy actor = ActorContext.getInstance().lookup(name);
        actorListeners.put(actor, trafficObserver);
        actor.addObserver(trafficObserver);
    }

    public void monitorAllActors() {for (String actorName : ActorContext.getInstance().getNames()) {monitorActor(actorName);}}

    public Map<String, List<String>> getTraffic(){


        Map<String , List<String>> trafficMap = new HashMap<>();
        List<String> lowActors = new LinkedList<>();
        List<String> medActors = new LinkedList<>();
        List<String> highActors = new LinkedList<>();

        for (Map.Entry<ActorProxy, TrafficObserver> entry : actorListeners.entrySet()) {
            ActorProxy key = entry.getKey();
            ActorListener trafficObserver = entry.getValue();
            int traffic = (int) trafficObserver.getState();
            System.out.println("Actor: "+key+ " tiene trafico: "+ traffic);

            if (traffic < 5) {
                lowActors.add(key.toString());
            }else if(traffic < 15) {
                medActors.add(key.toString());
            }else {
                highActors.add(key.toString());
            }
        }

        trafficMap.put("LOW", lowActors);
        trafficMap.put("MEDIUM", medActors);
        trafficMap.put("HIGH", highActors);

        return trafficMap;
    }

    public int getNumberofMessages(String name) {return (int) actorListeners.get(ActorContext.getInstance().lookup(name)).getState();}

    public List<Message> getMessageLog(String name){ return actorListeners.get(ActorContext.getInstance().lookup(name)).getMessageLog();}

    public List<ActorEvent> getEventLog(String name){ return actorListeners.get(ActorContext.getInstance().lookup(name)).getEventLog();}

    public void startMessageLog(String name) {actorListeners.get(ActorContext.getInstance().lookup(name)).startMessageLog();}

    public void startEventLog(String name) {actorListeners.get(ActorContext.getInstance().lookup(name)).startEventLog();}
}
