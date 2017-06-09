<%@ page import="com.utbm.lo54.Util.Utils" %>
<%@ page import="core.Entity.IEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="core.Entity.CourseSessionEntity" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    List<IEntity> listCoursesSession = (List<IEntity>) request.getAttribute(Utils.ATTRIBUTE_LIST_COURSES_SESSION);
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./style/bootstrap.min.css"/>
    <link rel="stylesheet" href="./style/main.css"/>
    <script src="./javascript/bootstrap.min.js"></script>
    <script src="./javascript/bootstrap-select.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Home</title>
</head>
<body>

<h1 class="center">Basic JEE Showcase Project</h1>
<div class="table_container center">
    <div class="panel panel-danger">
        <div class="panel-heading" id="blue"> Liste des seances
        </div>
        <div class="panel-body">
            <div class="tab_filters" id="tab_filter">
                <div class="form-inline">
                    <label class="control-label" for="filter_location"> Location </label>
                    <select class="selectpicker" id="filter_location"
                            title="Filter by location" data-actions-box="true" >
                        <option value="0">Belfort</option>
                        <option value="1" selected>Sevenans</option>
                        <option value="2">Montbéliard</option>
                    </select>
                </div>
                <div class="form-inline">
                    <label class="control-label" for="filter"> Location </label>
                    <select class="selectpicker" id="filter_location"
                            title="Filter by location" data-actions-box="true" >
                        <option value="0">Belfort</option>
                        <option value="1" selected>Sevenans</option>
                        <option value="2">Montbéliard</option>
                    </select>
                </div>
            </div>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>Titre de formation</th>
                    <th>Debut de session</th>
                    <th>Fin de session</th>
                    <th>Lieu</th>
                    <th>Inscription</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (IEntity entity : listCoursesSession) {
                        CourseSessionEntity courseSession = (CourseSessionEntity) entity;
                        out.println("<tr>");
                        out.println("<td>" + courseSession.getCodeCourse() + "</td>");
                        out.println("<td>" + courseSession.getStartDate() + "</td>");
                        out.println("<td>" + courseSession.getEndDate() + "</td>");
                        out.println("<td>" + courseSession.getIdLocation() + "</td>");
                        out.println("</tr>");

                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

    <%
        out.println("<h3>" + request.getAttribute(Utils.ATTRIBUTE_SENTENCE) + "</h3>");
    %>

</div>
</body>
</html>