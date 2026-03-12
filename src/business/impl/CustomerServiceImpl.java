package business.impl;

import business.ICustomerService;
import dao.ICustomerDAO;
import dao.impl.CustomerDao;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerDAO customerDAO = new CustomerDao();
    @Override

    public void insertCustomer(String name,String phone,String email,String address){
        customerDAO.insertCustomer(name,phone,email,address);
    }
    @Override

    public void getAllCustomer(){
        customerDAO.getAllCustomer();
    }
    @Override

    public boolean checkCustomer(int id){
        return customerDAO.checkCustomer(id);
    }
    @Override

    public void updateCustomer(int id,String name,String phone,String email,String address){
        customerDAO.updateCustomer(id,name,phone,email,address);
    }
    @Override

    public void deleteCustomer(int id){
        customerDAO.deleteCustomer(id);
    }
}