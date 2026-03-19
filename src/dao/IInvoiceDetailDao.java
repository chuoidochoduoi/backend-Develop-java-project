package dao;

import Model.Invoice;
import Model.InvoiceDetail;

public interface IInvoiceDetailDao {
    void insertInvoiceDetail(InvoiceDetail detail);

    void getAllInvoiceByInvoiceID(int invoiceId);

    void deleteInvoiceDetailByInvoiceId(int id);


    boolean isProductInInvoice(int productId);
}
