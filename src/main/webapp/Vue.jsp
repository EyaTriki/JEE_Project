<%@page import="dao.entities.Voiture"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car List</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<%@ include file="NavBar.html"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<br>
<form method="get" action="FirstServlet" class="mb-3">
    <div class="input-group">
        <input type="text" class="form-control" name="mc" placeholder="Rechercher">
        <div class="input-group-append">
            <button type="submit" name="action" value="rechercher" class="btn btn-primary">
                <i class="fa fa-search"></i>
            </button>
        </div>
    </div>
</form>

<br>

<p> Bonjour, ${username}!</p>
<div class="d-flex justify-content-end mb-3">
    <a href="userAuth?action=decon" class="btn btn-success">Déconnexion</a>
</div>

<div id="carTableContainer"></div>
<div class="d-flex justify-content-center">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" id="prevPage" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach begin="1" end="${totalPages}" var="pageNumber">
            <li class="page-item">
                <a class="page-link pagination-link" href="#" data-page="${pageNumber}">${pageNumber}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link" id="nextPage" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    var currentPage = 1; // Page actuelle
    var pageSize = 5; // Nombre d'éléments à afficher par page

    // Fonction pour charger les voitures de la page spécifiée
    function loadCars(page) {
        $.ajax({
            url: 'FirstServlet',
            type: 'GET',
            data: {
                action: 'getPage',
                page: page
            },
            success: function(response) {
                $('#carTableContainer').html(response);
                currentPage = page;
            },
            error: function(xhr, status, error) {
                console.log('Une erreur s\'est produite lors du chargement des voitures : ' + error);
            }
        });
    }

    // Charger les voitures de la première page au démarrage
    loadCars(currentPage);

    // Gérer les clics sur les liens de pagination
    $(document).on('click', '.pagination-link', function(event) {
        event.preventDefault();
        var page = $(this).data('page');
        loadCars(page);
    });

    // Gérer le clic sur le bouton "Précédent"
    $(document).on('click', '#prevPage', function(event) {
        event.preventDefault();
        if (currentPage > 1) {
            loadCars(currentPage - 1);
        }
    });

    // Gérer le clic sur le bouton "Suivant"
    $(document).on('click', '#nextPage', function(event) {
        event.preventDefault();
        loadCars(currentPage + 1);
    });
});
</script>

</body>

</html>