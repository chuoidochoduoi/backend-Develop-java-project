package Model;

public class Phone {
    int id;
    String name;
    String brand;
    double price;
    int stock;
    public Phone(int id, String name, String brand, double price, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }


    public void display() {
        System.out.println(id + " | " + name + " | " + brand + " | " + price + " | " + stock);
    }

}
