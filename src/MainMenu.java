import Model.Phone;
import Service.ProductDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);
    static ProductDao productDao = new ProductDao();
    public static void main(String[] args) {

        int choice;


        do {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Quản lý hóa đơn");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            while (!sc.hasNextInt()) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.next();
                System.out.print("Nhập lại: ");
            }

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    menuProduct();
                    break;
                case 2:
                    menuCustomer();
                    break;
                case 3:
                    menuInvoice();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }

        } while (choice != 0);

    }

    public static void menuProduct() {

        int choice;

        do {
            System.out.println("\n--- MENU QUẢN LÝ Điện thoại ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("0. Quay về menu chính");
            System.out.print("Nhập lựa chọn: ");

            while (!sc.hasNextInt()) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.next();
                System.out.print("Nhập lại: ");
            }

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\n--- THÊM SẢN PHẨM ĐIỆN THOẠI ---");



                    System.out.print("Nhập tên điện thoại: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập hãng: ");
                    String brand = sc.nextLine();

                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nhập số lượng tồn kho: ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    productDao.insertProduct(name, brand, price, stock);


                    System.out.println("Thêm sản phẩm thành công!");
                    break;
                case 2:
                    System.out.println("Chức năng hiển thị sản phẩm");
                    break;
                case 3:
                    System.out.println("Chức năng xóa sản phẩm");
                    break;
                case 0:
                    System.out.println("Quay về menu chính");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    public static void menuCustomer() {

        int choice;

        do {
            System.out.println("\n--- MENU KHÁCH HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị khách hàng");
            System.out.println("0. Quay về menu chính");
            System.out.print("Nhập lựa chọn: ");

            while (!sc.hasNextInt()) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.next();
                System.out.print("Nhập lại: ");
            }

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Chức năng thêm khách hàng");
                    break;
                case 2:
                    System.out.println("Chức năng hiển thị khách hàng");
                    break;
                case 0:
                    System.out.println("Quay về menu chính");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    public static void menuInvoice() {

        int choice;

        do {
            System.out.println("\n--- MENU HÓA ĐƠN ---");
            System.out.println("1. Tạo hóa đơn");
            System.out.println("2. Hiển thị hóa đơn");
            System.out.println("0. Quay về menu chính");
            System.out.print("Nhập lựa chọn: ");

            while (!sc.hasNextInt()) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.next();
                System.out.print("Nhập lại: ");
            }

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Chức năng tạo hóa đơn");
                    break;
                case 2:
                    System.out.println("Chức năng hiển thị hóa đơn");
                    break;
                case 0:
                    System.out.println("Quay về menu chính");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }
}