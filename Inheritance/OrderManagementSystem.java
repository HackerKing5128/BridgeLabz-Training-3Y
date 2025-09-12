// Base class
class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

// Subclass of Order
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped. Tracking Number: " + trackingNumber;
    }
}

// Subclass of ShippedOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order delivered on " + deliveryDate + ". Tracking Number: " + trackingNumber;
    }
}

// Testing class
public class OrderManagementSystem {
    public static void main(String[] args) {
        Order o1 = new Order(101, "2025-09-01");
        ShippedOrder o2 = new ShippedOrder(102, "2025-09-02", "TRK12345");
        DeliveredOrder o3 = new DeliveredOrder(103, "2025-09-03", "TRK67890", "2025-09-05");

        System.out.println(o1.getOrderStatus());
        System.out.println(o2.getOrderStatus());
        System.out.println(o3.getOrderStatus());
    }
}
