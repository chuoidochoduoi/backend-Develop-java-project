package business;

import Model.InvoiceDetail;

public interface IInvoiceDetailService {
    void insertInvoiceDetail(InvoiceDetail detail);
    void getAllInvoiceByInvoiceID(int invoiceId);

    boolean isProductInInvoice(int productId);

}
