<%@ page import="com.utbm.lo54.Util.Utils" %>
<%@ page import="core.Entity.IEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="core.Entity.CourseSessionEntity" %>
<%@ page import="core.Entity.LocationEntity" %>
<%@ page import="javax.rmi.CORBA.Util" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    List<IEntity> listCoursesSession = (List<IEntity>) request.getAttribute(Utils.ATTRIBUTE_LIST_COURSES_SESSION);
    List<IEntity> listLocations = (List<IEntity>) request.getAttribute(Utils.ATTRIBUTE_LIST_LOCATION);
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./style/bootstrap.min.css"/>
    <link rel="stylesheet" href="./style/main.css"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Home</title>
</head>
<body>
<script src="../javascript/jquery-3.2.1.min.js"></script>
<script src="../javascript/bootstrap.min.js"></script>
<script src="../javascript/bootstrap-select.js"></script>


<h1 class="center">Bienvenue au gestionnaire d'inscription aux formations !</h1>
<div class="table_container center">
    <div class="panel panel-danger">
        <div class="panel-heading" id="blue"> Liste des seances
        </div>
        <div class="row">
            <form method="post" action="landing_filter_by_location" class="col-md-3 form-inline" id="tab_filter">
                <div class="form-group">
                    <label class="control-label" for="filter_location"> Location </label>
                    <select id="filter_location" name="filter_location" title="Filter by location">
                        <option disabled selected></option>
                        <%
                            for (IEntity entity : listLocations) {
                                LocationEntity location = (LocationEntity) entity;
                                out.println("<option value=" + location.getIdLocation() + ">" + location.getCity() + "</option>");
                            }
                        %>
                    </select>
                </div>
                <button type="submit" class="btn btn-sm btn-primary">Find</button>
            </form>
            <form method="post" action="landing_filter_by_title" class="col-md-3 form-inline">
                <div class="form-group">
                    <label for="filter_search" class="control-label">Recherche</label>
                    <input id="filter_search" name="filter_search" type="text">
                </div>
                <button type="submit" class="btn btn-sm btn-primary">Find</button>
            </form>
            <form method="post" action="landing_filter_by_date" class="col-md-3 form-inline">
                <div class="form-group">
                    <label for="filter_date" class="control-label">Date :</label>
                    <input id="filter_date" name="filter_date" type="date" placeholder=" ex : 16-06-2017">
                </div>
                <button type="submit" class="btn btn-sm btn-primary">Find</button>
            </form>
            <a class="col-md-3" href="/">Clear all filters</a>
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
                    out.println("<td>" + courseSession.getCourse().getTitle() + "</td>");
                    out.println("<td>" + courseSession.getStartDate() + "</td>");
                    out.println("<td>" + courseSession.getEndDate() + "</td>");
                    out.println("<td>" + courseSession.getLocation().getCity() + "</td>");
                    out.println("<td><a class=\"btn btn-primary\" href=\"inscriptionForm?" + Utils.SELECTED_ID_COURSE_SESSION + "=" + courseSession.getIdCourseSession() + "\"> S'inscrire </a></td>");
                    out.println("</tr>");
                }
            %>
            </tbody>
        </table>
        <% if (request.getAttribute(Utils.CURRENT_FILTER_TYPE) != null) {
            String filter_type = (String) request.getAttribute(Utils.CURRENT_FILTER_TYPE);
            String filter_value = (String) request.getAttribute(Utils.CURRENT_FILTER_VALUE);
            out.println("<h5>(Filtre actuelle est : " + filter_type + " = " + filter_value + ")</h5>");
        }%>
    </div>

</div>

</body>
</html>