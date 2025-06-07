<%@ page import="java.util.List" %>
<%@ page import="lk.gemhub.project.model.Product" %>
  Created by IntelliJ IDEA.
  User: Mr. SP
  Date: 6/4/2025
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products != null) {

        for (Product p : products) {
%>

<table style="margin-bottom: 20px;" id="card" border="1" cellpadding="10" cellspacing="0" width="300">
    <tr>
        <td colspan="2" align="center">
            <h3 id="name"><%= p.getName()%>
            </h3>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <p id="description"><%= p.getDescription()%>
            </p>
        </td>
    </tr>
    <tr>
        <td><strong>Current Price:</strong></td>
        <td id="current_price_<%= p.getId()%>"><%= p.getHighestBid()%>
        </td>
    </tr>
    <tr>
        <td><label for="bid_input_<%= p.getId()%>">Your Bid:</label></td>
        <td><input type="number" id="bid_input_<%= p.getId()%>" name="bid_price" placeholder="Enter your bid" required>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button onclick="placeBid(<%= p.getId()%>)" type="submit">Place Bid</button>
        </td>

    </tr>

</table>
<%
        }
    }
%>


<div class="hide" id="messageWrapper">

    <div class="" id="messageBox">sample</div>

</div>

<script src="js/homeScript.js"></script>
</body>
</html>
