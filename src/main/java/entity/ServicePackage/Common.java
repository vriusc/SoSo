package entity.ServicePackage;

import java.text.DecimalFormat;

/**
 * 公共类
 *
 * @author aero*/
public class Common{
    public static String dataFormat(double data){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(data);
    }

    public static double sub(double sum1,double sum2){
        return (sum1*10-sum2*10)/10;
    }
}