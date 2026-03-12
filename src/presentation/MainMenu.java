package presentation;

import business.impl.ProductServiceImpl;
import business.impl.CustomerServiceImpl;
import business.impl.InvoiceServiceImpl;

import java.util.Scanner;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);
    static ProductServiceImpl productDao = new ProductServiceImpl();
    static CustomerServiceImpl customerDao = new CustomerServiceImpl();
    static InvoiceServiceImpl invoiceDao = new InvoiceServiceImpl();
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
            System.out.println("3. update sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. tìm sản phẩm");
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

                    System.out.println("\n--- hiện thị SẢN PHẨM ĐIỆN THOẠI ---");


                    productDao.getAllProduct();


                    break;
                case 3:
                    System.out.println("\n--- update SẢN PHẨM ĐIỆN THOẠI ---");

                    System.out.print("Nhập Id cần sửa: ");

                    int id3 = sc.nextInt();
                    sc.nextLine();
                    while ( !productDao.checkProduct(id3)){
                        System.out.print(" Id không tồn tại nhập lại: ");

                         id3 = sc.nextInt();
                        sc.nextLine();
                    }


                    System.out.print("Nhập tên điện thoại: ");
                    String name3 = sc.nextLine();

                    System.out.print("Nhập hãng: ");
                    String brand3 = sc.nextLine();

                    System.out.print("Nhập giá: ");
                    double price3 = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nhập số lượng tồn kho: ");
                    int stock3 = sc.nextInt();
                    sc.nextLine();
                    productDao.updateProduct(id3,name3, brand3, price3, stock3);

                    break;
                case 4:
                    System.out.println("\n--- xóa SẢN PHẨM ĐIỆN THOẠI ---");
                    System.out.print("Nhập Id cần sửa: ");

                    int id4 = sc.nextInt();
                    sc.nextLine();
                    while ( !productDao.checkProduct(id4)){
                        System.out.print(" Id không tồn tại nhập lại: ");

                        id4 = sc.nextInt();
                        sc.nextLine();

                    }



                    while (true){
                        System.out.print(" bạn có chắc muốn xóa ko, ấn 1 để xóa, ấn 0 để hủy ");
                        int choiceXacdinh = sc.nextInt();
                        if(choiceXacdinh==1){
                            productDao.deleteProduct(id4);
                            break;
                        }else if (choiceXacdinh==0) {
                            break;
                        }
                        System.out.print(" nhập 1 hoặc 2 ");

                    }


                    break;
                case 5:

                    while (true){


                        System.out.println("""
    --- MENU TÌM KIẾM ĐIỆN THOẠI ---
    1. Tìm kiếm theo Brand
    2. Tìm kiếm theo Price
    3. Tìm kiếm theo Name
    0. Quay lại
    Nhập lựa chọn:\s""");
                        int choice5 = sc.nextInt();
                        sc.nextLine();
                        if (choice5==1){
                            System.out.println("\n--- Tìm kiếm điện thoại theo Brand(Nhãn hàng) ---");

                            String brand5 = sc.nextLine();

                            productDao.getProductByBrand(brand5);

                        }
                        else if (choice5==2) {
                            System.out.println("\n--- Tìm kiếm điện thoại theo price---");
                            System.out.print(" nhập khoảng đầu  ");

                            int start5  = sc.nextInt();
                            sc.nextLine();
                            System.out.print(" nhập khoảng sau  ");

                            int end5 = sc.nextInt();
                            sc.nextLine();
                            productDao.getProductByPrice(start5,end5);

                        }
                        else if (choice5==3) {
                            System.out.println("\n--- Tìm kiếm điện thoại theo tên---");


                            String name5 = sc.nextLine();

                            productDao.getProductByName(name5);

                        } else if (choice5==0) {
                            break;
                        }


                    }


                    break;

                case 0:
                    System.out.println("Quay về menu chính");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    public static void menuCustomer(){

        int choice;

        do {

            System.out.println("\n--- MENU QUẢN LÝ KHÁCH HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị khách hàng");
            System.out.println("3. Update khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("0. Quay lại");

            System.out.print("Nhập lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.println("\n--- THÊM KHÁCH HÀNG ---");

                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Nhập email: ");
                    String email = sc.nextLine();

                    System.out.print("Nhập address: ");
                    String address = sc.nextLine();

                    customerDao.insertCustomer(name,phone,email,address);

                    System.out.println("Thêm khách hàng thành công");

                    break;

                case 2:

                    System.out.println("\n--- DANH SÁCH KHÁCH HÀNG ---");

                    customerDao.getAllCustomer();

                    break;

                case 3:

                    System.out.println("\n--- UPDATE KHÁCH HÀNG ---");

                    System.out.print("Nhập ID: ");

                    int id = sc.nextInt();
                    sc.nextLine();

                    while(!customerDao.checkCustomer(id)){

                        System.out.print("ID không tồn tại, nhập lại: ");

                        id = sc.nextInt();
                        sc.nextLine();
                    }

                    System.out.print("Nhập tên mới: ");
                    String nameU = sc.nextLine();

                    System.out.print("Nhập phone mới: ");
                    String phoneU = sc.nextLine();

                    System.out.print("Nhập email mới: ");
                    String emailU = sc.nextLine();

                    System.out.print("Nhập address mới: ");
                    String addressU = sc.nextLine();

                    customerDao.updateCustomer(id,nameU,phoneU,emailU,addressU);

                    System.out.println("Update thành công");

                    break;

                case 4:

                    System.out.println("\n--- XÓA KHÁCH HÀNG ---");

                    System.out.print("Nhập ID: ");

                    int idDelete = sc.nextInt();
                    sc.nextLine();

                    while(!customerDao.checkCustomer(idDelete)){

                        System.out.print("ID không tồn tại, nhập lại: ");

                        idDelete = sc.nextInt();
                        sc.nextLine();
                    }

                    System.out.print("Bạn chắc chắn muốn xóa? (1.Yes / 0.No): ");

                    int confirm = sc.nextInt();

                    if(confirm == 1){

                        customerDao.deleteCustomer(idDelete);

                        System.out.println("Xóa thành công");
                    }

                    break;

            }

        }while(choice != 0);

    }
    public static void menuInvoice() {

        int choice;

        do {

            System.out.println("\n--- MENU HÓA ĐƠN ---");
            System.out.println("1. Tạo hóa đơn");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Tìm kiếm hóa đơn");
            System.out.println("4. Thống kê doanh thu");
            System.out.println("0. Quay lại");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Nhập Customer ID: ");
                    int customerId = sc.nextInt();

                    System.out.print("Nhập tổng tiền: ");
                    double total = sc.nextDouble();

                    invoiceDao.insertInvoice(customerId, total);

                    break;

                case 2:

                    invoiceDao.getAllInvoice();

                    break;

                case 3:

                    System.out.println("""
                        1. Tìm theo tên khách
                        2. Tìm theo ngày
                        """);

                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    if (searchChoice == 1) {

                        System.out.print("Nhập tên: ");
                        String name = sc.nextLine();

                        invoiceDao.searchByCustomerName(name);

                    } else if (searchChoice == 2) {

                        System.out.print("Nhập ngày (yyyy-mm-dd): ");
                        String date = sc.nextLine();

                        invoiceDao.searchByDate(date);

                    }

                    break;

                case 4:

                    System.out.println("""
                        1. Doanh thu theo ngày
                        2. Doanh thu theo tháng
                        3. Doanh thu theo năm
                        """);

                    int revChoice = sc.nextInt();

                    if (revChoice == 1)
                        invoiceDao.revenueByDay();
                    else if (revChoice == 2)
                        invoiceDao.revenueByMonth();
                    else if (revChoice == 3)
                        invoiceDao.revenueByYear();

                    break;
            }

        } while (choice != 0);
    }
}