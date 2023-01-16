package decorators;

import actors.Actor;

import extra.EncryptedMessage;
import extra.Message;

public class EncryptionDecorator extends Actor {

    private Actor actor;
    private static int key = 2;

    public EncryptionDecorator(Actor actor) {
        this.actor=actor;
    }

    @Override
    public void processMessage(Message message) throws InterruptedException {
        actor.processMessage(decrypt((EncryptedMessage)message));

    }

    public void send(Message message) throws InterruptedException {
        super.send(encrypt(message));
    }


    private Message decrypt(EncryptedMessage message) {

        char[] decryptedMessage = message.getMessage().toCharArray();
        for (int i = 0; i < decryptedMessage.length; i++) {
            decryptedMessage[i] = (char) (decryptedMessage[i]/message.getKey());
        }

        return new Message(actor.getProxy(message), String.valueOf(decryptedMessage));

    }

    private Message encrypt(Message message) {
        char[] decryptedMessage = message.getMessage().toCharArray();
        for (int i = 0; i < decryptedMessage.length; i++) {
            decryptedMessage[i] = (char) (decryptedMessage[i]*key);
        }


        return new EncryptedMessage(message.getFromActor(), String.valueOf(decryptedMessage), key);

    }

}

