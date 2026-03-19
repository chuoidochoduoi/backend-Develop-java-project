package business.impl;

import Model.Customer;
import business.ICustomerService;
import dao.ICustomerDAO;
import dao.IInvoiceDAO;
import dao.impl.CustomerDao;
import dao.impl.InvoiceDao;
import dao.impl.InvoiceDetailDao;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerDAO customerDAO = new CustomerDao();

    IInvoiceDAO invoiceDAO = new InvoiceDao();

    InvoiceDetailDao invoiceDetail =new InvoiceDetailDao();


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


        invoiceDetail.deleteInvoiceDetailByInvoiceId(id);

        invoiceDAO.deleteInvoiceByCustomerId(id);



        customerDAO.deleteCustomer(id);
    }
}