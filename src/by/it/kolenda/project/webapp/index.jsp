<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<!-- Основное содержимое -->
<div class="page-header">
    <h1>Все объявления</h1>
    <p class="lead">Пример макета для вывода данных в виде таблицы</p>
    <p>${user.email} ${user.login}</p>
</div>

<div class="row">
    <div class="col-md-1">Цена</div>
    <div class="col-md-3">Адрес</div>
    <div class="col-md-4">Описание</div>
    <div class="col-md-1">Число комнат</div>
    <div class="col-md-1">Площадь</div>
    <div class="col-md-1">Этаж</div>
    <div class="col-md-1">Этажность</div>

</div>

<c:forEach items="${ads}" var="ad">
    <div class="row">
        <div class="col-md-1">${ad.price} </div>
        <div class="col-md-3">${ad.address} </div>
        <div class="col-md-4">${ad.description} </div>
        <div class="col-md-1">${ad.roomCount} </div>
        <div class="col-md-1">${ad.area} </div>
        <div class="col-md-1">${ad.floor} </div>
        <div class="col-md-1">${ad.floors} </div>
    </div>
</c:forEach>



<%@ include file="include/end-html.jsp" %>