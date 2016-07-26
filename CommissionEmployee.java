import java.util.Scanner;

/**
 * Created by tjc4h on 6/29/2016.
 */
public class CommissionEmployee extends Employee
{


    @Override
    public float computeGross()
    {
        int items;

        System.out.println("How many items did you sell?");
        Scanner sc = new Scanner(System.in);
        items = sc.nextInt();

        items *= (100*.5);

        gross = items;

        return gross;
    }
}
