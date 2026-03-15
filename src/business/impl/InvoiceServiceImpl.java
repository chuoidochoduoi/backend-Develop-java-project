package business.impl;

import Model.Invoice;
import business.IInvoiceService;
import dao.IInvoiceDAO;
import dao.impl.InvoiceDao;

import java.time.LocalDate;
import java.util.Locale;

public class InvoiceServiceImpl implements IInvoiceService {

    IInvoiceDAO invoiceDAO = new InvoiceDao();
    @Override

    public void insertInvoice(Invoice invoice){
        invoiceDAO.insertInvoice(invoice);
    }

    @Override
    public boolean existsInvoiceById(int id) {
        return invoiceDAO.existsInvoiceById(id);
    }

    @Override

    public void getAllInvoice(){
        invoiceDAO.getAllInvoice();
    }
    @Override

    public void searchByCustomerName(String keyword){
        invoiceDAO.searchByCustomerName(keyword);
    }
    @Override

    public void searchByDate(LocalDate date){
        invoiceDAO.searchByDate(date);
    }
    @Override

    public void revenueByDay(){
        invoiceDAO.revenueByDay();
    }
    @Override

    public void revenueByMonth(){
        invoiceDAO.revenueByMonth();
    }
    @Override

    public void revenueByYear(){
        invoiceDAO.revenueByYear();
    }


    @Override
    public int getLastInvoiceId() {
        return invoiceDAO.getLastInvoiceId();
    }

}