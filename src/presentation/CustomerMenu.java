package presentation;

import Model.Customer;
import business.impl.CustomerServiceImpl;

import java.util.Scanner;

import static Validator.InputValidator.inputInt;
import static utils.MenuHelper.confirmDelete;

public class CustomerMenu {

    public  CustomerServiceImpl customerDao = new CustomerServiceImpl();

    public void menuCustomer() {

        int choice;
        Customer customer = new Customer();

        do {

            System.out.println("\n--- MENU QUẢN LÝ KHÁCH HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị khách hàng");
            System.out.println("3. Update khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("0. Quay lại");

            System.out.print("Nhập lựa chọn: ");

            choice = inputInt();


            switch (choice) {

                case 1:

                    System.out.println("\n--- THÊM KHÁCH HÀNG ---");

                    customer.Input();

                    customerDao.insertCustomer(customer);

                    System.out.println("Thêm khách hàng thành công");

                    break;

                case 2:

                    System.out.println("\n--- DANH SÁCH KHÁCH HÀNG ---");

                    customerDao.getAllCustomer();

                    break;

                case 3:

                    System.out.println("\n--- UPDATE KHÁCH HÀNG ---");

                    System.out.print("Nhập ID: ");

                    int id = inputInt();


                    while (!customerDao.existsCustomerById(id)) {

                        System.out.print("ID không tồn tại, nhập lại: ");

                        id = inputInt();
                    }

                   customer.setId(id);
                    customer.Input();

                    customerDao.updateCustomer(customer);

                    System.out.println("Update thành công");

                    break;

                case 4:

                    System.out.println("\n--- XÓA KHÁCH HÀNG ---");

                    System.out.print("Nhập ID: ");


                    int idDelete = inputInt();


                    while (!customerDao.existsCustomerById(idDelete)) {

                        System.out.print("ID không tồn tại, nhập lại: ");

                        idDelete = inputInt();
                    }

                    System.out.println("nếu xóa thì sẽ xóa hết tất cả invoice liên quan đến customer");

                    if (confirmDelete()) {
                        customerDao.deleteCustomer(idDelete);
                        System.out.println("Xóa thành công");
                    } else {
                        System.out.println("Xóa thất bại");

                    }

                    break;

            }

        } while (choice != 0);

    }
}
