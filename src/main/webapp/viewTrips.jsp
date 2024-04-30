<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Заказы</title>
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
    <div>
        <form action="viewTrips" method="post">
            <input type="hidden" name="currentTripId" value="${currentTripId}" />
            <button type="submit" name="action" value="previous">Предыдущий</button>
            <button type="submit" name="action" value="next">Следующий</button>
            <button type="submit" name="action" value="remove">Удалить</button>
            <div>
                <p>Клиент: ${trip.client.name}</p>
                <form action="editTrip.jsp" method="get">
                    <input type="hidden" name="currentTripId" value="${currentTripId}">
                </form>
            </div>

            <div>
                <p>Водитель: ${trip.rider.name}</p>
                <form action="editTrip.jsp" method="get">
                    <input type="hidden" name="currentTripId" value="${currentTripId}">
                    <button type="submit" name="action" value="editRider">Изменить</button>
                </form>
            </div>

            <div>
                <p>Тип такси: ${trip.taxi.taxiType}</p>
                <form action="editTrip.jsp" method="get">
                    <input type="hidden" name="currentTripId" value="${currentTripId}">
                    <button type="submit" name="action" value="editTaxi">Изменить</button>
                </form>
            </div>

            <div>
                <p>Сумма за поездку: ${trip.sumForTrip}</p>
                <form action="editTrip.jsp" method="get">
                    <input type="hidden" name="currentTripId" value="${currentTripId}">
                    <button type="submit" name="action" value="editSum">Изменить</button>
                </form>
            </div>

            <div>
                <p>Километры на поездку: ${trip.kilometersForTrip}</p>
                <form action="editTrip.jsp" method="get">
                    <input type="hidden" name="currentTripId" value="${currentTripId}">
                    <button type="submit" name="action" value="editKilometers">Изменить</button>
                </form>
            </div>

            <div>
                <p>Комментарий: ${trip.comment}</p>
                <form action="editTrip.jsp" method="get">
                    <input type="hidden" name="currentTripId" value="${currentTripId}">
                    <button type="submit" name="action" value="editComment">Изменить</button>
                </form>
            </div>
        </form>
        <form action="index.jsp">
             <button type="submit">Назад</button>
        </form>
    </div>
</body>
</html>