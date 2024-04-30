<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="hibernate.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="hibernate.dao.ClientDAO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Управление Клиентами</title>
    <!-- Стили и скрипты -->
    <style>
        body { font-family: Arial, sans-serif; }
        ul { list-style-type: none; }
        li { display: inline; margin-right: 10px; }
        form { margin-top: 15px; }
        label { display: block; margin-top: 10px; }
        input, select { margin-top: 5px; }
        button { margin-top: 10px; }
    </style>
</head>
    <body>
    <h1>Удаление Клиентов</h1>
        <form action="deleteClient" method="post">
            <label for="selectClient">Выберите клиента для удаления:</label>
            <select name="clientId" id="selectClient">
                <option value="">-- Выберите клиента --</option>
                <% List<Client> clients = (List<Client>) new ClientDAO().getClientList();
                   for (Client client : clients) { %>
                    <option value="<%= client.getClient_id() %>"><%= client.getName() %> - <%= client.getNumber() %></option>
                <% } %>
            </select>
            <button type="submit">Удалить</button>
        </form>

    </form>
         <form action="manageClient.jsp">
         <button type="submit">Назад</button>
    </form>

    </body>
</html>
