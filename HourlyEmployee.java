import java.util.Scanner;

/**
 * Created by tjc4h on 6/29/2016.
 */
public class HourlyEmployee extends Employee
{
    @Override
    public float computeGross()
    {
        float regtimepay;
        float otpay;

        if(hours>40)
        {
            regtimepay = (40 * rate);
            otpay = (float) ((hours - 40) * (rate * 1.5));
            gross = (regtimepay + otpay);
        }

        else
        {
            gross = hours*rate;
        }

        return gross;
    }
}