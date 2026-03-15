package Model;

import static Validator.InputValidator.inputString;

public class Customer {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Customer() {}

    public Customer(int id, String name, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void Input(){
        System.out.print("Nhập tên: ");
         name = inputString();

        while (true) {
            System.out.print("Nhập phone: ");
            phone = inputString();

            if (phone.matches("\\d{9,11}")) {
                break;
            } else {
                System.out.println("Số điện thoại phải là 9-11 chữ số!");
            }
        }

        // email
        while (true) {
            System.out.print("Nhập email: ");
            email = inputString();

            if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                break;
            } else {
                System.out.println("Email không đúng định dạng!");
            }
        }

        System.out.print("Nhập address: ");
         address = inputString();
    }
}