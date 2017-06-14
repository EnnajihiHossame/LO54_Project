<%@ page import="com.utbm.lo54.Util.Utils" %>
<%@ page import="core.Entity.IEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="core.Entity.CourseSessionEntity" %>
<%@ page import="core.Entity.LocationEntity" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    List<IEntity> listCoursesSession = (List<IEntity>) request.getAttribute(Utils.ATTRIBUTE_LIST_COURSES_SESSION);
    List<IEntity> listLocations = (List<IEntity>) request.getAttribute(Utils.ATTRIBUTE_LIST_LOCATION);
    int current_location_filter = 99;
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

<!-- Modal -->
<div class="modal fade" id="subscription_modal" tabindex="-1" role="dialog" aria-labelledby="subscription_modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">S'inscrire</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Confirmer</button>
            </div>
        </div>
    </div>
</div>
<!-- End Modal -->
<script>
    function myFunction() {
        var x = document.getElementById("filter_location").value;
        alert("element " + x + "Cliked");
    }
</script>

<h1 class="center">Basic JEE Showcase Project</h1>
<div class="table_container center">
    <div class="panel panel-danger">
        <div class="panel-heading" id="blue"> Liste des seances
        </div>
        <div class="panel-body">
            <div class="tab_filters" id="tab_filter">
                <form>
                    <div class="form-inline">
                        <label class="control-label" for="filter_location"> Location </label>
                        <select id="filter_location" title="Filter by location" onchange="myFunction()">
                            <%
                                for (IEntity entity : listLocations) {
                                    LocationEntity location = (LocationEntity) entity;

                                    out.println("<option value=" + location.getIdLocation() + ">" + location.getCity() + "</option>");

                                }
                            %>
                        </select>
                    </div>
                </form>
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
                        out.println("<td><a class=\"btn btn-primary\" href=\"inscriptionForm?" + Utils.FILTER_ID_COURSE_SESSION + "=" + courseSession.getIdCourseSession() + "\"> S'inscrire </a></td>");
                        out.println("</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>