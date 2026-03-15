package utils;

import business.impl.CustomerServiceImpl;
import business.impl.ProductServiceImpl;

import static Validator.InputValidator.inputInt;
import static presentation.MainMenu.sc;

public class MenuHelper {


//    public static int inputValidProductId() {
//        System.out.print("Nhập Id sản phẩm: ");
//        int id = inputInt();
//
//        while (!productDao.existsProductById(id)) {
//            System.out.print("Id không tồn tại, nhập lại: ");
//            id = inputInt();
//        }
//
//        return id;
//    }
//    public static int inputValidCustomerId() {
//        System.out.print("Nhập ID: ");
//
//        int id = sc.nextInt();
//        sc.nextLine();
//
//        while (!customerDao.existsProductById(id)) {
//
//            System.out.print("ID không tồn tại, nhập lại: ");
//
//            id = sc.nextInt();
//            sc.nextLine();
//        }
//    }

    public static boolean confirmDelete() {

        while (true) {

            System.out.print("Bạn có chắc muốn xóa? (1:Yes / 0:No): ");
            int choice =  inputInt();

            if (choice == 1) return true;
            if (choice == 0) return false;

            System.out.println("Chỉ nhập 1 hoặc 0");
        }
    }

}
