package Cart;

public interface CartOperations {

    void addToCart(String productId , int quantity);

    void removeFromCart(String productId,int quantity);

    void viewCart();

}
