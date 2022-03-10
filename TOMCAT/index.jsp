<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>RH</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Assets/css/bootstrap.css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <center>
                        <div class="card" style="width: 18rem; margin-top: 150px;">
                          <div class="card-body">
                            <h5 class="card-title">Administrateur</h5>
                            <form action="listeEmployee.jsp" method="post">
                            <input type="text" class="form-control" placeholder="Login" name=""><br>
                            <input type="text" class="form-control" placeholder="Mot de Passe" name=""><br>
                            <center><button class="btn btn-outline-primary" type="submit">Connexion</button></center>
                            </form>
                          </div>
                        </div>
                    </center>
                </div>
                <div class="col-md-6">
                     <center>
                        <div class="card" style="width: 18rem; margin-top: 150px;">
                          <div class="card-body">
                            <h5 class="card-title">Employee</h5>
                            <form action="listeEmployee.jsp" method="post">
                            <input type="text" class="form-control" placeholder="Login" name=""><br>
                            <input type="text" class="form-control" placeholder="Mot de Passe" name=""><br>
                            <center><button class="btn btn-outline-primary" type="submit">Connexion</button></center>
                            </form>
                          </div>
                        </div>
                    </center>
                </div>
            </div>
        </div>
    
    <script src="Assets/js/jquery.min.js"></script>
    <script src="Assets/js/parallax.min.js"></script>
    <script src="Assets/js/bootstrap.min.js"></script>  
    </body>
</html>
