public class BookMyStayApp {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Simulating confirmed bookings (from Use Case 6)
        Reservation r1 = new Reservation("Single-1", "Abhi", "Single");
        Reservation r2 = new Reservation("Single-2", "Suba", "Single");
        Reservation r3 = new Reservation("Suite-1", "Vannathi", "Suite");

        // Store in history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Admin views history
        reportService.printAllBookings(history.getAllReservations());

        // Admin generates report
        reportService.generateSummary(history.getAllReservations());
    }
}