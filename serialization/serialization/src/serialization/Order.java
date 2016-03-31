/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arissetyawan
 */
public class Order implements Serializable{
    final private String FILE = "D:/java-lanjutan/serialization/Order.obj";
    List<Product> items = new ArrayList<Product>();

    public static void main(String[] argv)
    {
        Order o = new Order();
        o.addItems();
        o.readItems();
    }

    protected void addItems()
    {
        Product laptop = new Product("Laptop", 20, 70000000);
        laptop.buy(2);
        items.add(laptop);

        Product mouse = new Product("mouse", 120, 200000);
        mouse.buy(3);
        items.add(mouse);

        Product charger = new Product("charger", 3, 300000);
        charger.buy(3);
        items.add(charger);

        try{
            FileOutputStream fos = new FileOutputStream(FILE);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(items);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void readItems(){
        try{ 
            FileInputStream fis = new FileInputStream(FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList products = (ArrayList) ois.readObject();
            System.out.println(products);
            for(Object product: products)
            {
                
                    System.out.println(product.getClass());
                    Product p = (Product) product;
                    System.out.println(p.info());
            }
            ois.close();
            fis.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
