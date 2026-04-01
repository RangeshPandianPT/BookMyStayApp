import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private Map<String, Integer> rooms = new HashMap<>();

    public RoomInventory() {
        rooms.put("Single", 2);
        rooms.put("Double", 2);
        rooms.put("Suite", 1);
    }

    // Critical section
    public synchronized boolean bookRoom(String roomType) {

        int available = rooms.getOrDefault(roomType, 0);

        if (available > 0) {
            // Simulate delay (to expose race conditions if unsynchronized)
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            rooms.put(roomType, available - 1);
            return true;
        }
        return false;
    }

    public synchronized int getAvailableRooms(String roomType) {
        return rooms.getOrDefault(roomType, 0);
    }
}