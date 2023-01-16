package actors;


import extra.Message;

public class HelloWorldActor extends Actor {

    @Override
    public void processMessage(Message message) {
        System.out.println(message);
    }

}
