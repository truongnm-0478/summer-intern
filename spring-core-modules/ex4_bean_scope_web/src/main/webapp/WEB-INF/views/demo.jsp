<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>
<body>
<h1>Spring MVC Demo Page</h1>
<h2>Application Scoped Bean</h2>
<p>${applicationBean.value}</p>

<h2>Session Scoped Bean</h2>
<p>${sessionBean.value}</p>

<h2>Request Scoped Bean</h2>
<p>${requestBean.value}</p>
</body>
</html>
