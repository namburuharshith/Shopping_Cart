package com.example.harshith.shoppingcart;

public class Sales {


    private String username;
    private String quantity;
    private String model;
    private String invoiceNumber;

    public Sales(String username,String quantity,String model,String invoiceNumber){
        this.invoiceNumber= invoiceNumber;
        this.model=model;
        this.quantity=quantity;
        this.username=username;
    }

    public String getModel() {
        return model;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getUsername() {
        return username;
    }
}
