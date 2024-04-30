package servlets.client;

import hibernate.Client;
import hibernate.dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "DeleteClientServlet", urlPatterns = {"/deleteClient"})
public class DeleteClientServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientId = request.getParameter("clientId");
        
        if (clientId != null && !clientId.isEmpty()) {
            int clientIdInt = Integer.parseInt(clientId);

            ClientDAO clientDAO = new ClientDAO();

            Client client = clientDAO.getClientById(clientIdInt);
            
            if (client != null)
                clientDAO.deleteClient(client);
        }
        response.sendRedirect("manageClient.jsp");
    }
}
