package presentation;

import business.impl.AdminServiceImpI;

import static Validator.InputValidator.inputString;

public class LoginMenu {

    void login() {
        AdminServiceImpI adminService = new AdminServiceImpI();

        while (true) {

            System.out.println("========= HỆ THỐNG QUẢN LÝ CỬA HÀNG =========");
            System.out.println("1. Đăng nhập Admin");
            System.out.println("2. Thoát");
            System.out.println("=============================================");

            System.out.print("Nhập lựa chọn: ");
            String choice = inputString();

            if (choice.equals("2")) {
                System.out.println("Thoát chương trình!");
                break;
            }

            if (!choice.equals("1")) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }


            while (true) {
                System.out.println("----- Đăng nhập -----");

                System.out.print("Username: ");
                String username = inputString();

                System.out.print("Password: ");
                String password = inputString();

                if (adminService.login(username, password)) {
                    System.out.println("Đăng nhập thành công!");
                    return; // thoát luôn login
                } else {
                    System.out.println("Sai username hoặc password, nhập lại!");
                }
            }
        }
    }
}
