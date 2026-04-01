import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> rooms = new HashMap<>();

    public RoomInventory() {
        rooms.put("Single", 2);
        rooms.put("Double", 2);
        rooms.put("Suite", 1);
    }

    public boolean isValidRoomType(String roomType) {
        return rooms.containsKey(roomType);
    }

    public int getAvailableRooms(String roomType) {
        return rooms.getOrDefault(roomType, 0);
    }

    public void bookRoom(String roomType) throws InvalidBookingException {
        int available = getAvailableRooms(roomType);

        if (available <= 0) {
            throw new InvalidBookingException("Cannot book. No rooms available.");
        }

        rooms.put(roomType, available - 1);
    }
}