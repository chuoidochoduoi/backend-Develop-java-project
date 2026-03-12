package business.impl;

import business.IProductService;
import dao.IProductDAO;
import dao.impl.ProductDao;

public class ProductServiceImpl implements IProductService {

    IProductDAO productDAO = new ProductDao();
    @Override

    public void insertProduct(String name,String brand,double price,int stock){
        productDAO.insertProduct(name,brand,price,stock);
    }
    @Override

    public void getAllProduct(){
        productDAO.getAllProduct();
    }
    @Override

    public boolean checkProduct(int id){
        return productDAO.checkProduct(id);
    }
    @Override

    public void updateProduct(int id,String name,String brand,double price,int stock){
        productDAO.updateProduct(id,name,brand,price,stock);
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