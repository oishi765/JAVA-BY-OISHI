
package ticketbookingsystem;
class TicketBooking {
    int seats = 3;

    void bookTicket(String user, int wantSeats) {
        synchronized(this) {
            if (seats >= wantSeats) {
                System.out.println(user + " booked " + wantSeats + " seat(s).");
                seats -= wantSeats;
            } else {
                System.out.println(user + " failed to book. Not enough seats.");
            }
        }
    }
}

class UserThread extends Thread {
    TicketBooking booking;
    String user;
    int seats;

    UserThread(TicketBooking booking, String user, int seats) {
        this.booking = booking;
        this.user = user;
        this.seats = seats;
    }

    public void run() {
        booking.bookTicket(user, seats);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        UserThread u1 = new UserThread(booking, "Evana", 2);
        UserThread u2 = new UserThread(booking, "Oishi", 1);
        UserThread u3 = new UserThread(booking, "Tania", 1);

        u1.start();
        u2.start();
        u3.start();
    }
}
