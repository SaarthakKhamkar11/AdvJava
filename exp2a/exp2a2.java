import java.util.*; 
class Item { 
    String name; 
    double price; 
    int quantity; 
    public Item(String name, double price, int quantity) { 
        this.name = name; 
        this.price = price; 
        this.quantity = quantity; 
    }
} 
class Order { 
    List<Item> items; 
    String customerEmail; 
    String orderId; 
    public Order(String orderId, List<Item> items, String customerEmail) {
        this.orderId = orderId; 
        this.items = items; 
        this.customerEmail = customerEmail; 
    } 
} 
class OrderDatabase { 
    private Map<String, Order> orderStore = new HashMap<>(); 
    public void save(Order order) { 
        orderStore.put(order.orderId, order); 
        System.out.println("Order saved with ID: " + order.orderId); 
    } 
    public Order load(String orderId) { 
        return orderStore.get(orderId); 
    } 
} 
class OrderPresenter { 
    public String present(Order order) { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("Order ID: ").append(order.orderId).append("\nItems:\n"); 
        for (Item i : order.items) { 
            sb.append("- ").append(i.name).append(", Qty: ").append(i.quantity).append("\n"); 
        } 
        return sb.toString(); 
    } 
} 
class OrderPriceCalculator { 
    public double calculateTotal(Order order) { 
        double total = 0; 
        for (Item i : order.items) { 
            total += i.price * i.quantity; 
        } 
        return total; 
    } 
} 
class OrderEmailPresenter { 
    private OrderPriceCalculator calculator = new OrderPriceCalculator();
    public String formatEmail(Order order) { 
        double total = calculator.calculateTotal(order); 
        StringBuilder sb = new StringBuilder(); 
        sb.append("Dear Customer,\n\n"); 
        sb.append("Thank you for your order. Here is the summary:\n"); 
        for (Item i : order.items) { 
            sb.append("- ").append(i.name) 
              .append(", Qty: ").append(i.quantity) 
              .append(", Price: $").append(i.price).append("\n"); 
        } 
        sb.append("Total Price: $").append(String.format("%.2f", total)).append("\n\n"); 
        sb.append("We appreciate your business!"); 
        return sb.toString(); 
    } 
} 
class OrderEmailService { 
    private OrderEmailPresenter presenter = new OrderEmailPresenter(); 
    public void sendOrderEmail(Order order) { 
        String emailContent = presenter.formatEmail(order); 
        System.out.println("\n--- Sending Email to " + order.customerEmail + " ---"); 
        System.out.println(emailContent); 
        System.out.println("--- Email Sent ---\n"); 
    } 
} 
 
class OrderController {
    private OrderDatabase db = new OrderDatabase(); 
    private OrderPresenter presenter = new OrderPresenter(); 
    private OrderEmailService emailService = new OrderEmailService(); 
    public void createOrder(Order order) { 
        db.save(order); 
        emailService.sendOrderEmail(order); 
    } 
    public void viewOrder(String orderId) { 
        Order order = db.load(orderId); 
        if (order == null) { 
            System.out.println("Order not found: " + orderId); 
            return; 
        } 
        String view = presenter.present(order); 
        System.out.println("\n--- Order View ---"); 
        System.out.println(view); 
    } 
} 
public class exp2a2 { 
    public static void main(String[] args) { 
        List<Item> items = Arrays.asList( 
            new Item("Burger",15.0, 4), 
            new Item("Fries", 10.0, 2), 
            new Item("Milkshake", 8, 2),
            new Item("Wrap",12.0,2)
        ); 
        Order order = new Order("1001", items, "customer@gmail.com"); 
        OrderController controller = new OrderController(); 
        controller.createOrder(order); 
        controller.viewOrder("1001"); 
    } 
}