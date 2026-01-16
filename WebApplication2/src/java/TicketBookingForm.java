import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/TicketBookingForm")  // এই লাইনটা দিয়েই servlet mapping হইতেছে
public class TicketBookingForm extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String event = request.getParameter("event");
        String tickets = request.getParameter("tickets");
        String time = request.getParameter("time");

        out.println("<html><body>");
        out.println("<h2>Booking Confirmation</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Event: " + event + "</p>");
        out.println("<p>Number of Tickets: " + tickets + "</p>");
        out.println("<p>Time Slot: " + time + "</p>");
        out.println("<p><b>Your ticket has been successfully booked!</b></p>");
        out.println("</body></html>");
    }
}
