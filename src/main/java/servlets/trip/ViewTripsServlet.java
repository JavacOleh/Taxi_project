package servlets.trip;

import hibernate.Trip;
import hibernate.dao.TripDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ViewTripsServlet", urlPatterns = {"/viewTrips"})
public class ViewTripsServlet extends HttpServlet {

    private final TripDAO tripDAO = new TripDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int currentTripId;

        try {
            currentTripId = Integer.parseInt(request.getParameter("currentTripId"));
        } catch (NumberFormatException e) {
            Trip firstTrip = tripDAO.getFirstTrip();
            if (firstTrip != null) {
                currentTripId = firstTrip.getTrip_id();
            } else {
                currentTripId = 0;
            }
        }
        Trip trip = tripDAO.getTripById(currentTripId);
        if ("next".equals(action)) {
            Integer nextTripId = tripDAO.getNextTripId(currentTripId);
            if (nextTripId != null) {
                currentTripId = nextTripId;
            }
            trip = tripDAO.getTripById(currentTripId);
            EditTripServlet.tripId = currentTripId;
        } else if ("previous".equals(action)) {
            Integer previousTripId = tripDAO.getPreviousTripId(currentTripId);
            if (previousTripId != null) {
                currentTripId = previousTripId;
            }
            trip = tripDAO.getTripById(currentTripId);
            EditTripServlet.tripId = currentTripId;
        }

        if ("remove".equals(action)) {
            if(trip != null) tripDAO.deleteTrip(trip);
        }

        request.setAttribute("currentTripId", currentTripId);
        request.setAttribute("trip", trip);
        request.getRequestDispatcher("/viewTrips.jsp").forward(request, response);
    }



}