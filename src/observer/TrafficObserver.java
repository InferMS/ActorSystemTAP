package observer;

import java.util.ArrayList;
import java.util.List;

import actors.Actor;
import extra.*;


public class TrafficObserver implements ActorListener {

    private int traffic;
    private List<Message> messageLog = new ArrayList<>();
    private List<ActorEvent> eventLog = new ArrayList<>();
    private boolean messageLogB = false;
    private boolean eventLogB = false;

    @Override
    public void dataChanged(ActorEvent event) {
        traffic = ((Actor) event.getSource()).getTraffic();
        if (messageLogB) {
            messageLog.add(event.getContent());
        }
        if (eventLogB) {
            eventLog.add(event);
        }
    }

    public void startEventLog() {
        eventLogB = true;
    }

    public void stopEventLog() {
        eventLogB = false;
    }

    public void startMessageLog() {
        messageLogB = true;
    }

    public void stopMessageLog() {
        messageLogB = false;
    }

    public List<Message> getMessageLog() {
        return messageLog;
    }


    public List<ActorEvent> getEventLog() {
        return eventLog;
    }

    public Object getState() {
        return traffic;
    }
}