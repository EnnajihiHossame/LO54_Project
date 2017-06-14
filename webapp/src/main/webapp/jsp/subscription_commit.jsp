<%@ page import="com.utbm.lo54.Util.Utils" %><%--
  Created by IntelliJ IDEA.
  User: ennajihihoussame
  Date: 13/06/2017
  Time: 09:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../style/bootstrap.min.css"/>
    <link rel="stylesheet" href="../style/main.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Inscription à la session de cours</title>
</head>
<body>
<div class="container-fluid row">
    <h3><%
        Boolean confirmed = (Boolean) request.getAttribute(Utils.ATTRIBUTE_RESULT);
        if (confirmed) {
            out.println("Vous etes inscrit avec succès");
        } else {
            out.println("votre inscription a échoué");
        }
    %></h3>
    <a href="/" class="btn btn-primary">retour a la page d'accueil</a>
</div>
</body>
</html>
