package opgave3.minihandel;

import lombok.Getter;

import java.util.*;

/**
 * Models an Order with OrderLines and an order number. 
 */
public class Order {
    @Getter
    private int number;
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();
    
    /**
     * Create the order.
     * @param number a sequential number given to each Order in the system. 
     */
    public Order(int number) {
        this.number = number;
    }

    /**
     * Create a new order line with the given product.
     * @param count the amount of products in this line. Must be >= 1.
     * @param product the product ordered.
     */
    public void createOrderLine(int count, Product product) {
        OrderLine line = new OrderLine(orderLines.size() + 1, count, product);
        orderLines.add(line);
    }
    
    public List<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);
    }

    public double getOrderPrice() {
        double price = 0;
        for (OrderLine line : orderLines) {
            price += line.getOrderLinePrice();
        }
        return price;
    }
}
