<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="hibernate.Client" %>
<%@ page import="hibernate.Rider" %>
<%@ page import="hibernate.Taxi" %>
<%@ page import="java.util.List" %>
<%@ page import="hibernate.dao.ClientDAO" %>
<%@ page import="hibernate.dao.RiderDAO" %>
<%@ page import="hibernate.dao.TaxiDAO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Добавить заказ</title>
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
    <h2>Добавить новый заказ</h2>
    <form action="addTrip" method="post">
    <div>
                        <h3>Выберите тип такси</h3>
                        <select name="Taxi_Id" id="taxi">
                            <option value="">-- Выберите тип такси --</option>
                            <% List<Taxi> taxi_list = (List<Taxi>) new TaxiDAO().getTaxiList();
                               for (Taxi taxi : taxi_list) { %>
                                <option value="<%= taxi.getTaxi_Id() %>"><%= taxi.getTaxiType() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div>
                        <h3>Выберите водителя</h3>
                        <select name="Rider_id" id="rider">
                            <option value="">-- Выберите водителя --</option>
                            <% List<Rider> riders = (List<Rider>) new RiderDAO().getRiderList();
                               for (Rider rider : riders) { %>
                                <option value="<%= rider.getRider_id() %>"><%= rider.toGetInfo() %></option>
                            <% } %>
                        </select>
                </div>
                <div>
                    <h3>Выберите клиента</h3>
                    <label for="existing_client">Существующий клиент:</label>
                    <select name="Client_id" id="existing_client">
                        <option value="">-- Выберите клиента --</option>
                        <% List<Client> clients = (List<Client>) new ClientDAO().getClientList();
                           for (Client client : clients) { %>
                            <option value="<%= client.getClient_id() %>"><%= client.toGetInfo() %></option>
                        <% } %>
                    </select>
                </div>
                <div>
                        <label for="SumForTrip">Цена за поездку:</label>
                        <input type="text" id="SumForTrip" name="SumForTrip">
                    </div>

                    <div>
                        <label for="KilometersForTrip">Километров на поездку:</label>
                        <input type="text" id="KilometersForTrip" name="KilometersForTrip">
                    </div>

                    <div>
                         <label for="Comment">Комментарий к заказу:</label>
                         <textarea id="Comment" name="Comment" rows="6" cols="80"></textarea>
                    </div>
        <button type="submit">Добавить заказ</button>

    </form>

    <form action="manageClient.jsp">
        <button type="submit">Управление Клиентами</button>
    </form>
    <form action="index.jsp">
            <button type="submit">Назад</button>
    </form>

</body>
</html>

