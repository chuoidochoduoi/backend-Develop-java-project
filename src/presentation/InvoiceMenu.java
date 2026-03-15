package presentation;

import Model.Invoice;
import Model.InvoiceDetail;
import business.IInvoiceDetailService;
import business.impl.CustomerServiceImpl;
import business.impl.IIvoiceDetailSerivceImpI;
import business.impl.InvoiceServiceImpl;
import business.impl.ProductServiceImpl;
import dao.IInvoiceDetailDao;
import dao.impl.CustomerDao;
import dao.impl.InvoiceDetailDao;


import java.time.LocalDate;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static Validator.InputValidator.*;

public class InvoiceMenu {


    private InvoiceServiceImpl invoiceService = new InvoiceServiceImpl();
    private IIvoiceDetailSerivceImpI invoiceDetailService = new IIvoiceDetailSerivceImpI();
    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    private ProductServiceImpl productService = new ProductServiceImpl();

    public void menuInvoice() {

        int choice;

        do {

            System.out.println("\n--- MENU HÓA ĐƠN ---");
            System.out.println("1. Tạo hóa đơn");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Tìm kiếm hóa đơn");
            System.out.println("4. Thống kê doanh thu");
            System.out.println("0. Quay lại");

            choice = inputInt();


            switch (choice) {

                case 1:

                    Invoice invoice = new Invoice();

                    double total = 0;

                    System.out.println("\n--- DANH SÁCH KHÁCH HÀNG ---");
                    customerService.getAllCustomer();

                    System.out.print("Chọn customerId: ");
                    int customerId = inputInt();

                    while (!customerService.existsCustomerById(customerId)) {

                        System.out.print("ID không tồn tại, nhập lại: ");
                        customerId = inputInt();
                    }

                    invoice.setCustomerId(customerId);

                    List<InvoiceDetail> details = new LinkedList<>();
                    while (true) {

                        System.out.println("1. Thêm sản phẩm");
                        System.out.println("2. Hoàn tất");

                        int choiceDetail = inputInt();

                        if (choiceDetail == 2) {
                            break;
                        }

                        if (choiceDetail != 1) {
                            continue;
                        }

                        InvoiceDetail detail = new InvoiceDetail();

                        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
                        productService.getAllProduct();

                        int productId = inputInt();

                        while (!productService.existsProductById(productId)) {

                            System.out.print("ID không tồn tại, nhập lại: ");
                            productId = inputInt();
                        }

                        detail.setProductId(productId);

                        System.out.print("Nhập số lượng: ");
                        int quantity = inputInt();
                        detail.setQuantity(quantity);

                        double price = productService.getProductById(productId).getPrice();
                        detail.setPrice(price);

                        total += price * quantity;

                        if ( !productService.updateProductQuantity(productId, quantity)){
                            System.out.println("Stock ko đủ");

                            continue;

                        }

                        details.add(detail);



                    }

                    invoice.setTotal(total);

                    invoiceService.insertInvoice(invoice);

                    int invoiceId = invoiceService.getLastInvoiceId();

                    for (InvoiceDetail d : details) {

                        d.setInvoiceId(invoiceId);
                        invoiceDetailService.insertInvoiceDetail(d);
                    }

                    break;

                case 2:

                    invoiceService.getAllInvoice();

                    System.out.print("Nhập invoice id: ");
                    int invoiceId2 = inputInt();

                    while (!invoiceService.existsInvoiceById(invoiceId2)) {

                        System.out.print("ID không tồn tại, nhập lại: ");
                        invoiceId2 = inputInt();
                    }
                    invoiceDetailService.getAllInvoiceByInvoiceID(invoiceId2);

                    break;

                case 3:

                    System.out.println("""
                            1. Tìm theo tên khách
                            2. Tìm theo ngày
                            """);

                    int searchChoice = inputInt();

                    switch (searchChoice) {

                        case 1:

                            System.out.print("Nhập tên: ");
                            String name = inputString();

                            invoiceService.searchByCustomerName(name);
                            break;

                        case 2:

                            System.out.print("Nhập ngày (yyyy-MM-dd): ");
                            LocalDate date = inputDate();

                            invoiceService.searchByDate(date);
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }

                    break;

                case 4:

                    System.out.println("""
                            1. Doanh thu theo ngày
                            2. Doanh thu theo tháng
                            3. Doanh thu theo năm
                            """);

                    int revChoice = inputInt();

                    if (revChoice == 1)
                        invoiceService.revenueByDay();
                    else if (revChoice == 2)
                        invoiceService.revenueByMonth();
                    else if (revChoice == 3)
                        invoiceService.revenueByYear();

                    break;
            }

        } while (choice != 0);
    }
}
