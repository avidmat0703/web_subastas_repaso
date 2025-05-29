<%@ page import="model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: photo
  Date: 28/05/2025
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>title</title>
</head>
<body>
<%
    List<Product> list = (List<Product>) request.getAttribute("lista");



%>
<div class="mb-4">
    <h4>Resumen de productos por categoría</h4>
    <table class="table table-bordered w-auto">
        <thead class="table-light">
        <tr>
            <th>Categoría</th>
            <th>Cantidad de productos</th>
        </tr>
        </thead>
        <tbody>
        <!-- Aquí irán las filas de resumen de categorías -->
        <tr>
            <td>Ejemplo Categoría</td>
            <td>0</td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container mt-4">
    <h2 class="mb-4">Lista de Subastas</h2>
    <a href="crearProducto">crear</a>
    <table class="table table-bordered table-striped">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Puja Inicial</th>
            <th>Puja Actual</th>
            <th>Categoría</th>
            <th>Fecha Fin Subasta</th>
            <th>Usuario Subasta</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <!-- Aquí irán las filas de productos -->
        <%
            for (Product p : list){
        %>
        <tr>
            <td><%=p.getProduct_id()%></td>
            <td><%=p.getTitle()%></td>
            <td><%=p.getStarting_bid()%></td>
            <td><%=p.getCurrent_bid()%></td>
            <td><%=p.getCategory_id().getCategory_id()%></td>
            <td><%=p.getAuction_id().getEnd_date() != null ? p.getAuction_id().getEnd_date() : ""%></td>
            <td><%=p.getAuction_id().getUser().getUsername() != null ? p.getAuction_id().getUser().getUsername() : ""%></td>
            <td>
                <%
                    if(p.getAuction_id().getAuction_id() != null){

                    %>
                    <a href="editarSubasta?id=<%=p.getAuction_id().getAuction_id()%>">Editar</a>
                    <%}
                %>

                <a href="#" class="btn btn-sm btn-danger">Eliminar</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
