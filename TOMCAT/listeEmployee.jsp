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
            <center><h1>Liste Employee</h1></center><br><br>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <center>
                        <table class="table table-responsive-md">
                            <tr>
                                <th>Nom</th>
                                <th>Poste</th>
                                <th>Type Contrat</th>
                            </tr>

                            <% 
                            String [][] listEmp =(String[][]) request.getAttribute("listes");
                            for(int i=0; i<listEmp.length;i++){
                                out.print("<tr>");
                                for(int j=0; j< listEmp[i].length;j++){
                                    out.print("<td>"+listEmp[i][j]+"</td>");
                                }
                                out.print("</tr>");
                            }
                            %>
                        </table>
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
