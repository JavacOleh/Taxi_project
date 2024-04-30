package servlets.trip;

import hibernate.Trip;
import hibernate.dao.RiderDAO;
import hibernate.dao.TaxiDAO;
import hibernate.dao.TripDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "EditTripServlet", urlPatterns = {"/EditTripServlet"})
public class EditTripServlet extends HttpServlet {
    TripDAO tripDAO = new TripDAO();
    RiderDAO riderDAO = new RiderDAO();
    TaxiDAO taxiDAO = new TaxiDAO();
    public static int tripId;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        Trip trip = tripDAO.getTripById(tripId);

        if(trip != null) {
            if ("editRider".equals(action)) {
                String Rider_id = request.getParameter("Rider_id");
                trip.setRider(riderDAO.getRiderById(Integer.parseInt(Rider_id)));
            } else if ("editTaxi".equals(action)) {
                String Taxi_id = request.getParameter("Taxi_Id");
                trip.setTaxi(taxiDAO.getTaxiById(Integer.parseInt(Taxi_id)));
            } else if ("editSum".equals(action)) {
                String sumForTripParameter = request.getParameter("sumForTrip");
                if (sumForTripParameter != null && !sumForTripParameter.equals("null")) {
                    double sumForTrip = Double.parseDouble(sumForTripParameter);
                    trip.setSumForTrip(new BigDecimal(sumForTrip));
                }
            } else if ("editKilometers".equals(action)) {
                String kilometersForTripParameter = request.getParameter("kilometersForTrip");
                if (kilometersForTripParameter != null && !kilometersForTripParameter.equals("null")) {
                    double kilometersForTrip = Double.parseDouble(kilometersForTripParameter);
                    trip.setKilometersForTrip(new BigDecimal(kilometersForTrip));
                }
            } else if ("editComment".equals(action)) {
                String comment = request.getParameter("comment");
                trip.setComment(comment);
            }


            tripDAO.updateTrip(trip);
        }
        response.sendRedirect("viewTrips.jsp");
    }
}
