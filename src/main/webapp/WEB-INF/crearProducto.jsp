<%@ page import="java.util.List" %>
<%@ page import="model.Category" %><%--
  Created by IntelliJ IDEA.
  User: photo
  Date: 28/05/2025
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    List<Category> categories = (List<Category>) request.getAttribute("lista");
%>
<div class="container mt-5">
    <h2>Crear Producto</h2>
    <form action="crearProducto" method="post">

        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="mb-3">
            <label for="descripcion" class="form-label">Descripción</label>
            <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required></textarea>
        </div>
        <div class="mb-3">
            <label for="urlImagen" class="form-label">URL Imagen</label>
            <input  class="form-control" id="urlImagen" name="urlImagen" required>
        </div>
        <div class="mb-3">
            <label for="pujaInicio" class="form-label">Puja Inicial</label>
            <input type="number" class="form-control" id="pujaInicio" name="pujaInicio" min="0" required>
        </div>
        <div class="mb-3">
            <label for="categoria" class="form-label">Categoría</label>
            <select class="form-select" id="categoria" name="categoria" required>
                <%for (Category c : categories){%>
                <option value="<%=c.getCategory_id()%>"><%=c.getTitle()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Crear</button>
        <a href="listarProductos" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>

