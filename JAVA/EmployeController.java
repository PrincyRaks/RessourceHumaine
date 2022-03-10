package control;
import obj.*;
import tool.*;
import service.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class EmployeController {
    //Ajout
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        String nom =(String)req.getParameter("nom");
        String naissance = (String) req.getParameter("naissance");
        String mdp=(String) req.getParameter("mdp");
        String poste=(String) req.getParameter("poste");
        String sexe=(String) req.getParameter("sexe");
        String embauche = (String) req.getParameter("embauche");
        String adresse = (String) req.getParameter("adresse");
        String contrat = (String) req.getParameter("contrat");
        String photo =(String) req.getParameter("photo");
        Employe emp = new Employe(Integer.valueOf(poste), Integer.valueOf(contrat), nom, naissance, sexe, embauche, adresse, mdp, photo);
        try {
            EmployeService emps = new EmployeService();
            emps.Add(emp);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    //Liste
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        EmployeService emps = new EmployeService();
        try {
            ArrayList<Employe> liste = emps.AllEmploye();
            String[][] emphtml = Reflector.html(new Employe(), liste);
            req.setAttribute("listes",emphtml);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        RequestDispatcher dispat = req.getRequestDispatcher("listEmployee.jsp");
        dispat.forward(req,res);
    }
}
