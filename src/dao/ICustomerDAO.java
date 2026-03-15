package dao;

import Model.Customer;

public interface ICustomerDAO {

    void insertCustomer(Customer customer);

    void getAllCustomer();

    boolean existsCustomerById(int id);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
