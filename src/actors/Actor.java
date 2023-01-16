package actors;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import observer.ActorEvent;
import observer.ActorListener;
import extra.Message;
import extra.QuitMessage;

public abstract class Actor implements Runnable, ActorInt {
    protected String name;
    protected BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private ActorListener observer;
    private int traffic = 0;


    /**
     * Inicialization of the Actor Thread
     * @param name String that contains the name of the Actor
     */
    public void iniciar(String name) {

        Thread thread = new Thread(this);
        thread.start();
        this.name = name;
    }

    /**
     * Main execution of the actor. It blocks itself until a message is recieved.
     * When it is recieved, the message gets processed differently depending on the implementation of the concrete Actor.
     */
    @Override
    public void run() {
        try {
            Message message;
            while (true) {
                message = queue.take();
                traffic++;
                if (observer!=null) {
                    observer.dataChanged(new ActorEvent(this, "message", message));
                }
                if (message instanceof QuitMessage) {
                    if (observer!=null) {
                        observer.dataChanged(new ActorEvent(this, "finalization", message));
                    }
                    Thread.currentThread().interrupt();
                }
                processMessage(message);
            }
        } catch (InterruptedException e) {
            //observer.dataChanged(new ActorEvent(this, "incorrect finalization", null));
            //Thread.currentThread().interrupt();
            System.out.println("lol");
        }
    }

    /**
     * Inserts the message inside the Actor's queue.
     * @param message Message to be inputed inside the Actor's queue.
     */
    public void send(Message message) throws InterruptedException{queue.put(message);}

    /**
     * Inserts the message inside the Actor's queue.
     * @param message Message to be inputed inside the Actor's queue.
     */
    public ActorProxy getProxy(Message message) {return (message.getFromActor() instanceof ActorProxyAnswerMain ? ActorContext.getInstance().lookup_c(name):ActorContext.getInstance().lookup(name));}

    /**
     * Abstract method to process messages
     * @param message Message to be inputed inside the Actor's queue.
     */
    public abstract void processMessage(Message message) throws InterruptedException;

    /**
     * Inserts the message inside the Actor's queue.
     * @param message Message to be inputed inside the Actor's queue.
     */
    public void addObserver(ActorListener observer) {this.observer = observer;}

    /**
     * Inserts the message inside the Actor's queue.
     * @param message Message to be inputed inside the Actor's queue.
     */
    public String getName() {return name;}

    public void removeMonitor() {observer = null;}

    public int getTraffic() {return traffic;}

    public String toString() {
        return name;
    }


}

