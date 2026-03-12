package dao;

public interface IProductDAO {

    void insertProduct(String name, String brand, double price, int stock);

    void getAllProduct();

    boolean checkProduct(int id);

    void updateProduct(int id,String name,String brand,double price,int stock);

    void deleteProduct(int id);

    void getProductByPrice(double start,double end);

    void getProductByBrand(String brand);

    void getProductByName(String name);
}