<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Films</title>
</head>
<body>
 <h1 >
 Liste des Films
 </h1>
 <table >
 <tr>
 <th>ID</th><th>Nom Film</th><th>Duree</th><th>Date Sortie</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${films}" var="f">
 <tr>
 <td>${f.idFilm }</td>
 <td>${f.nomFilm }</td>
 <td>${f.dureeFilm }</td>
 <td><a onclick="return confirm('Etes-vous sûr ?')"
href="supprimerFilm?id=${f.idFilm}">Supprimer</a></td>
 <td><a href="modifierFilm?id=${f.idFilm }">Edit</a></td>
 </tr>
 </c:forEach>
 </table>
</body>
</html>