package presentation;


import java.util.Scanner;

import static Validator.InputValidator.inputInt;


public class MainMenu {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        CustomerMenu customerMenu = new CustomerMenu();
        InvoiceMenu invoiceMenu = new InvoiceMenu();
        ProductMenu productMenu = new ProductMenu();
        LoginMenu loginMenu = new LoginMenu();

        loginMenu.login();


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

            choice = inputInt();

            switch (choice) {
                case 1:
                    productMenu.menuProduct();
                    break;
                case 2:
                    customerMenu.menuCustomer();
                    break;
                case 3:
                    invoiceMenu.menuInvoice();
                    break;

                case 0:
                    System.out.println("Thoát .");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }

        } while (choice != 0);

    }





}