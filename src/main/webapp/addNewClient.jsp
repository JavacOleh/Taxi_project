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
    <h1>Добавление Клиентов</h1>
        <form action="addNewClient" method="post">
    <div>
        <label for="new_client_name">Имя нового клиента:</label>
        <input type="text" id="new_client_name" name="new_client_name">
    </div>

    <div>
        <label for="new_client_number">Номер телефона нового клиента:</label>
        <input type="text" id="new_client_number" name="new_client_number">
    </div>
    <button type="submit">Добавить</button>

    </form>
         <form action="manageClient.jsp">
         <button type="submit">Назад</button>
    </form>

    </body>
</html>
