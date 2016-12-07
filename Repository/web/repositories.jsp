<%-- 
    Document   : Usuario
    Created on : 22/09/2016, 02:24:34 PM
    Author     : user 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Repositorys</title>
    </head>
    <body>
        <form action="RepositoryController" method="post">
            <fieldset>
                <legend>Formulario de Repositorys</legend>
                <div>
                 <label>Key:</label>
                <input type="text" name="key"
                       value="${repository.key}"
                       readonly="readonly"
                       placeholder="key"
                       />
                </div>
                       
                       <div>
                <label>User Key:</label>
                <input type="text" name="userKey"
                                value="${repository.userKey}"
                       placeholder="User Key"
                       />
                
                       </div>
                       
                       <div>
                 <label>Creation Date:</label>
                <input type="text" name="creationDate"
                       value="${repository.creationDate}"
                       placeholder="Creation date"
                       />
                
                       </div>
                       <div>
                 <label>Name:</label>
                <input type="text" name="name"
                       value="${repository.name}"
                       placeholder="Name"
                       />
                
                       </div>
                       
                       <div>
                
                <label>Description:</label>
                <input type="text" name="description"
                       value="${repository.description}"
                       
                       placeholder="Description"
                       />
                       </div>
                       
                  
                           <input type="submit" value="Guardar" />
                           
                       
            </fieldset>
            
        </form>
    </body>
</html>
