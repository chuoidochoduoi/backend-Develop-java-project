package Model;

import java.util.Scanner;

import static Validator.InputValidator.*;

public class Phone {
    int id;
    String name;
    String brand;
    double price;
    int stock;

    public Phone() {}
    public Phone(int id, String name, String brand, double price, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void input() {


        System.out.print("Nhập tên điện thoại: ");
        name = inputString();

        System.out.print("Nhập hãng: ");
        brand = inputString();

        System.out.print("Nhập giá: ");
        price = inputDouble();

        System.out.print("Nhập số lượng tồn kho: ");
        stock = inputInt();
    }



    public void display() {
        System.out.println(id + " | " + name + " | " + brand + " | " + price + " | " + stock);
    }

}
