<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cs3220" uri="http://cs3.calstatela.edu/cs3220stu74/final" %>
<!doctype html>
<html lang="en">
<head>
	<title>Links</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
	<%-- <link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css"> --%>
	<style>
    .link-point {
      float:left;
      position:absolute;
      text-align:center;
      background:#d0d0d0;
      color:#000000;
      margin:auto;
      width:8vw;
      height:7vw;
      font-size:4vw;
    }
    .link-container {
	  display:inline-block;
	  width:30;
	  height:10;
	}
    .link-content {
      display:inline-block;
      padding-left:9vw;
      overflow:hidden;
    }
    a:hover, a:visited, a:link, a:active {
      text-decoration: none;
    }
    </style>
</head>
<body>
<div class="container">
	<!-- Page Header -->
	<div class="page-header">
		<h2>List of Links</h2>
	</div>

	<form action="AddLink" method="GET">
	<div class="form-group">
	<h4>Add a Link</h4>
		<label for="title">Title:</label>
		<input type="text" class="form-control" id="title" name="title" placeholder="Enter a Title for your Link">
	</div>
	<div class="form-group">
		<label for="url">Link:</label>
		<input type="text" class="form-control" id="url" name="url" placeholder="Enter a Link here">
	</div>
	<button type="submit" class="btn btn-success">Submit Link</button>
	</form>

	<c:if test="${not empty links}">
	<br>
	<br>
	<p>I made a custom tag!</p>
	<br>
	<c:forEach items="${links}" var="item">
	<cs3220:Link var="${item}" />
	<br><br>
	</c:forEach>
	</c:if>
</div>
We did it leddit!!!! <font size="15"> XD </font>
</body>
</html>
