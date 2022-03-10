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
            <center><h1>Demander un congé</h1></center>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <center>
                        <label for="tdc">Type de contrat: </label>
                        <select name="tdc" class="form-control">
                            <option>CDI</option>
                        </select>
                        <label for="dd">Date début: </label>
                        <input type="date" class="form-control" name="dd">
                        <label for="df">Date Fin: </label>
                        <input type="date" class="form-control" name="df"><br>
                        <center><button type="submit" class="btn btn-outline-primary">Demander</button></center>
                    </center>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    
    <script src="Assets/js/jquery.min.js"></script>
    <script src="Assets/js/parallax.min.js"></script>
    <script src="Assets/js/bootstrap.min.js"></script>  
    </body>
</html>
