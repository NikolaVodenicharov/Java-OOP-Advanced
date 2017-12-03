import java.util.Iterator;
import java.util.List;

public class Logger {
    private Importance minimumLevel;
    private List<Message> messages;

    public Logger(String minimumLevel, List<Message> messages) {
        this.minimumLevel = Enum.valueOf(Importance.class, minimumLevel.toUpperCase());
        this.messages = messages;
    }

    public void addMessage(Message message){
        if (message.getLevel().ordinal() >= this.minimumLevel.ordinal()){
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
