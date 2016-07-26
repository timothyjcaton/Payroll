
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.UIManager.get;

/**
 * Created by tjc4h on 6/29/2016.
 */
public class Payroll implements Serializable
{
    //private Employee[] employees = new Employee[3];
    public ArrayList<Employee> employees = new ArrayList<Employee>();
    public boolean accountsLoaded = false;

    public static void main(String[] args)
    {
        Payroll myPayroll = new Payroll();
        myPayroll.topMenu();
    }

    public static void topMenu()
    {
        int input;
        String ee;
        boolean exit = false;

        Payroll myPayroll = new Payroll();

        while(!exit)
        {
            System.out.println("Please choose one of the following:");
            System.out.println("1.) Populate Employees");
            System.out.println("2.) Modify Employee");
            System.out.println("3.) Access Saved Employee");
            System.out.println("4.) Exit and Print employees to a text file");
            System.out.println("5.) Exit");

            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            sc.nextLine();

            switch (input)
            {
                case 1:
                    myPayroll.populateEmployees();
                    break;
                case 2:

                    System.out.println("Please choose employee ID 1, 2 or 3:");
                    ee = sc.next();
                    myPayroll.selectEmployee(ee);
                    break;
                case 3:
                    myPayroll.loadEmployee();
                    System.out.println("Please choose employee ID 1, 2 or 3:");
                    ee = sc.next();
                    myPayroll.displaySavedEmployee(ee);
                    break;
                case 4:
                    myPayroll.saveTextFile();
                case 5:
                    myPayroll.saveEmployee();
                    System.exit(1);
                    break;

            }
        }
    }

    public void populateEmployees()
    {
        if(accountsLoaded == true)
        {
            System.out.println("Accounts already loaded.");
        }

        if(accountsLoaded == false)
        {

            employees.add(new HourlyEmployee());
            employees.add(new SalaryEmployee());
            employees.add(new CommissionEmployee());
            accountsLoaded = true;
        }
    }

    public void selectEmployee(String ee)
    {

        if (ee.equals("1"))
        {
            employees.get(0).menu(1);
        }
        if (ee.equals("2"))
        {
            employees.get(1).menu(2);
        }

        if (ee.equals("3"))
        {
            employees.get(2).menu(3);
        }
    }

    public void displaySavedEmployee(String ee)
    {
        if (ee.equals("1"))
        {
            employees.get(0).displayEmployee();
        }
        if (ee.equals("2"))
        {
            employees.get(1).displayEmployee();
        }

        if (ee.equals("3"))
        {
            employees.get(2).displayEmployee();
        }
    }

    public void saveEmployee()
    {
        try
        {
            FileOutputStream outStream = new FileOutputStream("D:employeefile.out");
            ObjectOutputStream os = new ObjectOutputStream(outStream);
            os.writeObject(employees);
            os.flush();
            os.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void saveTextFile()
    {

        PrintStream o = null;
        try {
            o = new PrintStream(new File("D:employeetext.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintStream console = System.out;

        System.setOut(o);
        System.out.println("Employee 1:");
        System.out.println(employees.get(0).displayEmployee());
        System.out.println("");
        System.out.println("Employee 2:");
        System.out.println(employees.get(1).displayEmployee());
        System.out.println("");
        System.out.println("Employee 3:");
        System.out.println(employees.get(2).displayEmployee());

        System.setOut(console);
        System.out.println("The employees are now printed to the text file");
    }

    public void loadEmployee()
    {
        try
        {
            FileInputStream inStream = new FileInputStream("D:employeefile.out");
            ObjectInputStream is = new ObjectInputStream(inStream);
            employees = (ArrayList) is.readObject();
            is.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
