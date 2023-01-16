package actors;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import extra.AddInsultMessage;
import extra.GetAllInsultsMessage;
import extra.GetInsultMessage;
import extra.Message;

public class InsultActor extends Actor {
    private List<String> insultList = new LinkedList<String>();
    public void processMessage(Message message) throws InterruptedException {
        if (message instanceof AddInsultMessage) {
            insultList.add(message.getMessage());
        }
        else if(message instanceof GetInsultMessage) {
            Random rand = new Random();
            try {
                message.getFromActor().send(new Message(getProxy(message), insultList.get(rand.nextInt(insultList.size()))));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        else if(message instanceof GetAllInsultsMessage) {
            message.getFromActor().send(new Message(getProxy(message), insultList.toString()));
        }
        else{
            System.out.println("Mensaje no compatible con InsultActor");
        }
    }

}
