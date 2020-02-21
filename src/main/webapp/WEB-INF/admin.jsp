<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Add Category:<br>
<br><spring:form action="/addCategory" method="post" modelAttribute="category">
    <spring:label path="name">Name:</spring:label>
    <spring:input path="name"/>
    <input type="submit" value="ADD">
</spring:form>
<br>
Add Brand:<br>
<br><spring:form action="/addBrand" method="post" modelAttribute="brand">
    <spring:label path="name">Name:</spring:label>
    <spring:input path="name"/>
    <input type="submit" value="ADD">
</spring:form>

Add Product:<br>
<br><spring:form action="/addProduct" method="post" modelAttribute="product" enctype="multipart/form-data">
    <spring:label path="name">Name:</spring:label>
    <spring:input path="name"/><br>

   <br> <spring:label path="description">Description:</spring:label>
    <spring:textarea path="description"/><br>

    <br><spring:label path="price">Price:</spring:label>
    <spring:input path="price"/><br>

  <br><spring:select path="category" items="${allCategories}" itemLabel="name"/>
    <spring:select path="brand" items="${allBrands}" itemLabel="name"/><br>

    <br><label for="image">Image:</label>
    <input id="image" type="file" name="image"/><br>

    <br><input type="submit" value="ADD">
</spring:form>
<br>
</body>
</html>
