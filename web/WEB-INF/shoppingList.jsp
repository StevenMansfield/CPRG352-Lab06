<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>        
        <div>
            Hello, ${username} 
            <a href="shoppingList?action=logout">Logout</a>
        </div>
        <h2>List</h2>
        <form method="POST" action=""> 
            <div>
                <label>Add Item: </label>
                <input type="text" name="item">
                <input type="submit" value="Add Item">
                <input type="hidden" name="action" value="add">
            </div>
        </form>
<!--        When the form has no action it does not forward to a particular page, it comes back to the page. The default action of a form is to go back to itself. -->
<!--        Using a JSTL foreach loop to fill the list  -->
        <form method="POST" action="">
<!--                Items should be added in as <li><input type="radio" name="item" value="What was entered in the text box">What was entered in the text box</li>-->
                <c:forEach var="itemList" items="${itemList}">
                    <div>
                        <input type="radio" name="item" value="${itemList}">${itemList}
                    <div>
                </c:forEach>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form> 
    </body>
</html>
