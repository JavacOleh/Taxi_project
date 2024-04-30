package servlets.trip;

import hibernate.Client;
import hibernate.Trip;
import hibernate.dao.ClientDAO;
import hibernate.dao.TaxiDAO;
import hibernate.dao.RiderDAO;
import hibernate.dao.TripDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.math.BigDecimal;
@WebServlet(name = "AddTripServlet", urlPatterns = {"/addTrip"})
public class AddTripServlet extends HttpServlet {
    ClientDAO clientDAO = new ClientDAO();
    RiderDAO riderDAO = new RiderDAO();
    TaxiDAO taxiDAO = new TaxiDAO();
    TripDAO tripDAO = new TripDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String existingClientId = request.getParameter("Client_id");
        String Comment = request.getParameter("Comment");
        int riderId = Integer.parseInt(request.getParameter("Rider_id"));
        int taxiId = Integer.parseInt(request.getParameter("Taxi_Id"));
        BigDecimal sumForTrip = new BigDecimal(request.getParameter("SumForTrip"));
        BigDecimal kilometersForTrip = new BigDecimal(request.getParameter("KilometersForTrip"));

        try {
            Client client;

            client = clientDAO.getClientById(Integer.parseInt(existingClientId));

            tripDAO.saveTrip(
                    new Trip(
                            client,
                            riderDAO.getRiderById(riderId),
                            taxiDAO.getTaxiById(taxiId),
                            sumForTrip,
                            kilometersForTrip,
                            Comment
                    ));

            response.sendRedirect("addTrip.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
