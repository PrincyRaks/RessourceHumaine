package control;

//import service.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AdminController extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        PrintWriter out = res.getWriter();
        /*res.setContentType("text/html");
        String name= req.getParameter("admin");
        String mdp= req.getParameter("mdp");
        Admin obj=new Admin(name,mdp);
        AdminService admins= new AdminService();
        ArrayList<Admin> liste = new ArrayList<Admin>(); 
        try {
            liste = admins.AllAdmin();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Nom du fichier
        req.setAttribute("",liste);*/
        RequestDispatcher dispat = req.getRequestDispatcher("listeEmployee.jsp");
        dispat.forward(req,res);
    }
}
