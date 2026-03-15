package presentation;

import business.impl.AdminServiceImpI;

import static Validator.InputValidator.inputString;

public class LoginMenu {

    void login() {
        AdminServiceImpI adminService = new AdminServiceImpI();

        while(true){

            System.out.print("Username: ");
            String username = inputString();

            System.out.print("Password: ");
            String password = inputString();

            if(adminService.login(username,password)){
                System.out.println("Đăng nhập thành công!");
                break;
            }else{
                System.out.println("Sai username hoặc password, nhập lại!");
            }
        }

    }
}
