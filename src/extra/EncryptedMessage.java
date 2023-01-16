package extra;

import actors.ActorInt;

public class EncryptedMessage extends Message {

    int key;

    public int getKey(){
        return key;
    }

    public EncryptedMessage(ActorInt fromActor, String message, int key) {
        super(fromActor, message);
        this.key = key;
    }

    @Override
    public String toString() {
        return "Missatge encriptat: " + super.message+ " amb clau d'encriptacio: " + key + " per part de l'actor: " + super.fromActor;
    }

}