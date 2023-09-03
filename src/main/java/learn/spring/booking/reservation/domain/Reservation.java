package learn.spring.booking.reservation.domain;

public class Reservation {

    private String reservationId;
    private String guestId;

    public Reservation(String reservationId, String guestId) {
        this.reservationId = reservationId;
        this.guestId = guestId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestId() {
        return guestId;
    }
}
