package business.impl;

import Model.Customer;
import business.ICustomerService;
import dao.ICustomerDAO;
import dao.impl.CustomerDao;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerDAO customerDAO = new CustomerDao();
    @Override

    public void insertCustomer(Customer customer){
        customerDAO.insertCustomer(customer);
    }
    @Override

    public void getAllCustomer(){
        customerDAO.getAllCustomer();
    }
    @Override

    public boolean existsCustomerById(int id){
        return customerDAO.existsCustomerById(id);
    }
    @Override

    public void updateCustomer(Customer customer){
        customerDAO.updateCustomer(customer);
    }
    @Override

    public void deleteCustomer(int id){
        customerDAO.deleteCustomer(id);
    }
}