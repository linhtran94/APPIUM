import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static int number = 10;

    public static void main(String[] args) {

// if else
        System.out.println("vi du if else");
        number = 3;
        if (number == 1) {
            System.out.println("so nay nho hon 2");
            System.out.println("chao ban");
        } else if (number == 2)
            System.out.println("so nay " + number + " lon hon 2");
        else if (number > 2 && number == 3)
            System.out.println("to do something");
        else System.out.println("abc");

// switch key
        System.out.println("vi du switch key");
        int day = 1;
        switch (day) {

            case 1:
                System.out.println("day la ngay 1");
                break;
            case 2:
                System.out.println("day la ngay 2");
                break;
            default:
                System.out.println("day la default");
        }

// for
        System.out.println("vi du for");
        for (int i = 0; i >= 0; i--) {
            System.out.println("i = " + i);
        }

        int array[] = {1, 2, 4, 56, 7};

        for (int i = 1; i < array.length; i++) {
            if (array[i] == 7)
                System.out.println("array[" + i + "] = " + array[i]);
        }

        System.out.println("-----------------");
        for (int number : array) {
            System.out.println(number);
        }
        System.out.println("-------------------");

        // vi du for each lambda8
        List<Integer> integers = new ArrayList<>();
        integers.add(11);
        integers.add(1);
        integers.add(4);
        integers.add(5);
        integers.forEach(e -> {
            System.out.println("e = " + e);
        });


// vi du while
        System.out.println("vi du while");
        int numbers = 10;
        while (numbers >= 1) {
            System.out.println("number van >1");
            System.out.println("numbers = " + numbers);
            numbers--;
        }

        // vi du khi dung continue
        System.out.println("vi du khi dung continue");
        int arrayNumber[] = {1, 2, 4, 56, 7, 9};
        for (int j = 0; j < arrayNumber.length; j++) {
//            System.out.println("j = " + j);
            if (array[j] < 7) {
                continue;

            }
            System.out.println(arrayNumber[j]);
        }

    }


}
