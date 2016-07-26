import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by tjc4h on 6/29/2016.
 */


public abstract class Employee implements Serializable
{
    float rate;
    float taxrate=0.2f;
    int hours;
    float gross=0.0f;
    float tax=0.0f;
    float net=0.0f;
    float net_percent=0.0f;

    public Employee() //default constructor
    {

    }

    public void menu(int input)
    {
        HourlyEmployee he = new HourlyEmployee();
        SalaryEmployee se = new SalaryEmployee();
        CommissionEmployee ce = new CommissionEmployee();

        if(input==1)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter number of hours worked: ");
            hours = sc.nextInt();

            System.out.println("Please enter rate: ");
            rate = sc.nextFloat();

            computeGross();
            computeTax();
            computeTax();
            computeNet();
            computeNetperc();
            displayEmployee();
        }

        if(input==2)
        {
            computeGross();
            computeTax();
            computeTax();
            computeNet();
            computeNetperc();
            displayEmployee();
        }

        if(input==3)
        {
            computeGross();
            computeTax();
            computeTax();
            computeNet();
            computeNetperc();
            displayEmployee();
        }
    }

    public abstract float computeGross();


    protected void computeTax()
    {
        tax= gross *taxrate;
    }

    protected void computeNet()
    {
        net= gross-tax;
    }

    protected void computeNetperc()
    {
        net_percent=(net/gross)*100;
    }

    protected PrintStream displayEmployee()
    {
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
        System.out.println("Gross: " + gross);
        System.out.println("Net: " + net);
        System.out.println("Net%: " + net_percent + "%");
        return null;
    }
}





