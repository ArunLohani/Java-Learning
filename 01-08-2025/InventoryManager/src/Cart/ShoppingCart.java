
package Cart;
import Inventory.Inventory;
import Product.Product;
import java.util.LinkedHashMap;
import java.util.Map;
public class ShoppingCart implements CartOperations {
    private final LinkedHashMap<Product, Integer> cart = new LinkedHashMap<>();
    @Override
    public void addToCart(String productId, int quantity) {
        Product product = Inventory.getProductById(productId);
        if (product == null) {
            System.out.println("Product ID not found in inventory.");
            return;
        }
        int available = Inventory.getQuantity(productId);
        if (available < quantity) {
            System.out.println("Not enough stock. Available: " + available);
            return;
        }
        Inventory.reduceStock(productId, quantity);
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        System.out.println(+ quantity + " x " + product.getProductName() + " added to cart.");
    }
    @Override
    public void removeFromCart(String productId, int quantity) {
        Product toRemove = null;
        for (Product p : cart.keySet()) {
            if (p.getProductId().equals(productId)) {
                toRemove = p;
                break;
            }
        }
        if (toRemove == null) {
            System.out.println("Product not found in cart.");
            return;
        }
        int currentQty = cart.get(toRemove);
        if (quantity >= currentQty) {
            cart.remove(toRemove);
            Inventory.increaseStock(toRemove.getProductId(), currentQty);
            System.out.println("Product removed entirely from cart.");
        } else {
            cart.put(toRemove, currentQty - quantity);
            Inventory.increaseStock(toRemove.getProductId(), quantity);
            System.out.println("Removed " + quantity + " of " + toRemove.getProductName());
        }
    }
    @Override
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        float total = 0;
        System.out.println("Cart Contents:");
        System.out.println("ID\tName\t\tCategory\tPrice\tQty\tSubtotal");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            float subtotal = p.getProductPrice() * qty;
            total += subtotal;
            System.out.printf("%s\t%s\t%s\t₹%.2f\t%d\t₹%.2f%n",
                    p.getProductId(), p.getProductName(), p.getProductCategory(), p.getProductPrice(), qty, subtotal);
        }
        System.out.println("Total Amount: ₹" + total);
    }
}