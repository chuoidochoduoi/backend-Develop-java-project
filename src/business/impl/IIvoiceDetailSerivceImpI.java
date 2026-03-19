package business.impl;

import Model.Invoice;
import Model.InvoiceDetail;
import business.IInvoiceDetailService;
import dao.IInvoiceDetailDao;
import dao.impl.InvoiceDetailDao;

public class IIvoiceDetailSerivceImpI implements IInvoiceDetailService {
  IInvoiceDetailDao invoiceDetail =new InvoiceDetailDao();

    @Override
    public void insertInvoiceDetail(InvoiceDetail detail) {
        invoiceDetail.insertInvoiceDetail(detail);
    }

    @Override
    public void getAllInvoiceByInvoiceID(int invoiceId) {
        invoiceDetail.getAllInvoiceByInvoiceID(invoiceId);
    }

    @Override
    public boolean isProductInInvoice(int productId) {
        return invoiceDetail.isProductInInvoice(productId);
    }


}
