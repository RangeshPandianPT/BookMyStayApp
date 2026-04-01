public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();

        // Create multiple worker threads
        for (int i = 1; i <= 3; i++) {
            new BookingProcessor(queue, inventory).start();
        }

        // Simulate multiple users booking simultaneously
        queue.addRequest(new BookingRequest("Alice", "Single"));
        queue.addRequest(new BookingRequest("Bob", "Single"));
        queue.addRequest(new BookingRequest("Charlie", "Single")); // should fail
        queue.addRequest(new BookingRequest("David", "Double"));
        queue.addRequest(new BookingRequest("Eve", "Double"));
        queue.addRequest(new BookingRequest("Frank", "Double")); // should fail
    }
}