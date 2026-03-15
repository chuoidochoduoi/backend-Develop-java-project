package dao;

import Model.Phone;

public interface IProductDAO {

    void insertProduct(Phone phone);

    void getAllProduct();
    boolean updateProductQuantity(int productId, int stock);
    Phone getProductById(int id);
    boolean existsProductById(int id);

    void updateProduct(Phone phone);

    void deleteProduct(int id);

    void getProductByPrice(double start,double end);

    void getProductByBrand(String brand);

    void getProductByName(String name);
}