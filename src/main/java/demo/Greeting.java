package demo;

/**
 * Created by robotic4 on 5/10/15.
 */
public class Greeting {

    private final long id;

    private final String content;

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
