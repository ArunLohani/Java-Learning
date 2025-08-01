
        import Cart.ShoppingCart;
import Inventory.Inventory;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        ShoppingCart cart = new ShoppingCart();
        boolean running = true;
        while (running) {

            System.out.println("1. Add Product to Inventory");
            System.out.println("2. View Inventory");
            System.out.println("3. Remove Product from Inventory");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. Remove Product from Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    inventory.addProduct();
                    break;
                case "2":
                    inventory.viewInventory();
                    break;
                case "3":
                    inventory.removeProduct();
                    break;
                case "4":
                    System.out.print("Enter Product ID to add to cart: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int addQty = Integer.parseInt(scanner.nextLine());
                    cart.addToCart(addId, addQty);
                    break;
                case "5":
                    System.out.print("Enter Product ID to remove from cart: ");
                    String remId = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    int remQty = Integer.parseInt(scanner.nextLine());
                    cart.removeFromCart(remId, remQty);
                    break;
                case "6":
                    cart.viewCart();
                    break;
                case "7":
                    running = false;
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}











