/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.Serializable;

/**
 *
 * @author arissetyawan
 */
public class Product implements Serializable {
    protected String name;
    protected Integer price;
    protected Integer stock;
    protected Integer total;
    protected Integer diskon;
    protected Integer bayar;
    private Integer quantity;
    

    Product(String name, Integer stock, Integer price)
    {
        this.stock = stock;
        this.name = name;
        this.price = price;
    }

    protected String info(){
        return "Name: " + this.name +", Price: " + this.price +", QTY: " + 
                this.quantity + ", Total: " + this.total + ", Stock: " + this.stock +", Jumlah Diskon = Rp."+this.diskon+", Jumlah Bayar = Rp."+this.bayar;
    }

    protected Integer buy(Integer quantity)
    {
       
        this.quantity = quantity;
        this.total = quantity * this.price;
        this.stock -= quantity;
        this.diskon = this.total * 10/100;
        this.bayar = this.total - this.diskon;
        return this.total;
    }
    
    protected Integer getTotal()
    {
        return this.total;
    }
}
