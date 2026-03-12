package business;

public interface IInvoiceService {

    void insertInvoice(int customerId,double totalAmount);

    void getAllInvoice();

    void searchByCustomerName(String keyword);

    void searchByDate(String date);

    void revenueByDay();

    void revenueByMonth();

    void revenueByYear();
}