import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<String> queue = new LinkedList<>();

    public void addRequest(String request) {
        queue.add(request);
    }

    public String processRequest() {
        return queue.poll();
    }
}