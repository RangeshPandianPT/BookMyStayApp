public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation\n");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Simulate an existing booking
        String reservationId = "Single-1";
        String roomType = "Single";

        cancellationService.registerBooking(reservationId, roomType);

        // Cancel booking
        cancellationService.cancelBooking(reservationId, inventory);

        // Show rollback history
        cancellationService.showRollbackHistory();

        // Show updated inventory
        inventory.displayAvailability(roomType);
    }
}