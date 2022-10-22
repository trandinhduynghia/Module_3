package Validate;



import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static Scanner scanner;









    public static Double validateSoTien() {
        while (true) {
            scanner = new Scanner(System.in);
            Double soTien = scanner.nextDouble();
            if (soTien > 0) {
                return soTien;
            } else {
                System.out.println("Số  phải lớn hơn 0");
            }
        }
    }

    public static int validateKyHan() {
        while (true) {
            scanner = new Scanner(System.in);
            int kyHan = scanner.nextInt();
            if (kyHan == 3 || kyHan == 5 ) {
                return kyHan;
            } else {
                System.out.println("Kỳ hạn phải là 3 năm hoặc 5 năm");
            }
        }
    }
}
