<%-- 
    Document   : ListarUsuario
    Created on : 22/09/2016, 02:24:08 PM
    Author     : user 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Repositorys</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Key</th>
                    <th>User Key</th>
                    <th>Creation Date</th>
                    <th>Name</th>
                    <th>Description</th>
                    
                    
                </tr>
            <tbody>
                <c:forEach var="repository" items="${repositories}">
                    <tr>
                        <td>${repository.key}</td>
                        <td>${repository.userKey}</td>
                        <td>${repository.creationDate}</td>
                        <td>${repository.name}</td>
                         <td>${repository.description}</td>
                        <td><a href="RepositoryController?action=modificar&key=${repository.key}">Modificar</a></td>
                         <td><a href="RepositoryController?action=eliminar&key=${repository.key}">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            
            
        </table>
        <p>
            <a href="RepositoryController?action=insertar">Nuevo Repository</a>
        </p>
    </body>
</html>
