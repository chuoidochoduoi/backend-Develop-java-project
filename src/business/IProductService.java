package business;

public interface  IProductService {
    void insertProduct(String name,String brand,double price,int stock);

    void getAllProduct();

    boolean checkProduct(int id);

    void updateProduct(int id,String name,String brand,double price,int stock);

    void deleteProduct(int id);

    void getProductByPrice(double priceStart,double priceEnd);

    void getProductByBrand(String brand);

    void getProductByName(String name);

}
