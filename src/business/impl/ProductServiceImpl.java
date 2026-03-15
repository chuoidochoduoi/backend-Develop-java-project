package business.impl;

import Model.Phone;
import business.IProductService;
import dao.IProductDAO;
import dao.impl.ProductDao;

public class ProductServiceImpl implements IProductService {

    IProductDAO productDAO = new ProductDao();
    @Override
    public void insertProduct(Phone phone){


        productDAO.insertProduct(phone);
    }
    @Override

    public void getAllProduct(){
        productDAO.getAllProduct();
    }
    @Override

    public boolean existsProductById(int id){
        return productDAO.existsProductById(id);
    }

    @Override
    public boolean updateProductQuantity(int productId, int stock) {
        return productDAO.updateProductQuantity(productId,stock);
    }

    @Override
    public Phone getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public void updateProduct(Phone phone){
        productDAO.updateProduct(phone);
    }
    @Override

    public void deleteProduct(int id){
        productDAO.deleteProduct(id);
    }

    @Override
    public void getProductByPrice(double priceStart,double priceEnd){
        productDAO.getProductByPrice(priceStart,priceEnd);
    }

    @Override
    public void getProductByBrand(String brand){
        productDAO.getProductByBrand(brand);
    }

    @Override
    public void getProductByName(String name){
        productDAO.getProductByName(name);
    }
}