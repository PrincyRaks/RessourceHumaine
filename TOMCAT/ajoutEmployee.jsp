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
        <form action="listeEmployee.jsp" method="post">
        <div class="container-fluid">
            <center><h1>Ajout Employee</h1></center>
            <div class="row" style="margin-top: 100px;">
                <div class="col-md-6">
                    <center>
                            <input type="text" name="nom" class="form-control" placeholder="Nom"><br>
                            <input type="date" name="naissance" class="form-control" placeholder="Date de naissance"><br>
                            <input type="text" name="mdp" class="form-control" placeholder="Mot de passe"><br>
                            <select name="poste" class="form-control">
                                <% String[][] empnos= (String[][])request.getAttribute("deptnos");
                                for(int i=0; i<empnos.length; i++){
                                out.print("<option value='"+empnos[i][0]b+"'>" +empnos[i][1]+ "</option>"); 
                                } 
                                %>
                            </select><br>
                    </center>
                </div>
                <div class="col-md-6">
                    <center>
                            <select name="sexe" class="form-control">
                                <option value="homme">Homme</option>
                                <option value="femme">Femme</option>
                            </select><br>
                            <input type="text" name="adresse" class="form-control" placeholder="Adresse"><br>
                            <input type="date" name="embauche" class="form-control" placeholder="Adresse">
                            <select name="contrat" class="form-control">
                                <option value="<%= %>">Contrat</option>
                            </select><br>
                            <input type="file" name="photo" class="form-control" placeholder="Photo"><br>
                    </center>
                </div>
            </div>
            <center><button type="submit" class="btn btn-outline-primary">Ajouter</button></center>
        </div>
        </form>
    <script src="Assets/js/jquery.min.js"></script>
    <script src="Assets/js/parallax.min.js"></script>
    <script src="Assets/js/bootstrap.min.js"></script>  
    </body>
</html>
