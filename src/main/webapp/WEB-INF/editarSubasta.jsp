<%@ page import="model.Auction" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: photo
  Date: 29/05/2025
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Formulario con Tabla Bootstrap</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .table-form {
      max-width: 600px;
      margin: 30px auto;
    }
    .table-form td {
      vertical-align: middle;
    }
    .table-form .label {
      text-align: end;
      font-weight: 500;
      width: 40%;
    }
    .table-form .input {
      width: 60%;
    }
  </style>
</head>
<body>
<%
  Optional<Auction> auction = (Optional<Auction>) request.getAttribute("a");
  List<User> list = (List<User>) request.getAttribute("lista");
%>
<form action="editarSubasta" method="post">
  <table class="table table-bordered table-form">
    <tr>
      <td class="label">Nombre:</td>
      <td class="input">
        <input  id="nombre" type="text" name="nombre" class="form-control" required>
      </td>
    </tr>
    <tr>
      <td class="label">Usuario:</td>
      <td class="input">
        <select name="usuario" id="usuario" class="form-select" required>
          <%
            for (User u : list){
          %>
          <option  value="<%=u.getUser_id()%>"><%=u.getUsername()%></option>
          <%}%>
        </select>
      </td>
    </tr>
    <tr>
      <td class="label">Estado:</td>
      <td id="estado" class="input">
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="estado" id="inactivo" value="inactivo" required>
          <label class="form-check-label" for="inactivo">Inactivo</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="estado" id="pendiente" value="pendiente">
          <label class="form-check-label" for="pendiente">Pendiente</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="estado" id="activo" value="activo">
          <label class="form-check-label" for="activo">Activo</label>
        </div>
      </td>
    </tr>
    <tr>
      <td class="label">Descripción:</td>
      <td class="input">
        <textarea id="descripcion" name="descripcion" rows="3" class="form-control"></textarea>
      </td>
    </tr>
    <tr>
      <td class="label">Fecha Inicio:</td>
      <td class="input">
        <input type="date" name="fecha_inicio" class="form-control" value="<%=auction.get().getStart_date() != null ? auction.get().getStart_date() : " "%>" id="fecha_inicio" required >
      </td>
    </tr>
    <tr>
      <td class="label">Fecha Fin:</td>
      <td class="input">
        <input type="date" name="fecha_fin"  class="form-control" value="<%=auction.get().getEnd_date() != null ? auction.get().getEnd_date() : " "%>" id="fecha_fin">
      </td>
    </tr>
    <tr>
      <td></td>
      <td class="input">
        <button type="submit" class="btn btn-primary">Enviar</button>
      </td>
    </tr>
  </table>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
