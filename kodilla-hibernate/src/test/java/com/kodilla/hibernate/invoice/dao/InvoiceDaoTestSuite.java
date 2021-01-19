package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("Cereal");
        Product product2 = new Product("Milk");
        Product product3 = new Product("Coffee");

        Item item1 = new Item(product1,new BigDecimal(1.25),3,new BigDecimal(3.75));
        Item item2 = new Item(product1,new BigDecimal(1.25),2,new BigDecimal(2.50));
        Item item3 = new Item(product2,new BigDecimal(4.55),1,new BigDecimal(4.55));
        Item item4 = new Item(product3, new BigDecimal(11.99),10,new BigDecimal(119.90));

        Invoice invoice1 = new Invoice("FV 01/2021");
        Invoice invoice2 = new Invoice("FV 02/2021");

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);
        item4.setInvoice(invoice2);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice2.getItems().add(item3);
        invoice2.getItems().add(item4);

        //When

        productDao.save(product1);
        int productId1 = product1.getId();
        productDao.save(product2);
        int productId2 = product2.getId();
        productDao.save(product3);
        int productId3 = product3.getId();

        invoiceDao.save(invoice1);
        int invoiceId1 = invoice1.getId();
        invoiceDao.save(invoice2);
        int invoiceId2 = invoice2.getId();

        //Then
        Assert.assertNotEquals(0, productId1);
        Assert.assertNotEquals(0, productId2);
        Assert.assertNotEquals(0, productId3);

        Assert.assertNotEquals(0, invoiceId1);
        Assert.assertNotEquals(0, invoiceId2);

        //CleanUp
        try {
            productDao.deleteById(productId1);
            productDao.deleteById(productId2);
            productDao.deleteById(productId3);
            invoiceDao.deleteById(invoiceId1);
            invoiceDao.deleteById(invoiceId2);
        } catch (Exception e) {
            //do nothing
        }
    }
}
