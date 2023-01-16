package extra;


import actors.ActorInt;

public class TextMessage extends Message{


    public TextMessage(ActorInt fromActor, String message) {
        super(fromActor, message);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Missatge: " + super.message + " per part de l'actor: " + super.fromActor;
    }

}
