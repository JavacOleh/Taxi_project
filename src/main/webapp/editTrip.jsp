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
        <title>Редактировать поездку</title>
        <!-- Стили и скрипты -->
        <style>
            body { font-family: Arial, sans-serif; }
        </style>
    </head>
    <body>
        <h2>Редактировать поездку</h2>

        <form action="EditTripServlet" method="post">
            <input type="hidden" name="action" value="<%= request.getParameter("action") %>">

            <%-- В зависимости от значения параметра "action" отображаем соответствующее поле для редактирования --%>
            <% if ("editRider".equals(request.getParameter("action"))) { %>
                <label for="riderName">Выберите водителя:</label>
                <select name="Rider_id" id="rider">
                    <option value="">-- Выберите водителя --</option>
                    <% List<Rider> riders = (List<Rider>) new RiderDAO().getRiderList();
                    for (Rider rider : riders) { %>
                        <option value="<%= rider.getRider_id() %>"><%= rider.toGetInfo() %></option>
                    <% } %>
                </select>

            <% } else if ("editTaxi".equals(request.getParameter("action"))) { %>
                <label for="Taxi_Id">Выберите тип такси:</label>
                <select name="Taxi_Id" id="taxi">
                    <option value="">-- Выберите тип такси --</option>
                    <% List<Taxi> taxis = (List<Taxi>) new TaxiDAO().getTaxiList();
                    for (Taxi taxi : taxis) { %>
                    <option value="<%= taxi.getTaxi_Id() %>"><%= taxi.toGetInfo() %></option>
                    <% } %>
                </select>

            <% } else if ("editSum".equals(request.getParameter("action"))) { %>
                <label for="sumForTrip">Сумма за поездку:</label>
                <input type="text" id="sumForTrip" name="sumForTrip" value="${trip.sumForTrip}">
            <% } else if ("editKilometers".equals(request.getParameter("action"))) { %>
                <label for="kilometersForTrip">Километры на поездку:</label>
                <input type="text" id="kilometersForTrip" name="kilometersForTrip" value="${trip.kilometersForTrip}">
            <% } else if ("editComment".equals(request.getParameter("action"))) { %>
                <label for="comment">Комментарий:</label>
                <textarea id="comment" name="comment" rows="6" cols="80"></textarea>
            <% } %>

            <button type="submit">Сохранить</button>
            <button type="button" onclick="window.history.back();">Отмена</button>
        </form>
    </body>
    </html>