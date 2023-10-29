package opgave3;

import opgave3.minihandel.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestApp {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(0, "Bread", 10));
        products.add(new Product(1, "Butter", 20));
        products.add(new Product(2, "Milk", 30));
        products.add(new Product(3, "Cheese", 40));
        products.add(new Product(4, "Ham", 50));

        for (Product p : products) {
            System.out.println(p);
        }

        Customer c1 = new Customer("Customer 1", LocalDate.of(2011, 1, 1));
        Customer c2 = new Customer("Customer 2", LocalDate.of(2012, 2, 2));

        Order o1 = new Order(1);
        o1.createOrderLine(3, products.get(0));
        o1.createOrderLine(1, products.get(1));
        c1.addOrder(o1);

        Order o2 = new Order(2);
        o2.createOrderLine(2, products.get(2));
        o2.createOrderLine(1, products.get(3));
        c1.addOrder(o2);

        Order o3 = new Order(3);
        o3.createOrderLine(1, products.get(4));
        o3.createOrderLine(1, products.get(0));
        c2.addOrder(o3);

        Order o4 = new Order(4);
        o4.createOrderLine(1, products.get(1));
        o4.createOrderLine(1, products.get(2));
        c2.addOrder(o4);

        Order o5 = new Order(5);
        o5.createOrderLine(100, products.get(3));
        o5.createOrderLine(1, products.get(4));
        c2.addOrder(o5);

        Order o6 = new Order(6);
        o6.createOrderLine(1, products.get(0));
        o6.createOrderLine(1, products.get(1));
        c2.addOrder(o6);

        Discount d1 = new PercentDiscount(15);
        c1.addDiscount(d1);

        Discount d2 = new FixedDiscount(250, 1000);
        c2.addDiscount(d2);

        System.out.println(c1.totalBuy());
        System.out.println(c1.totalBuyWithDiscount());

        System.out.println(c2.totalBuy());
        System.out.println(c2.totalBuyWithDiscount());
    }
}
