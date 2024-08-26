import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonAn {
    public final int FLAG_CARB = 1;
    public final int FLAG_FAT = 2;
    public final int FLAG_FAT_BH = 3;
    public final int FLAG_PROTEIN = 4;
    public final int FLAG_CALO = 5;
    private List<NguyenLieu> arr;
    public MonAn() {
        this.arr = new ArrayList<>();
    }

    public void nhap() {
        System.out.println("Mời bạn nhập gà: ");
        NguyenLieu ga = new Ga();
        ga.nhap();
        this.arr.add(ga);

        System.out.println("Mời bạn nhập hạt sen: ");
        NguyenLieu hatSen = new HatSen();
        hatSen.nhap();
        this.arr.add(hatSen);

        System.out.println("Mời bạn cà rốt: ");
        NguyenLieu caRot = new CaRot();
        caRot.nhap();
        this.arr.add(caRot);

        System.out.println("Mời bạn nhập táo đỏ: ");
        NguyenLieu taoDo = new TaoDo();
        taoDo.nhap();
        this.arr.add(taoDo);

        System.out.println("Mời bạn nhập nấm đông cô: ");
        NguyenLieu nam = new NamDongCo();
        nam.nhap();
        this.arr.add(nam);
    }

//    public float tinhNangLuong(int flag) {
//        float sum = 0;
//        for(NguyenLieu a:this.arr) {
//            if(flag == 1) {
//                sum += a.getKhoiLuong()/100.0f*a.getCarb();
//            } else if(flag == 2) {
//                sum += a.getKhoiLuong()/100.0f*a.getFat();
//            } else if(flag == 3) {
//                sum += a.getKhoiLuong()/100.0f*a.getFatBH();
//            } else if(flag == 4) {
//                sum += a.getKhoiLuong()/100.0f*a.getProtein();
//            } else if(flag == 5 ) {
//                sum += a.getKhoiLuong()/100.0f*a.getCalo();
//            }
//        }
//        return sum * 0.8f;
//    }

    public float tinhNangLuong(int flag) {
        return (float) this.arr.stream()
                .mapToDouble(a -> {
                    if(flag == FLAG_CARB){
                        return a.getKhoiLuong()/100.0f*a.getCarb();
                    } else if(flag == FLAG_FAT){
                        return a.getKhoiLuong()/100.0f*a.getFat();
                    } else if(flag == FLAG_FAT_BH){
                        return a.getKhoiLuong()/100.0f*a.getFatBH();
                    } else if(flag == FLAG_PROTEIN){
                        return a.getKhoiLuong()/100.0f*a.getCarb();
                    } else if(flag == FLAG_CALO){
                        return a.getKhoiLuong()/100.0f*a.getCarb();
                    }
                    throw new IllegalArgumentException("Invalid flag value");
                })
                .sum();

    }

    public void cau2 () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số carb cần thiết cho 1 bữa ăn ");
        int carb = sc.nextInt();
        float nangLuong= tinhNangLuong(1);
        if (carb > nangLuong) {
            System.out.printf("Cơ thể em bo sung thêm %f carb nữa nha", carb - nangLuong);
        }

        System.out.println("Mời bạn nhập số fat cần thiết cho 1 bữa ăn ");
        int fat = sc.nextInt();
        nangLuong= tinhNangLuong(2);
        if (fat > nangLuong) {
            System.out.printf("Cơ thể em bo sung thêm %f carb nữa nha", fat - nangLuong);
        }

        System.out.println("Mời bạn nhập số fat bh cần thiết cho 1 bữa ăn ");
        int fatBH = sc.nextInt();
        nangLuong= tinhNangLuong(3);
        if (fatBH > nangLuong) {
            System.out.printf("Cơ thể em bo sung thêm %f carb nữa nha", fatBH - nangLuong);
        }

        System.out.println("Mời bạn nhập số protein cần thiết cho 1 bữa ăn ");
        int protein = sc.nextInt();
        nangLuong= tinhNangLuong(4);
        if (protein > nangLuong) {
            System.out.printf("Cơ thể em bo sung thêm %f protein nữa nha", protein - nangLuong);
        }

        System.out.println("Mời bạn nhập số calo cần thiết cho 1 bữa ăn ");
        int calo = sc.nextInt();
        nangLuong= tinhNangLuong(5);
        if (calo > nangLuong) {
            System.out.printf("Cơ thể em bo sung thêm %f calo nữa nha", calo - nangLuong);
        }
    }

    public float cau3() {
        if(tinhNangLuong(FLAG_CALO) - 600 > 0) {
            return 30*(tinhNangLuong(FLAG_CALO)-600)/147.5f;
        }
        else {
            return 0;
        }
    }
}
