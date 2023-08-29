package opgave3.minihandel;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a Customer with Orders.
 */
public class Customer {
    @Getter
    private final LocalDate birthday;
    private final List<Order> orders = new ArrayList<>();
    private final List<Discount> discounts = new ArrayList<>();
    @Getter
    private String name;

    /**
     * Create a new Customer.
     *
     * @param name     the name.
     * @param birthday birthday of the customer.
     */
    public Customer(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public List<Discount> getDiscounts() {
        return new ArrayList<>(discounts);
    }

    public void addOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void addDiscount(Discount discount) {
        if (!discounts.contains(discount)) {
            discounts.add(discount);
        }
    }

    public void removeDiscount(Discount discount) {
        discounts.remove(discount);
    }

    public double totalBuy() {
        double total = 0;
        for (Order order : orders) {
            total += order.getOrderPrice();
        }
        return total;
    }

    public double totalBuyWithDiscount() {
        double total = 0;
        for (Order order : orders) {
            total += order.getOrderPrice();
        }
        double bought = total;
        for (Discount discount : discounts) {
            total -= discount.getDiscount(bought);
        }
        return total;
    }
}
