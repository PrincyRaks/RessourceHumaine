package tool;

import java.lang.reflect.*;
import java.util.*;
import java.lang.*;
import java.sql.*;
public class Reflector
{
    public static boolean isNumber(String string)
    {
        boolean valiny=string.matches("[+-]?\\d*(\\.\\d+)?");
        return valiny;
    }
    public static boolean isSetter(Method method)
    {
        if(!method.getName().startsWith("set"))
        {
            return false;
        }
        return true;
    }
    public static boolean isGetter(Method method)
    {
        if(!method.getName().startsWith("get"))
        {
            return false;
        }
        return true;
    }
    public static int mpamadikaHoInt(String line) throws NumberFormatException
    {
        int x=Integer.parseInt(line);
        return x;
    }
    public static double mpamadikaHoDouble(String line) throws NumberFormatException
    {
        double x=Double.parseDouble(line);
        return x;
    }
    public static float mpamadikaHoFloat(String line) throws NumberFormatException
    {
        float x=Float.parseFloat(line);
        return x;
    }
    public static char mpamadikaHoChar(String line) throws NumberFormatException
    {
        char c=line.charAt(0);
        return c;
    }
    public static boolean mpamadikaHoBoolean(String line) throws NumberFormatException
    {
        boolean x=Boolean.parseBoolean(line);
        return x;
    }
    public static Method[] getMethodsSetter(Object O)
    {
        Vector<Method> V=new Vector<Method>();
        Class<?> cls=O.getClass();
        Method[] method=cls.getMethods();
        Field[] field=cls.getDeclaredFields();
        for(int i=0; i<method.length; i++)
        {
            if(isSetter(method[i])==true)
            {
                V.addElement(method[i]);
            }
        }
        Method[] methodF=new Method[V.size()];
        for(int i=0; i<methodF.length; i++)
        {
            methodF[i]=V.get(i);
        }
        int q=0;
        for(int i=0; i<field.length; i++)
        {
            for(int j=0; j<methodF.length; j++)
            {
                String a=methodF[j].getName();
                a=a.toLowerCase();
                a=a.substring(3,a.length());
                int ax=a.compareToIgnoreCase(field[i].getName());
                if(ax==0)
                {
                    Method m=methodF[q];
                    methodF[q]=methodF[j];
                    methodF[j]=m;
                }
            }
            q++;
        }
        return methodF;
    }
    public static Method[] getMethodsGetter(Object O)
    {
        Vector<Method> V=new Vector<Method>();
        Class<?> cls=O.getClass();
        Method[] method=cls.getMethods();
        Field[] field=cls.getDeclaredFields();
        for(int i=0; i<method.length; i++)
        {
            if(isGetter(method[i])==true)
            {
                V.addElement(method[i]);
            }
        }
        Method[] methodF=new Method[V.size()-1];
        for(int i=0; i<methodF.length; i++)
        {
            methodF[i]=V.get(i);
        }
        int q=0;
        for(int u=0; u<field.length; u++)
        {
            for(int j=0; j<methodF.length; j++)
            {
                String a=methodF[j].getName();
                a=a.toLowerCase();
                a=a.substring(3,a.length());
                int ax=a.compareToIgnoreCase(field[u].getName());
                if(ax==0)
                {
                    Method m=methodF[q];
                    methodF[q]=methodF[j];
                    methodF[j]=m;
                }
            }
            q++;
        }
        return methodF;
    }
    public static Object[] select(Object O, String col, String nomTable, Connection connection, String primaryKey) throws SQLException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        Statement statement = connection.createStatement();
        String sql = "select "+col+" from "+nomTable+" order by "+primaryKey;
        ResultSet count=statement.executeQuery(sql);
        int c=0;
        while (count.next()){c++;};
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData resdata=resultSet.getMetaData();
        Vector<Object> Fr=new Vector<Object>();
        String[][] values=new String[c][resdata.getColumnCount()];
        int k=0;
        while(resultSet.next())
        {
            Class<?> a=O.getClass();
            Object NewObject=a.getDeclaredConstructor().newInstance();
            Method[] mm=getMethodsSetter(O);
            Method[] mg=getMethodsGetter(O);
            for(int i=1, u=0;i<=resdata.getColumnCount();i++, u++)
            {
                values[k][i-1]=resultSet.getString(i);
                if(isNumber(values[k][i-1])==true)
                {
                    if(mg[u].getReturnType().getName()=="int")
                    {
                        int line_int=mpamadikaHoInt(values[k][i-1]);
                        mm[u].invoke(NewObject,line_int);
                    }
                    else if(mg[u].getReturnType().getName()=="double")
                    {
                        double doub=mpamadikaHoDouble(values[k][i-1]);
                        mm[u].invoke(NewObject,doub);
                    }
                    else if(mg[u].getReturnType().getName()=="float")
                    {
                        float doub=mpamadikaHoFloat(values[k][i-1]);
                        mm[u].invoke(NewObject,doub);
                    }
                }
                else
                {
                    if(mg[u].getReturnType().getName()=="boolean")
                    {
                        boolean doub=mpamadikaHoBoolean(values[k][i-1]);
                        mm[u].invoke(NewObject,doub);
                    }
                    else if(mg[u].getReturnType().getName()=="char")
                    {
                        char ch=mpamadikaHoChar(values[k][i-1]);
                        mm[u].invoke(NewObject,ch);
                    }
                    else if(mg[u].getReturnType().getName()=="java.lang.String")
                    {
                        mm[u].invoke(NewObject,values[k][i-1]);
                    }
                }
            }
            Fr.addElement(NewObject);
            k++;
        }
        Object[] OBJ=new Object[Fr.size()];
        for(int i=0;i<OBJ.length;i++)
        {
            OBJ[i]=Fr.elementAt(i);
        }
        resultSet.close();
        statement.close();
        return OBJ;
    }
    public static String[][] html(Object O, ArrayList<?> listObject) throws SQLException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        Method[] m=getMethodsGetter(O);
        String[][] values=new String[listObject.size()][m.length];
        for(int i=0; i<listObject.size(); i++)
        {
            Method[] mg=Reflector.getMethodsGetter(O);
            for(int j=0; j<mg.length; j++)
            {
                if(mg[j].getReturnType().getName()=="int")
                {
                    int stri=(int)mg[j].invoke(listObject.get(i));
                    values[i][j]=String.valueOf(stri);
                }
                else if(mg[j].getReturnType().getName()=="double")
                {
                    double doub=(double)mg[j].invoke(listObject.get(i));
                    values[i][j]=String.valueOf(doub);
                }
                else if(mg[j].getReturnType().getName()=="float")
                {
                    float doub=(float)mg[j].invoke(listObject.get(i));
                    values[i][j]=String.valueOf(doub);
                }
                else if(mg[j].getReturnType().getName()=="java.lang.String")
                {
                    values[i][j]=(String)mg[j].invoke(listObject.get(i));
                }
                else if(mg[j].getReturnType().getName()=="boolean")
                {
                    boolean doub=(boolean)mg[j].invoke(listObject.get(i));
                    values[i][j]=String.valueOf(doub);
                }
                else if(mg[j].getReturnType().getName()=="char")
                {
                    char ch=(char)mg[j].invoke(listObject.get(i));
                    values[i][j]=String.valueOf(ch);
                }
            }
        }
        return values;
    }
}