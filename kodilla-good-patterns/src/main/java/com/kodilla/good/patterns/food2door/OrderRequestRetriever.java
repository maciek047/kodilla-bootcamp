package com.kodilla.good.patterns.food2door;
import com.kodilla.good.patterns.food2door.producers.ExtraFoodShop;
import com.kodilla.good.patterns.food2door.producers.GlutenFreeShop;
import com.kodilla.good.patterns.food2door.producers.HealthyShop;
import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        ExtraFoodShop producer1 = new ExtraFoodShop();
        GlutenFreeShop producer2 = new GlutenFreeShop();
        HealthyShop producer3 = new HealthyShop();
        double[] productQuantity = new double[4];
        productQuantity[0] = 12.47;
        productQuantity[1] = 5.0;
        productQuantity[2] = 10.0;
        productQuantity[3] = 11.0;
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Bio Greens",producer1,19.99,100.00));
        productList.add(new Product("Organic Food",producer2,5.55,5.00));
        productList.add(new Product("Vegi Mix", producer2,47.05,27.00));
        productList.add(new Product("Spirulin 120", producer3,3.50,999.0));

        return new OrderRequest(productQuantity,productList);
    }
}
