<%@ page import="core.Entity.CourseSessionEntity" %>
<%@ page import="com.utbm.lo54.Util.Utils" %><%--
  Created by IntelliJ IDEA.
  User: ennajihihoussame
  Date: 12/06/2017
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CourseSessionEntity courseSession = (CourseSessionEntity) request.getAttribute(Utils.ATTRIBUTE_COURSE_SESSION);
%>
<html>
<head>
    <link rel="stylesheet" href="../style/bootstrap.min.css"/>
    <link rel="stylesheet" href="../style/main.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Page d'inscription au session de cours</title>
</head>
<body>
<div class="container-fluid row">
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">Inscription à la session
                <%
                out.print(courseSession.getCourse().getTitle());
                out.print(" à" + courseSession.getLocation().getCity());
                out.print(" du " + courseSession.getStartDate());
                out.print(" au " + courseSession.getEndDate());
            %></div>
            <div class="panel-body">
                <form method="POST" action="inscription?<%out.print(Utils.FILTER_ID_COURSE_SESSION); %>=<%out.print(courseSession.getIdCourseSession());%>">
                    <div class="form-group">
                        <label for="lastname">Nom</label>
                        <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Nom">
                    </div>
                    <div class="form-group">
                        <label for="firstname">Prénom</label>
                        <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Prénom">
                    </div>
                    <div class="form-group">
                        <label for="address">Adresse</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Adresse">
                    </div>
                    <div class="form-group">
                        <label for="phone">N° de telephone</label>
                        <input type="text" class="form-control" name="phone" id="phone" placeholder="Telephone">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="Email">
                    </div>
                    <button type="cancel" class="btn btn-warning">Annuler</button>
                    <button type="submit" class="btn btn-success">Confirmer</button>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
