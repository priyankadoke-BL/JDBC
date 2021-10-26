package com.bl;
import java.sql.*;
import java.util.Enumeration;
class ConA{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/payroll_service","root","principal@12345");
         //here payroll_service is database name, root is username and password principal@12345
            ResultSet rs;
            try (Statement stmt = con.createStatement()) {

                rs = stmt.executeQuery("select * from  payroll_service");
            }//to establish connection

            while(rs.next())//to know count of row
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    private static void listDrivers(){
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while (driverlist.hasMoreElements()){
            Driver driver = driverlist.nextElement();
            System.out.println(" "+driver.getClass().getName());

        }
    }
}