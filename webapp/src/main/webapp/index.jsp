<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./style/bootstrap.min.css"/>
    <link rel="stylesheet" href="./style/main.css"/>
    <script src="./js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Course Online | Home</title>
</head>
<body>

<h1>Welcome to the Online Courses</h1>
<div class="table_container center">
    <div class="panel panel-danger">
        <div class="panel-heading" id="blue"> Liste des seances</div>
        <div class="panel-body">
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
                <tr>
                    <td>DB50</td>
                    <td>24/06/2017 10h00</td>
                    <td>24/06/2017 13h00</td>
                    <td>Belfort</td>
                    <td><button>s'inscrire</button></td>
                </tr>
                <tr>
                    <td>DB50</td>
                    <td>10/06/2017 15h00</td>
                    <td>10/06/2017 18h00</td>
                    <td>Sevenans</td>
                    <td><button>s'inscrire</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>