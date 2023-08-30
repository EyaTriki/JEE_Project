<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.entities.Voiture"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            background-color: #f8f9fa;
        }

        .card {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .form-control-file {
            display: inline-block;
            width: auto;
        }
    </style>
</head>
<body>
    <%@ include file="NavBar.html"%>

    <br>
    <div class="container-fluid">
        <div class="card mx-5">
            <div class="card-header">
                <h5 class="mb-0">Ajouter Voiture</h5>
            </div>
            <div class="card-body">
                <form method="post" action="FirstServlet" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="modele">Modèle</label>
                        <input type="text" class="form-control" id="modele" name="modele" value="${voiture.modele}">
                    </div>
                    <div class="form-group">
                        <label for="carburant">Carburant</label>
                        <input type="text" class="form-control" id="carburant" name="carburant" value="${voiture.carburant}">
                    </div>
                    <div class="form-group">
                        <label for="prix">Prix (dt)</label>
                        <input type="number" class="form-control" id="prix" name="prix" value="${voiture.prix}">
                    </div>
                    <div class="form-group">
                        <label for="marque">Marque</label>
                        <select name="marque" class="form-control">
                            <option selected hidden>Choose here</option>
                            <c:forEach items="${marque}" var="cc">
                                <option value="${cc.id}" <c:if test="${voiture.marque.id==cc.id }">selected="true"</c:if>>${cc.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="filename">Image</label>
                        <input type="file" name="image" id="filename" class="form-control-file">
                    </div>
                <button type="submit" name="action" value="ajouterform" class="btn btn-primary">
                    <span class="fa fa-save"></span>
                    <c:if test="${voiture.id==null}">
                        Ajouter
   </c:if>
    <c:if test="${voiture.id!=null}">
    Modifier
   </c:if>
   </button>

  <input type="hidden" name="id" value="${voiture.id}"/>
</form>
    <br>
    </div>
    </div>
  </div>
</div>
</body>
</html>