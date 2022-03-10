package service;

import obj.*;
import java.lang.reflect.*;
import java.util.*;
import java.lang.*;
import java.sql.*;

public class EmployeService {
    public void Add(Employe employe) throws Exception
        {
            employe.AjoutEmploye();
        }
    
    /*public void setEmploye() throws Exception{

    }*/

    public ArrayList<Employe> AllEmploye() throws Exception{
            Employe emp = null;
            return emp.getAllEmploye();
        }
    }
