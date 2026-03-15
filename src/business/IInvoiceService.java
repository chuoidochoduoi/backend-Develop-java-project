package business;

import Model.Invoice;

import java.time.LocalDate;

public interface IInvoiceService {

    void insertInvoice(Invoice invoice);

    boolean existsInvoiceById(int id);

    void getAllInvoice();

    void searchByCustomerName(String keyword);

    void searchByDate(LocalDate date);

    void revenueByDay();

    void revenueByMonth();

    void revenueByYear();

    int getLastInvoiceId();
}