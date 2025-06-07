<%@ page import="java.util.List" %>
<%@ page import="lk.gemhub.project.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Mr. SP
  Date: 6/4/2025
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if(products != null){
        %>
        <h2>Product Bidding Details</h2>

                <table border="1" cellpadding="10" cellspacing="0">
                <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Starting Price</th>
                <th>Highest Bid</th>
                <th>Number of Bids</th>
                <th>Bid Owner</th>
                </tr>

                    <%
                        for (Product p: products){
                    %>
                    <tr id="row-<%=p.getId()%>">
                    <td><%= p.getId()%></td>
                    <td><%= p.getName()%></td>
                    <td><%= p.getDescription()%></td>
                    <td><%= p.getStartingPrice()%></td>
                    <td id="highestBid-<%=p.getId()%>"><%= p.getHighestBid()%></td>
                    <td id="auctionCount-<%=p.getId()%>"><%= p.getAuctionCount()%></td>
                    <td id="bidOwner-<%=p.getId()%>"><%= p.getBidOwner()==null?"no bids":p.getBidOwner().getName()%></td>
                    </tr>
                    <%
                        }
                    %>





                </table><%

    }
%>


<h2>Add New Product</h2>

<form action="./addProduct" method="POST">
    <table cellpadding="8" cellspacing="0">
        <tr>
            <td><label for="product_id">Product ID:</label></td>
            <td><input type="text" id="product_id" name="product_id" required></td>
        </tr>
        <tr>
            <td><label for="product_name">Product Name:</label></td>
            <td><input type="text" id="product_name" name="product_name" required></td>
        </tr>
        <tr>
            <td><label for="description">Description:</label></td>
            <td><textarea id="description" name="description" rows="4" cols="30" required></textarea></td>
        </tr>
        <tr>
            <td><label for="starting_price">Starting Price:</label></td>
            <td><input type="number" id="starting_price" name="starting_price" step="0.01" required></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <button type="submit">Add Product</button>
            </td>
        </tr>
    </table>
</form>

<script src="js/adminDashboardScript.js"></script>
</body>
</html>
