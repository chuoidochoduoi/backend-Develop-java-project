package business.impl;

import Model.Invoice;
import Model.InvoiceDetail;
import business.IInvoiceDetailService;
import dao.impl.InvoiceDetailDao;

public class IIvoiceDetailSerivceImpI implements IInvoiceDetailService {
  InvoiceDetailDao invoiceDetail =new InvoiceDetailDao();

    @Override
    public void insertInvoiceDetail(InvoiceDetail detail) {
        invoiceDetail.insertInvoiceDetail(detail);
    }

    @Override
    public void getAllInvoiceByInvoiceID(int invoiceId) {
        invoiceDetail.getAllInvoiceByInvoiceID(invoiceId);
    }


}
