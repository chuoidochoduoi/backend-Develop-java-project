package business;

import Model.Phone;

public interface  IProductService {

    void insertProduct(Phone phone);

    void getAllProduct();

    boolean existsProductById(int id);

    boolean updateProductQuantity(int productId, int stock);
    Phone getProductById(int id);

    void updateProduct(Phone phone);

    void deleteProduct(int id);

    void getProductByPrice(double priceStart,double priceEnd);

    void getProductByBrand(String brand);

    void getProductByName(String name);

}
