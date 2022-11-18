package validate;

public class Validation {
    public static boolean checkEmail(String email){
        String regexEmail = "^[a-z]+\\.\\w+\\@[a-z]{2,}\\.[a-z]{2,}$";
        return email.matches(regexEmail);
    }

    public static boolean checkCMND(String CMND){
        String regexCMND = "[0-9]{9}";
        return CMND.matches(regexCMND);
    }

    public static boolean checkSDT(String SDT){
        String regexSDT = "^(0\\d{9,10})$";
        return SDT.matches(regexSDT);
    }

    public static boolean checkTen(String Ten){
        String regexTen = "^([a-z]+)((\\s{1}[a-z]+){1,})$";
        return Ten.matches(regexTen);
    }
}
