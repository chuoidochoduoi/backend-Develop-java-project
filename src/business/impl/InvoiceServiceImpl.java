package business.impl;

import business.IInvoiceService;
import dao.IInvoiceDAO;
import dao.impl.InvoiceDao;

public class InvoiceServiceImpl implements IInvoiceService {

    IInvoiceDAO invoiceDAO = new InvoiceDao();
    @Override

    public void insertInvoice(int customerId,double totalAmount){
        invoiceDAO.insertInvoice(customerId,totalAmount);
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

    public void searchByDate(String date){
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
}