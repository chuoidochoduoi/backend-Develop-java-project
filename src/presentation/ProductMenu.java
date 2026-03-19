package presentation;

import Model.InvoiceDetail;
import Model.Phone;
import business.IInvoiceDetailService;
import business.impl.IIvoiceDetailSerivceImpI;
import business.impl.ProductServiceImpl;

import java.util.Scanner;

import static Validator.InputValidator.*;
import static Validator.InputValidator.inputDouble;
import static presentation.MainMenu.sc;
import static utils.MenuHelper.confirmDelete;
import static utils.TablePrinter.printProductTable;

public class ProductMenu {

    public  ProductServiceImpl productService = new ProductServiceImpl();

    public IIvoiceDetailSerivceImpI detailService = new IIvoiceDetailSerivceImpI();

    public void menuProduct() {

        int choice;
        Phone phone = new Phone();

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

            choice = inputInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÊM SẢN PHẨM ĐIỆN THOẠI ---");

                    phone.input();
                    productService.insertProduct(phone);
                    System.out.println("Thêm sản phẩm thành công!");
                    break;
                case 2:

                    System.out.println("\n--- hiện thị SẢN PHẨM ĐIỆN THOẠI ---");


                    productService.getAllProduct();


                    break;
                case 3:
                    System.out.println("\n--- update SẢN PHẨM ĐIỆN THOẠI ---");
                    System.out.println("Điền id product");
                    int id3 = inputInt();


                    while (!productService.existsProductById(id3)) {

                        System.out.print("ID không tồn tại, nhập lại: ");

                        id3 = inputInt();
                    }

                    phone.setId(id3);
                    phone.input();
                    productService.updateProduct(phone);

                    break;
                case 4:
                    System.out.println("\n--- xóa SẢN PHẨM ĐIỆN THOẠI ---");

                    int id4 ;
                    while (true) {
                        System.out.print("Nhập product ID cần xóa: ");
                        id4 = inputInt();

                        if (detailService.isProductInInvoice(id4)) {
                            System.out.println("Product đã tồn tại trong invoice, không thể xóa. Nhập lại!");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Điền id product");




                    while (!productService.existsProductById(id4)) {

                        System.out.print("ID không tồn tại, nhập lại: ");

                        id4 = inputInt();
                    }

                    if (confirmDelete()) {
                        productService.deleteProduct(id4);
                        System.out.println("Xóa thành công");
                    } else {
                        System.out.println("Xóa thất bại");

                    }


                    break;
                case 5:

                    while (true) {

                        System.out.println("""
                                --- MENU TÌM KIẾM ĐIỆN THOẠI ---
                                1. Tìm kiếm theo Brand
                                2. Tìm kiếm theo Price
                                3. Tìm kiếm theo Name
                                0. Quay lại
                                """);

                        System.out.print("Nhập lựa chọn: ");

                        switch (inputInt()) {

                            case 1:
                                System.out.println("Điền brand name");

                                productService.getProductByBrand(inputString());
                                break;

                            case 2:
                                System.out.println("giới hạn đầu");
                               double first =inputDouble();
                                System.out.println("giới hạn cuối");

                                double end  =inputDouble();

                                productService.getProductByPrice(first, end);
                                break;

                            case 3:
                                System.out.print("Nhập tên: ");

                                productService.getProductByName(inputString());
                                break;

                            case 0:
                                return;

                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    }

                case 0:
                    System.out.println("Quay về menu chính");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }
}
