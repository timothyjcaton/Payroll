import java.util.Scanner;

/**
 * Created by tjc4h on 6/29/2016.
 */
public class SalaryEmployee extends Employee
{
    @Override
    public float computeGross()
    {
        int choice;

        System.out.println("Choose 1.) for Executive or choose 2.) for Staff");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        if(choice==1)
        {
            gross = 100000;
        }

        else
        {
            gross = 50000;
        }

        return gross;
    }
}
