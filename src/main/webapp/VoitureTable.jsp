<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-striped">
    <thead>
    <tr>
<!--         <th>ID</th> -->
        <th>Image</th>
        <th>Modèle</th>
        <th>Carburant</th>
        <th>Prix (dt)</th>
        <th>Marque</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${liste}" var="v">
        <tr>
<%--             <td>${v.id}</td> --%>
             <td><img src="<c:url value='images/${v.filename}'/>" width="180"
					height="100" /></td>
            <td>${v.modele}</td>
            <td>${v.carburant}</td>
            <td>${v.prix}</td>
            <td>${v.marque.nom}</td>
            <td>
                <a href="FirstServlet?action=supprimer&id=${v.id}" class="btn btn-danger"
                   onclick="return confirm('Voulez-vous supprimer cette voiture ?')">
                    <i class="fa fa-trash"></i>
                </a>
                <a href="FirstServlet?action=modifier&id=${v.id}" class="btn btn-warning">
                    <i class="fa fa-edit"></i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
