package servlets.client;

import hibernate.Client;
import hibernate.dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "AddNewClientServlet", urlPatterns = {"/addNewClient"})
public class AddNewClientServlet extends HttpServlet {
    ClientDAO clientDAO = new ClientDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newClientName = req.getParameter("new_client_name");
        String newClientNumber = req.getParameter("new_client_number");
        String clientId = req.getParameter("clientId");


        try {
            if (IsNewClientNotNULL(newClientName, newClientNumber)) {

                if(isClientNotExist(newClientName, newClientNumber))
                    clientDAO.saveClient(new Client(newClientName, newClientNumber));

            }else
                throw new Exception("Не указан клиент для заказа.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (clientId != null && !clientId.isEmpty()) {
            int clientIdInt = Integer.parseInt(clientId);

            ClientDAO clientDAO = new ClientDAO();

            Client client = clientDAO.getClientById(clientIdInt);

            if (client != null)
                clientDAO.deleteClient(client);

        }

        resp.sendRedirect("manageClient.jsp");
    }

    private static boolean IsNewClientNotNULL(String newClientName, String newClientNumber) {
        return newClientName != null && !newClientName.trim().isEmpty() && newClientNumber != null && !newClientNumber.trim().isEmpty();
    }
    private static boolean isClientNotExist(String existingClientName, String existingClientNumber) {
        Client check1 = new ClientDAO().getClientByName(existingClientName);
        Client check2 = new ClientDAO().getClientByNumber(existingClientNumber);
        return check1 == null && check2 == null;
    }

}
