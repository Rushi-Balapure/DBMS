package program;

import java.sql.*;
import java.util.Scanner;

public class temp {
    static Connection con;
    static PreparedStatement ps = null;

    public static void insert() throws SQLException{

        Scanner sc = new Scanner(System.in);

        ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
        System.out.println("Enter the emp_id: ");
        int emp_id = sc.nextInt();
        System.out.println("Enter dept_id:");
        int dept_id=sc.nextInt();
        System.out.println("Enter the emp_fname: ");
        String emp_fname = sc.next();
        System.out.println("Enter the emp_lname: ");
        String emp_lname = sc.next();
        System.out.println("Enter the position: ");0
         String pos = sc.next();
        System.out.println("Enter the emp_salary: ");
        int emp_salary = sc.nextInt();
        System.out.println("Enter the DOJ: ");
        String date = sc.next();

        ps.setInt(1,emp_id);
        ps.setInt(2,dept_id);
        ps.setString(3, emp_fname);
        ps.setString(4, emp_lname);
        ps.setString(5, pos);
        ps.setInt(6, emp_salary);
        ps.setString(7,date);

        System.out.println("Number of rows affected: " + ps.executeUpdate());
        sc.close();
    }

    public static void update() throws SQLException{

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter emp_id of which fields needs to update: ");
        int emp_id = sc.nextInt();

        System.out.println("Which field do you want to alter? \n 1.emp_dept \n  2.emp_fname \n 3.emp_lname \n 4.position \n 5. emp_salary \n 6.DOJ");
        int input = sc.nextInt();

        System.out.println("Enter the new value: ");

        if(input == 1)
        {

            int dept = sc.nextInt();
            ps = con.prepareStatement("update employee set Dept_id = ? where ID = ?");
            ps.setInt(1,dept);

        }
        else if(input==2)
        {
        	String fname=sc.next();
        	ps.getConnection().prepareStatement("update employee set Fname= ? where ID=?");
        	ps.setString(1, fname);
        }
        else if(input==3)
        {
        	String lname=sc.next();
        	ps.getConnection().prepareStatement("update employee set Lname= ? where ID=?");
        	ps.setString(1, lname);
        }
        else if(input==4)
        {
        	String pos=sc.next();
        	ps.getConnection().prepareStatement("update employee set Position= ? where ID=?");
        	ps.setString(1, pos);
        }
        else if(input==5)
        {
        	int salary=sc.nextInt();
        	ps.getConnection().prepareStatement("update employee set Salary= ? where ID=?");
        	ps.setInt(1, salary);
        }
        else if(input==6)
        {
        	String date=sc.next();
        	ps.getConnection().prepareStatement("update employee set DOJ= ? where ID=?");
        	ps.setString(1, date);
        }
        ps.setInt(2,emp_id);
        System.out.println("Number of rows affected: " + ps.executeUpdate());
        sc.close();

    }

    public static void delete() throws SQLException{

        ps = con.prepareStatement("delete from employee where ID = ?");

        System.out.println("Enter the emp_id of Employee that record has to delete: ");
        Scanner sc = new Scanner(System.in);

        int emp_id = sc.nextInt();
        ps.setInt(1,emp_id);
        System.out.println("Number of rows affected: " + ps.executeUpdate());
    }

    public static void select() throws SQLException{

        ps = con.prepareStatement("select * from employee");
        ResultSet rs = ps.executeQuery();

        if(!rs.next()){
            System.out.println("Empty Set!");
            return;
        }
        rs = ps.executeQuery();
        System.out.println("--------Data--------");
        while (rs.next()){

            int emp_id = rs.getInt(1);
            int dept = rs.getInt(2);
            String fname=rs.getString(3);
            String lname = rs.getString(4);
            String pos=rs.getString(5);
            int emp_salary = rs.getInt(6);
            String date=rs.getString(7);

            System.out.println(emp_id + " " + dept + " " + fname+" " + lname+" " + pos+" " + emp_salary+" "+date);
        }
        System.out.println("--------------------");
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS","root","Evil1205");
         Class.forName("com.mysql.cj.jdbc.Driver");

         if(con==null){
             System.out.println("Something went Wrong!");
         }else{
             System.out.println("Connection Established!");
         }
        Scanner sc = new Scanner(System.in);
        int choice;

        while(true){

            System.out.println("-----------Menu-----------");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Select Data");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    insert();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    select();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Please select the option from above Menu!");
                    break;
            }
        }

    }

}