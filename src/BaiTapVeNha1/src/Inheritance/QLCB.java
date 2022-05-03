package BaiTapVeNha1.src.Inheritance;

import java.util.ArrayList;
import java.util.List;

public class QLCB {
    List<CanBo> canBos = new ArrayList<>();

    public void themCanBo(CanBo canBo) {
        canBos.add(canBo);
        System.out.println("Them Can Bo thanh cong!");

    }

    public void hienThiCanBo() {
        for (int i = 0; i < canBos.size(); i++) {
            System.out.println(canBos.get(i).toString());
        }

        System.out.println("=========");

        for (CanBo cb:canBos) {
            System.out.println("Thong tin Can Bo => " + cb.toString());
        }
        System.out.println("---------");
        canBos.forEach(cb -> {
            System.out.println("Thong tin Can Bo" + cb.toString());
        });
    }
}
