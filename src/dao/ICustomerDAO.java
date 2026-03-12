package dao;

public interface ICustomerDAO {

    void insertCustomer(String name,String phone,String email,String address);

    void getAllCustomer();

    boolean checkCustomer(int id);

    void updateCustomer(int id,String name,String phone,String email,String address);

    void deleteCustomer(int id);
}
