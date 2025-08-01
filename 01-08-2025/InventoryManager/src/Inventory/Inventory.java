
package Inventory;
import Product.Product;
import java.util.*;
public class Inventory {
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final HashMap<String, Integer> inventoryQuantities = new HashMap<>();
    private static final HashSet<String> addedProductIds = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    public void addProduct() {
        System.out.print("Enter Product Name: ");
        String productName = sc.nextLine();
        System.out.print("Enter Product Category: ");
        String productCategory = sc.nextLine();
        System.out.print("Enter Product Price: ");
        float price = Float.parseFloat(sc.nextLine());

        System.out.print("Enter Initial Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Product product = new Product(productName, productCategory, price);

        if (addedProductIds.contains(product.getProductId())) {
            System.out.println("Product already exists in inventory.");
            return;
        }
        products.add(product);
        inventoryQuantities.put(product.getProductId(), quantity);
        addedProductIds.add(product.getProductId());
        System.out.println("Product" +  product.getProductId() + "added");
    }
    public void viewInventory() {

        System.out.println("ID\tName\t\tCategory\tQty\tPrice");
        for (Product p : products) {
            String id = p.getProductId();
            System.out.printf("%s\t%s\t%s\t%d\t₹%.2f%n",
                    id, p.getProductName(), p.getProductCategory(), inventoryQuantities.get(id), p.getProductPrice());
        }
    }
    public void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        String productId = sc.nextLine();
        boolean removed = products.removeIf(p -> p.getProductId().equals(productId));
        if (removed) {
            inventoryQuantities.remove(productId);
            addedProductIds.remove(productId);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static Product getProductById(String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) return p;
        }
        return null;
    }

    public static int getQuantity(String productId) {
        return inventoryQuantities.getOrDefault(productId, 0);
    }

    public static void reduceStock(String productId, int quantity) {
        inventoryQuantities.put(productId, getQuantity(productId) - quantity);
    }

    public static void increaseStock(String productId, int quantity) {
        inventoryQuantities.put(productId, getQuantity(productId) + quantity);
    }
}