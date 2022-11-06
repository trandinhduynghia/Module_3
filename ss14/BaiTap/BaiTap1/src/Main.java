public class Main {
    public static void main(String[] args) {
        double x1 = 0, x2 = 0;
        int numNo = PhuongTrinhBac2.giaiPhuongTrinhBac2(3,-5,2, x1,  x2);
        if(numNo == 0){
            System.out.println("Phuong trinh vo nghiem");
        }else if(numNo == 1){
            System.out.println("Phuong trinh co 1 nghiem: " + x1);
        }else{
            System.out.println("Phuong trinh co 2 nghiem: "+x1+" "+x2);
        }
    }
}
