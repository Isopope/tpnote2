<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Liste des Livres</title>
        <link rel="stylesheet" href="style.css">
    </head>
<body>
    <h1>Liste des films</h1>
    <fieldset>
        <legend>Liste des films</legend>

        <table border="1">
            <tr>
                <th>Titre</th>
                <th>Annee</th>
                <th>Acteurs</th>
                <th>Affiche</th>
                <th>Baisser</th>
                <th>Note</th>
                <th>Augmenter</th>
            </tr>
            <c:forEach var="movie" items="${MOVIES}">
                <tr>
                    <td>${movie.title}</td>
                    <td>annnee</td>
                    <td>Acteurs</td>
                    <td>Affiche</td>
                    <td><a href="decreaseNote?id=${movie.id}">-</a></t>
                    
                    <td>${movie.note}</td>
                    <td><a href="increaseNote?id=${movie.id}">+</a></td>
                 
                </tr>
            </c:forEach>
    
        </table>
        
    </fieldset>

    

</body>
</html>