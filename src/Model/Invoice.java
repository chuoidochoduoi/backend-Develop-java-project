package model;

public class Invoice {

    private int id;
    private int customerId;
    private double total;

    public Invoice(){}

    public Invoice(int id,int customerId,double total){
        this.id=id;
        this.customerId=customerId;
        this.total=total;
    }

    public int getId(){ return id;}
    public void setId(int id){ this.id=id;}

    public int getCustomerId(){ return customerId;}
    public void setCustomerId(int customerId){ this.customerId=customerId;}

    public double getTotal(){ return total;}
    public void setTotal(double total){ this.total=total;}

}