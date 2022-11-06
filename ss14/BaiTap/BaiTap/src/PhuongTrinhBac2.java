import java.security.NoSuchAlgorithmException;

import static java.lang.Math.sqrt;

public class PhuongTrinhBac2 {
    public static void main(String[] args) {
        // write your code here
    }

    public static int giaiPhuongTrinhBac2(double a, double b, double c, double x1, double x2) {
        double delta = b * b - 4*a*c;
        if(delta < 0){
            x1=x2=0;
            return 0;
        }else if(delta == 0){
            x1 = x2 = -b/(2*a);
            return 1;
        }else {
            delta = sqrt(delta);
            x1 = (-b + delta) / (2*a);
            x2 = (-b - delta) / (2*a);
            return 2;
        }
    }
}
